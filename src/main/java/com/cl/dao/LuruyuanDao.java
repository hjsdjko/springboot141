package com.cl.dao;

import com.cl.entity.LuruyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LuruyuanView;


/**
 * 录入员
 * 
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface LuruyuanDao extends BaseMapper<LuruyuanEntity> {
	
	List<LuruyuanView> selectListView(@Param("ew") Wrapper<LuruyuanEntity> wrapper);

	List<LuruyuanView> selectListView(Pagination page,@Param("ew") Wrapper<LuruyuanEntity> wrapper);
	
	LuruyuanView selectView(@Param("ew") Wrapper<LuruyuanEntity> wrapper);
	

}
