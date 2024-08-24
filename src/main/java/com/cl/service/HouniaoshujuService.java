package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HouniaoshujuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HouniaoshujuView;


/**
 * 候鸟数据
 *
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface HouniaoshujuService extends IService<HouniaoshujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HouniaoshujuView> selectListView(Wrapper<HouniaoshujuEntity> wrapper);
   	
   	HouniaoshujuView selectView(@Param("ew") Wrapper<HouniaoshujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HouniaoshujuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<HouniaoshujuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<HouniaoshujuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<HouniaoshujuEntity> wrapper);



}

