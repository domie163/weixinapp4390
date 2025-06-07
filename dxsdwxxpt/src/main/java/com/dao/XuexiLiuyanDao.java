package com.dao;

import com.entity.XuexiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuexiLiuyanView;

/**
 * 在线学习留言 Dao 接口
 *
 * @author 
 */
public interface XuexiLiuyanDao extends BaseMapper<XuexiLiuyanEntity> {

   List<XuexiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
