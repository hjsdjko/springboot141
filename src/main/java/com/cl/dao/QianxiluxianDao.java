package com.cl.dao;

import com.cl.entity.QianxiluxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QianxiluxianView;


/**
 * 迁徙路线
 * 
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface QianxiluxianDao extends BaseMapper<QianxiluxianEntity> {
	
	List<QianxiluxianView> selectListView(@Param("ew") Wrapper<QianxiluxianEntity> wrapper);

	List<QianxiluxianView> selectListView(Pagination page,@Param("ew") Wrapper<QianxiluxianEntity> wrapper);
	
	QianxiluxianView selectView(@Param("ew") Wrapper<QianxiluxianEntity> wrapper);
	

}
