package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.GoodtpMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Goodtp;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

import redis.clients.jedis.Jedis;

@Service
public class GoodtpService {
	@Autowired
	private GoodtpMapper goodtpMapper;

	public Object findAll() {
		// TODO Auto-generated method stub
		return goodtpMapper.selectAll();
	}

	public void addGoodt(Goodtp goodtp) {
		// TODO Auto-generated method stub
		goodtpMapper.insert(goodtp);
		Jedis jedis = new Jedis("127.0.0.1",6379);
		Goodtp parm = new Goodtp();
		parm.setTypename(goodtp.getTypename());
		Goodtp goodtp2 = goodtpMapper.selectOne(parm);
		jedis.hset("商品", goodtp2.getId()+"", JSONObject.toJSONString(goodtp2));
		
	}


}
