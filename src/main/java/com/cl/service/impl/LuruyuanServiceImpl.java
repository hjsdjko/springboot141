package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.LuruyuanDao;
import com.cl.entity.LuruyuanEntity;
import com.cl.service.LuruyuanService;
import com.cl.entity.view.LuruyuanView;

@Service("luruyuanService")
public class LuruyuanServiceImpl extends ServiceImpl<LuruyuanDao, LuruyuanEntity> implements LuruyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LuruyuanEntity> page = this.selectPage(
                new Query<LuruyuanEntity>(params).getPage(),
                new EntityWrapper<LuruyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LuruyuanEntity> wrapper) {
		  Page<LuruyuanView> page =new Query<LuruyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LuruyuanView> selectListView(Wrapper<LuruyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LuruyuanView selectView(Wrapper<LuruyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
