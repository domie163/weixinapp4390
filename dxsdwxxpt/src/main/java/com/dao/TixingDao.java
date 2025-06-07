package com.dao;

import com.entity.TixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TixingView;

/**
 * 提醒 Dao 接口
 *
 * @author 
 */
public interface TixingDao extends BaseMapper<TixingEntity> {

   List<TixingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
