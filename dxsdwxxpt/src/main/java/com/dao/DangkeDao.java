package com.dao;

import com.entity.DangkeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DangkeView;

/**
 * 党课 Dao 接口
 *
 * @author 
 */
public interface DangkeDao extends BaseMapper<DangkeEntity> {

   List<DangkeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
