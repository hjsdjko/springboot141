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

import com.cl.entity.QianxiluxianEntity;
import com.cl.entity.view.QianxiluxianView;

import com.cl.service.QianxiluxianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 迁徙路线
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@RestController
@RequestMapping("/qianxiluxian")
public class QianxiluxianController {
    @Autowired
    private QianxiluxianService qianxiluxianService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QianxiluxianEntity qianxiluxian,
		HttpServletRequest request){
        EntityWrapper<QianxiluxianEntity> ew = new EntityWrapper<QianxiluxianEntity>();

		PageUtils page = qianxiluxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qianxiluxian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QianxiluxianEntity qianxiluxian, 
		HttpServletRequest request){
        EntityWrapper<QianxiluxianEntity> ew = new EntityWrapper<QianxiluxianEntity>();

		PageUtils page = qianxiluxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qianxiluxian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QianxiluxianEntity qianxiluxian){
       	EntityWrapper<QianxiluxianEntity> ew = new EntityWrapper<QianxiluxianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qianxiluxian, "qianxiluxian")); 
        return R.ok().put("data", qianxiluxianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QianxiluxianEntity qianxiluxian){
        EntityWrapper< QianxiluxianEntity> ew = new EntityWrapper< QianxiluxianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qianxiluxian, "qianxiluxian")); 
		QianxiluxianView qianxiluxianView =  qianxiluxianService.selectView(ew);
		return R.ok("查询迁徙路线成功").put("data", qianxiluxianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QianxiluxianEntity qianxiluxian = qianxiluxianService.selectById(id);
        return R.ok().put("data", qianxiluxian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QianxiluxianEntity qianxiluxian = qianxiluxianService.selectById(id);
        return R.ok().put("data", qianxiluxian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QianxiluxianEntity qianxiluxian, HttpServletRequest request){
    	qianxiluxian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qianxiluxian);
        qianxiluxianService.insert(qianxiluxian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QianxiluxianEntity qianxiluxian, HttpServletRequest request){
    	qianxiluxian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qianxiluxian);
        qianxiluxianService.insert(qianxiluxian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QianxiluxianEntity qianxiluxian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qianxiluxian);
        qianxiluxianService.updateById(qianxiluxian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qianxiluxianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
