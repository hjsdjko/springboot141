package com.cl.entity.view;

import com.cl.entity.HouniaoshujuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 候鸟数据
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@TableName("houniaoshuju")
public class HouniaoshujuView  extends HouniaoshujuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HouniaoshujuView(){
	}
 
 	public HouniaoshujuView(HouniaoshujuEntity houniaoshujuEntity){
 	try {
			BeanUtils.copyProperties(this, houniaoshujuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
