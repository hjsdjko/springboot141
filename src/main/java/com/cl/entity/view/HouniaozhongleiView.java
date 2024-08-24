package com.cl.entity.view;

import com.cl.entity.HouniaozhongleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 候鸟种类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@TableName("houniaozhonglei")
public class HouniaozhongleiView  extends HouniaozhongleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HouniaozhongleiView(){
	}
 
 	public HouniaozhongleiView(HouniaozhongleiEntity houniaozhongleiEntity){
 	try {
			BeanUtils.copyProperties(this, houniaozhongleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
