package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.God;
import com.xiaoshu.entity.GodExample;
import com.xiaoshu.entity.GodVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GodMapper extends BaseMapper<God> {

	List<GodVo> findGodPage(GodVo godVo);

	List<GodVo> echartsAll();
}