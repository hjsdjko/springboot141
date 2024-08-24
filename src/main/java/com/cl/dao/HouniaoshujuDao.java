package com.cl.dao;

import com.cl.entity.HouniaoshujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HouniaoshujuView;


/**
 * 候鸟数据
 * 
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface HouniaoshujuDao extends BaseMapper<HouniaoshujuEntity> {
	
	List<HouniaoshujuView> selectListView(@Param("ew") Wrapper<HouniaoshujuEntity> wrapper);

	List<HouniaoshujuView> selectListView(Pagination page,@Param("ew") Wrapper<HouniaoshujuEntity> wrapper);
	
	HouniaoshujuView selectView(@Param("ew") Wrapper<HouniaoshujuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HouniaoshujuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HouniaoshujuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HouniaoshujuEntity> wrapper);



}
