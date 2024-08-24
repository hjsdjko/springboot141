package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LuruyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LuruyuanView;


/**
 * 录入员
 *
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface LuruyuanService extends IService<LuruyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LuruyuanView> selectListView(Wrapper<LuruyuanEntity> wrapper);
   	
   	LuruyuanView selectView(@Param("ew") Wrapper<LuruyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LuruyuanEntity> wrapper);
   	

}

