package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.HouniaoshujuEntity;
import com.cl.entity.view.HouniaoshujuView;

import com.cl.service.HouniaoshujuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 候鸟数据
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@RestController
@RequestMapping("/houniaoshuju")
public class HouniaoshujuController {
    @Autowired
    private HouniaoshujuService houniaoshujuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HouniaoshujuEntity houniaoshuju,
		HttpServletRequest request){
        EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();

		PageUtils page = houniaoshujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, houniaoshuju), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HouniaoshujuEntity houniaoshuju, 
		HttpServletRequest request){
        EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();

		PageUtils page = houniaoshujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, houniaoshuju), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HouniaoshujuEntity houniaoshuju){
       	EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( houniaoshuju, "houniaoshuju")); 
        return R.ok().put("data", houniaoshujuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HouniaoshujuEntity houniaoshuju){
        EntityWrapper< HouniaoshujuEntity> ew = new EntityWrapper< HouniaoshujuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( houniaoshuju, "houniaoshuju")); 
		HouniaoshujuView houniaoshujuView =  houniaoshujuService.selectView(ew);
		return R.ok("查询候鸟数据成功").put("data", houniaoshujuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HouniaoshujuEntity houniaoshuju = houniaoshujuService.selectById(id);
        return R.ok().put("data", houniaoshuju);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HouniaoshujuEntity houniaoshuju = houniaoshujuService.selectById(id);
        return R.ok().put("data", houniaoshuju);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        HouniaoshujuEntity houniaoshuju = houniaoshujuService.selectById(id);
        if(type.equals("1")) {
        	houniaoshuju.setThumbsupnum(houniaoshuju.getThumbsupnum()+1);
        } else {
        	houniaoshuju.setCrazilynum(houniaoshuju.getCrazilynum()+1);
        }
        houniaoshujuService.updateById(houniaoshuju);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HouniaoshujuEntity houniaoshuju, HttpServletRequest request){
    	houniaoshuju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(houniaoshuju);
        houniaoshujuService.insert(houniaoshuju);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HouniaoshujuEntity houniaoshuju, HttpServletRequest request){
    	houniaoshuju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(houniaoshuju);
        houniaoshujuService.insert(houniaoshuju);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HouniaoshujuEntity houniaoshuju, HttpServletRequest request){
        //ValidatorUtils.validateEntity(houniaoshuju);
        houniaoshujuService.updateById(houniaoshuju);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        houniaoshujuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    HouniaoshujuEntity houniaoshujuEntity =new HouniaoshujuEntity();
                    houniaoshujuEntity.setId(new Date().getTime());
                    String houniaomingcheng = CommonUtil.getCellValue(row.getCell(0));
                    houniaoshujuEntity.setHouniaomingcheng(houniaomingcheng);
                    String houniaozhonglei = CommonUtil.getCellValue(row.getCell(1));
                    houniaoshujuEntity.setHouniaozhonglei(houniaozhonglei);
                    String guanchariqi = CommonUtil.getCellValue(row.getCell(2));
                    try {
                        houniaoshujuEntity.setGuanchariqi(new SimpleDateFormat("yyyy-MM-dd").parse(guanchariqi));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String guanchadidian = CommonUtil.getCellValue(row.getCell(3));
                    houniaoshujuEntity.setGuanchadidian(guanchadidian);
                    String guanchashuliang = CommonUtil.getCellValue(row.getCell(4));
                    houniaoshujuEntity.setGuanchashuliang(guanchashuliang);
                    String guanchaxingwei = CommonUtil.getCellValue(row.getCell(5));
                    houniaoshujuEntity.setGuanchaxingwei(guanchaxingwei);
                    String lurushijian = CommonUtil.getCellValue(row.getCell(6));
                    try {
                        houniaoshujuEntity.setLurushijian(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(lurushijian));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String luruyuan = CommonUtil.getCellValue(row.getCell(7));
                    houniaoshujuEntity.setLuruyuan(luruyuan);
                     
                    //想数据库中添加新对象
                    houniaoshujuService.insert(houniaoshujuEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }

    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();
        List<Map<String, Object>> result = houniaoshujuService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = houniaoshujuService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();
        List<Map<String, Object>> result = houniaoshujuService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = houniaoshujuService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();
        List<Map<String, Object>> result = houniaoshujuService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,HouniaoshujuEntity houniaoshuju, HttpServletRequest request){
        EntityWrapper<HouniaoshujuEntity> ew = new EntityWrapper<HouniaoshujuEntity>();
        int count = houniaoshujuService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, houniaoshuju), params), params));
        return R.ok().put("data", count);
    }


}
