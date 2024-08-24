package com.cl.dao;

import com.cl.entity.HouniaozhongleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HouniaozhongleiView;


/**
 * 候鸟种类
 * 
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface HouniaozhongleiDao extends BaseMapper<HouniaozhongleiEntity> {
	
	List<HouniaozhongleiView> selectListView(@Param("ew") Wrapper<HouniaozhongleiEntity> wrapper);

	List<HouniaozhongleiView> selectListView(Pagination page,@Param("ew") Wrapper<HouniaozhongleiEntity> wrapper);
	
	HouniaozhongleiView selectView(@Param("ew") Wrapper<HouniaozhongleiEntity> wrapper);
	

}
