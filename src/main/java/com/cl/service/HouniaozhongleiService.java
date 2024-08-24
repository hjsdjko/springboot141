package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HouniaozhongleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HouniaozhongleiView;


/**
 * 候鸟种类
 *
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface HouniaozhongleiService extends IService<HouniaozhongleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HouniaozhongleiView> selectListView(Wrapper<HouniaozhongleiEntity> wrapper);
   	
   	HouniaozhongleiView selectView(@Param("ew") Wrapper<HouniaozhongleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HouniaozhongleiEntity> wrapper);
   	

}

