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
 * 迁徙路线
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@TableName("qianxiluxian")
public class QianxiluxianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QianxiluxianEntity() {
		
	}
	
	public QianxiluxianEntity(T t) {
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
	 * 路线名称
	 */
					
	private String luxianmingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 起点
	 */
					
	private String qidian;
	
	/**
	 * 终点
	 */
					
	private String zhongdian;
	
	/**
	 * 迁徙方向
	 */
					
	private String qianxifangxiang;
	
	/**
	 * 迁徙时间
	 */
					
	private String qianxishijian;
	
	/**
	 * 迁徙距离
	 */
					
	private String qianxijuli;
	
	/**
	 * 迁徙详情
	 */
					
	private String qianxixiangqing;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：路线名称
	 */
	public void setLuxianmingcheng(String luxianmingcheng) {
		this.luxianmingcheng = luxianmingcheng;
	}
	/**
	 * 获取：路线名称
	 */
	public String getLuxianmingcheng() {
		return luxianmingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：起点
	 */
	public void setQidian(String qidian) {
		this.qidian = qidian;
	}
	/**
	 * 获取：起点
	 */
	public String getQidian() {
		return qidian;
	}
	/**
	 * 设置：终点
	 */
	public void setZhongdian(String zhongdian) {
		this.zhongdian = zhongdian;
	}
	/**
	 * 获取：终点
	 */
	public String getZhongdian() {
		return zhongdian;
	}
	/**
	 * 设置：迁徙方向
	 */
	public void setQianxifangxiang(String qianxifangxiang) {
		this.qianxifangxiang = qianxifangxiang;
	}
	/**
	 * 获取：迁徙方向
	 */
	public String getQianxifangxiang() {
		return qianxifangxiang;
	}
	/**
	 * 设置：迁徙时间
	 */
	public void setQianxishijian(String qianxishijian) {
		this.qianxishijian = qianxishijian;
	}
	/**
	 * 获取：迁徙时间
	 */
	public String getQianxishijian() {
		return qianxishijian;
	}
	/**
	 * 设置：迁徙距离
	 */
	public void setQianxijuli(String qianxijuli) {
		this.qianxijuli = qianxijuli;
	}
	/**
	 * 获取：迁徙距离
	 */
	public String getQianxijuli() {
		return qianxijuli;
	}
	/**
	 * 设置：迁徙详情
	 */
	public void setQianxixiangqing(String qianxixiangqing) {
		this.qianxixiangqing = qianxixiangqing;
	}
	/**
	 * 获取：迁徙详情
	 */
	public String getQianxixiangqing() {
		return qianxixiangqing;
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

}
