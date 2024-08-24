package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusshouniaoshujuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusshouniaoshujuView;


/**
 * 候鸟数据评论表
 *
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface DiscusshouniaoshujuService extends IService<DiscusshouniaoshujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusshouniaoshujuView> selectListView(Wrapper<DiscusshouniaoshujuEntity> wrapper);
   	
   	DiscusshouniaoshujuView selectView(@Param("ew") Wrapper<DiscusshouniaoshujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusshouniaoshujuEntity> wrapper);
   	

}

