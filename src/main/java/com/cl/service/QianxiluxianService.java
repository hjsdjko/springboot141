package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QianxiluxianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QianxiluxianView;


/**
 * 迁徙路线
 *
 * @author 
 * @email 
 * @date 2024-01-18 22:50:52
 */
public interface QianxiluxianService extends IService<QianxiluxianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QianxiluxianView> selectListView(Wrapper<QianxiluxianEntity> wrapper);
   	
   	QianxiluxianView selectView(@Param("ew") Wrapper<QianxiluxianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QianxiluxianEntity> wrapper);
   	

}

