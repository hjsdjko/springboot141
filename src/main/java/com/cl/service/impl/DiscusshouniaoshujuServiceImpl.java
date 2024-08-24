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


import com.cl.dao.DiscusshouniaoshujuDao;
import com.cl.entity.DiscusshouniaoshujuEntity;
import com.cl.service.DiscusshouniaoshujuService;
import com.cl.entity.view.DiscusshouniaoshujuView;

@Service("discusshouniaoshujuService")
public class DiscusshouniaoshujuServiceImpl extends ServiceImpl<DiscusshouniaoshujuDao, DiscusshouniaoshujuEntity> implements DiscusshouniaoshujuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusshouniaoshujuEntity> page = this.selectPage(
                new Query<DiscusshouniaoshujuEntity>(params).getPage(),
                new EntityWrapper<DiscusshouniaoshujuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusshouniaoshujuEntity> wrapper) {
		  Page<DiscusshouniaoshujuView> page =new Query<DiscusshouniaoshujuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusshouniaoshujuView> selectListView(Wrapper<DiscusshouniaoshujuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusshouniaoshujuView selectView(Wrapper<DiscusshouniaoshujuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
