package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 候鸟数据
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@TableName("houniaoshuju")
public class HouniaoshujuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HouniaoshujuEntity() {
		
	}
	
	public HouniaoshujuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 候鸟名称
	 */
					
	private String houniaomingcheng;
	
	/**
	 * 候鸟图片
	 */
					
	private String houniaotupian;
	
	/**
	 * 候鸟种类
	 */
					
	private String houniaozhonglei;
	
	/**
	 * 观察日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date guanchariqi;
	
	/**
	 * 观察地点
	 */
					
	private String guanchadidian;
	
	/**
	 * 观察数量
	 */
					
	private String guanchashuliang;
	
	/**
	 * 观察行为
	 */
					
	private String guanchaxingwei;
	
	/**
	 * 拍摄视频
	 */
					
	private String paisheshipin;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 录入时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date lurushijian;
	
	/**
	 * 录入员
	 */
					
	private String luruyuan;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：候鸟名称
	 */
	public void setHouniaomingcheng(String houniaomingcheng) {
		this.houniaomingcheng = houniaomingcheng;
	}
	/**
	 * 获取：候鸟名称
	 */
	public String getHouniaomingcheng() {
		return houniaomingcheng;
	}
	/**
	 * 设置：候鸟图片
	 */
	public void setHouniaotupian(String houniaotupian) {
		this.houniaotupian = houniaotupian;
	}
	/**
	 * 获取：候鸟图片
	 */
	public String getHouniaotupian() {
		return houniaotupian;
	}
	/**
	 * 设置：候鸟种类
	 */
	public void setHouniaozhonglei(String houniaozhonglei) {
		this.houniaozhonglei = houniaozhonglei;
	}
	/**
	 * 获取：候鸟种类
	 */
	public String getHouniaozhonglei() {
		return houniaozhonglei;
	}
	/**
	 * 设置：观察日期
	 */
	public void setGuanchariqi(Date guanchariqi) {
		this.guanchariqi = guanchariqi;
	}
	/**
	 * 获取：观察日期
	 */
	public Date getGuanchariqi() {
		return guanchariqi;
	}
	/**
	 * 设置：观察地点
	 */
	public void setGuanchadidian(String guanchadidian) {
		this.guanchadidian = guanchadidian;
	}
	/**
	 * 获取：观察地点
	 */
	public String getGuanchadidian() {
		return guanchadidian;
	}
	/**
	 * 设置：观察数量
	 */
	public void setGuanchashuliang(String guanchashuliang) {
		this.guanchashuliang = guanchashuliang;
	}
	/**
	 * 获取：观察数量
	 */
	public String getGuanchashuliang() {
		return guanchashuliang;
	}
	/**
	 * 设置：观察行为
	 */
	public void setGuanchaxingwei(String guanchaxingwei) {
		this.guanchaxingwei = guanchaxingwei;
	}
	/**
	 * 获取：观察行为
	 */
	public String getGuanchaxingwei() {
		return guanchaxingwei;
	}
	/**
	 * 设置：拍摄视频
	 */
	public void setPaisheshipin(String paisheshipin) {
		this.paisheshipin = paisheshipin;
	}
	/**
	 * 获取：拍摄视频
	 */
	public String getPaisheshipin() {
		return paisheshipin;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：录入时间
	 */
	public void setLurushijian(Date lurushijian) {
		this.lurushijian = lurushijian;
	}
	/**
	 * 获取：录入时间
	 */
	public Date getLurushijian() {
		return lurushijian;
	}
	/**
	 * 设置：录入员
	 */
	public void setLuruyuan(String luruyuan) {
		this.luruyuan = luruyuan;
	}
	/**
	 * 获取：录入员
	 */
	public String getLuruyuan() {
		return luruyuan;
	}

}
