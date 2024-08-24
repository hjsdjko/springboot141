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


import com.cl.dao.QianxiluxianDao;
import com.cl.entity.QianxiluxianEntity;
import com.cl.service.QianxiluxianService;
import com.cl.entity.view.QianxiluxianView;

@Service("qianxiluxianService")
public class QianxiluxianServiceImpl extends ServiceImpl<QianxiluxianDao, QianxiluxianEntity> implements QianxiluxianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QianxiluxianEntity> page = this.selectPage(
                new Query<QianxiluxianEntity>(params).getPage(),
                new EntityWrapper<QianxiluxianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QianxiluxianEntity> wrapper) {
		  Page<QianxiluxianView> page =new Query<QianxiluxianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QianxiluxianView> selectListView(Wrapper<QianxiluxianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QianxiluxianView selectView(Wrapper<QianxiluxianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
