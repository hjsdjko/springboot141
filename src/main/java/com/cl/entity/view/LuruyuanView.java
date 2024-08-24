package com.cl.entity.view;

import com.cl.entity.LuruyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 录入员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@TableName("luruyuan")
public class LuruyuanView  extends LuruyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LuruyuanView(){
	}
 
 	public LuruyuanView(LuruyuanEntity luruyuanEntity){
 	try {
			BeanUtils.copyProperties(this, luruyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
