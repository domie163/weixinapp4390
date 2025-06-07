package com.dao;

import com.entity.XuexiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuexiView;

/**
 * 在线学习 Dao 接口
 *
 * @author 
 */
public interface XuexiDao extends BaseMapper<XuexiEntity> {

   List<XuexiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
