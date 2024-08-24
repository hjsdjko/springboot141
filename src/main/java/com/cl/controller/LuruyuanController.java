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

import com.cl.entity.LuruyuanEntity;
import com.cl.entity.view.LuruyuanView;

import com.cl.service.LuruyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 录入员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@RestController
@RequestMapping("/luruyuan")
public class LuruyuanController {
    @Autowired
    private LuruyuanService luruyuanService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		LuruyuanEntity u = luruyuanService.selectOne(new EntityWrapper<LuruyuanEntity>().eq("zhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(u.getId(), username,"luruyuan",  "录入员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody LuruyuanEntity luruyuan){
    	//ValidatorUtils.validateEntity(luruyuan);
    	LuruyuanEntity u = luruyuanService.selectOne(new EntityWrapper<LuruyuanEntity>().eq("zhanghao", luruyuan.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		luruyuan.setId(uId);
        luruyuanService.insert(luruyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        LuruyuanEntity u = luruyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	LuruyuanEntity u = luruyuanService.selectOne(new EntityWrapper<LuruyuanEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        luruyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LuruyuanEntity luruyuan,
		HttpServletRequest request){
        EntityWrapper<LuruyuanEntity> ew = new EntityWrapper<LuruyuanEntity>();

		PageUtils page = luruyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luruyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LuruyuanEntity luruyuan, 
		HttpServletRequest request){
        EntityWrapper<LuruyuanEntity> ew = new EntityWrapper<LuruyuanEntity>();

		PageUtils page = luruyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luruyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LuruyuanEntity luruyuan){
       	EntityWrapper<LuruyuanEntity> ew = new EntityWrapper<LuruyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( luruyuan, "luruyuan")); 
        return R.ok().put("data", luruyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LuruyuanEntity luruyuan){
        EntityWrapper< LuruyuanEntity> ew = new EntityWrapper< LuruyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( luruyuan, "luruyuan")); 
		LuruyuanView luruyuanView =  luruyuanService.selectView(ew);
		return R.ok("查询录入员成功").put("data", luruyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LuruyuanEntity luruyuan = luruyuanService.selectById(id);
        return R.ok().put("data", luruyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LuruyuanEntity luruyuan = luruyuanService.selectById(id);
        return R.ok().put("data", luruyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LuruyuanEntity luruyuan, HttpServletRequest request){
    	luruyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(luruyuan);
    	LuruyuanEntity u = luruyuanService.selectOne(new EntityWrapper<LuruyuanEntity>().eq("zhanghao", luruyuan.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		luruyuan.setId(new Date().getTime());
        luruyuanService.insert(luruyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LuruyuanEntity luruyuan, HttpServletRequest request){
    	luruyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(luruyuan);
    	LuruyuanEntity u = luruyuanService.selectOne(new EntityWrapper<LuruyuanEntity>().eq("zhanghao", luruyuan.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		luruyuan.setId(new Date().getTime());
        luruyuanService.insert(luruyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LuruyuanEntity luruyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(luruyuan);
        luruyuanService.updateById(luruyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        luruyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
