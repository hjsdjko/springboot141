package com.cl.entity.view;

import com.cl.entity.QianxiluxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 迁徙路线
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@TableName("qianxiluxian")
public class QianxiluxianView  extends QianxiluxianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QianxiluxianView(){
	}
 
 	public QianxiluxianView(QianxiluxianEntity qianxiluxianEntity){
 	try {
			BeanUtils.copyProperties(this, qianxiluxianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
