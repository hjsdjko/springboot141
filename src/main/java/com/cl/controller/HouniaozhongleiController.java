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

import com.cl.entity.HouniaozhongleiEntity;
import com.cl.entity.view.HouniaozhongleiView;

import com.cl.service.HouniaozhongleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 候鸟种类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@RestController
@RequestMapping("/houniaozhonglei")
public class HouniaozhongleiController {
    @Autowired
    private HouniaozhongleiService houniaozhongleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HouniaozhongleiEntity houniaozhonglei,
		HttpServletRequest request){
        EntityWrapper<HouniaozhongleiEntity> ew = new EntityWrapper<HouniaozhongleiEntity>();

		PageUtils page = houniaozhongleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, houniaozhonglei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HouniaozhongleiEntity houniaozhonglei, 
		HttpServletRequest request){
        EntityWrapper<HouniaozhongleiEntity> ew = new EntityWrapper<HouniaozhongleiEntity>();

		PageUtils page = houniaozhongleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, houniaozhonglei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HouniaozhongleiEntity houniaozhonglei){
       	EntityWrapper<HouniaozhongleiEntity> ew = new EntityWrapper<HouniaozhongleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( houniaozhonglei, "houniaozhonglei")); 
        return R.ok().put("data", houniaozhongleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HouniaozhongleiEntity houniaozhonglei){
        EntityWrapper< HouniaozhongleiEntity> ew = new EntityWrapper< HouniaozhongleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( houniaozhonglei, "houniaozhonglei")); 
		HouniaozhongleiView houniaozhongleiView =  houniaozhongleiService.selectView(ew);
		return R.ok("查询候鸟种类成功").put("data", houniaozhongleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HouniaozhongleiEntity houniaozhonglei = houniaozhongleiService.selectById(id);
        return R.ok().put("data", houniaozhonglei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HouniaozhongleiEntity houniaozhonglei = houniaozhongleiService.selectById(id);
        return R.ok().put("data", houniaozhonglei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HouniaozhongleiEntity houniaozhonglei, HttpServletRequest request){
    	houniaozhonglei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(houniaozhonglei);
        houniaozhongleiService.insert(houniaozhonglei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HouniaozhongleiEntity houniaozhonglei, HttpServletRequest request){
    	houniaozhonglei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(houniaozhonglei);
        houniaozhongleiService.insert(houniaozhonglei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HouniaozhongleiEntity houniaozhonglei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(houniaozhonglei);
        houniaozhongleiService.updateById(houniaozhonglei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        houniaozhongleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
