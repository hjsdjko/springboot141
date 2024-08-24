package com.cl.entity.view;

import com.cl.entity.DiscusshouniaoshujuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 候鸟数据评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
@TableName("discusshouniaoshuju")
public class DiscusshouniaoshujuView  extends DiscusshouniaoshujuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusshouniaoshujuView(){
	}
 
 	public DiscusshouniaoshujuView(DiscusshouniaoshujuEntity discusshouniaoshujuEntity){
 	try {
			BeanUtils.copyProperties(this, discusshouniaoshujuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
