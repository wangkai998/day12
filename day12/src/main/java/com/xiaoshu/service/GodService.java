package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.GodMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.God;
import com.xiaoshu.entity.GodVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class GodService {
	@Autowired
	private GodMapper godMapper;

	public PageInfo<GodVo> findGodPage(GodVo godVo, Integer pageNum, Integer pageSize, String ordername, String order) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<GodVo>list=godMapper.findGodPage(godVo); 
		return new PageInfo<>(list);
	}

//	public God existGodName(String name) {
//		// TODO Auto-generated method stub
//		God parm = new God();
//		parm.setName(name);
//		return godMapper.selectOne(parm);
//	}

	public void updateGod(God god) {
		// TODO Auto-generated method stub
		godMapper.updateByPrimaryKeySelective(god);
	}

	public void addGod(God god) {
		// TODO Auto-generated method stub
		godMapper.insert(god);
	}

	public void deleteGod(int parseInt) {
		// TODO Auto-generated method stub
		godMapper.deleteByPrimaryKey(parseInt);
	}

	public List<GodVo> echartsAll() {
		// TODO Auto-generated method stub
		return godMapper.echartsAll();
	}

	public God findCodeAll(String code) {
		// TODO Auto-generated method stub
		God parm = new God();
		parm.setName(code);
		return godMapper.selectOne(parm);
	}


}
