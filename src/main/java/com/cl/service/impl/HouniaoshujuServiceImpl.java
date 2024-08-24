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


import com.cl.dao.HouniaoshujuDao;
import com.cl.entity.HouniaoshujuEntity;
import com.cl.service.HouniaoshujuService;
import com.cl.entity.view.HouniaoshujuView;

@Service("houniaoshujuService")
public class HouniaoshujuServiceImpl extends ServiceImpl<HouniaoshujuDao, HouniaoshujuEntity> implements HouniaoshujuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HouniaoshujuEntity> page = this.selectPage(
                new Query<HouniaoshujuEntity>(params).getPage(),
                new EntityWrapper<HouniaoshujuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HouniaoshujuEntity> wrapper) {
		  Page<HouniaoshujuView> page =new Query<HouniaoshujuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HouniaoshujuView> selectListView(Wrapper<HouniaoshujuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HouniaoshujuView selectView(Wrapper<HouniaoshujuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<HouniaoshujuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<HouniaoshujuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<HouniaoshujuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
