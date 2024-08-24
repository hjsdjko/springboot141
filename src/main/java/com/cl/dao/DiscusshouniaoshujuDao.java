package com.cl.dao;

import com.cl.entity.DiscusshouniaoshujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusshouniaoshujuView;


/**
 * 候鸟数据评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface DiscusshouniaoshujuDao extends BaseMapper<DiscusshouniaoshujuEntity> {
	
	List<DiscusshouniaoshujuView> selectListView(@Param("ew") Wrapper<DiscusshouniaoshujuEntity> wrapper);

	List<DiscusshouniaoshujuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusshouniaoshujuEntity> wrapper);
	
	DiscusshouniaoshujuView selectView(@Param("ew") Wrapper<DiscusshouniaoshujuEntity> wrapper);
	

}
