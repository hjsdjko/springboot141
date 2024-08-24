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


import com.cl.dao.HouniaozhongleiDao;
import com.cl.entity.HouniaozhongleiEntity;
import com.cl.service.HouniaozhongleiService;
import com.cl.entity.view.HouniaozhongleiView;

@Service("houniaozhongleiService")
public class HouniaozhongleiServiceImpl extends ServiceImpl<HouniaozhongleiDao, HouniaozhongleiEntity> implements HouniaozhongleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HouniaozhongleiEntity> page = this.selectPage(
                new Query<HouniaozhongleiEntity>(params).getPage(),
                new EntityWrapper<HouniaozhongleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HouniaozhongleiEntity> wrapper) {
		  Page<HouniaozhongleiView> page =new Query<HouniaozhongleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HouniaozhongleiView> selectListView(Wrapper<HouniaozhongleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HouniaozhongleiView selectView(Wrapper<HouniaozhongleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
