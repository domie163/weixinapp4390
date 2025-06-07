package com.dao;

import com.entity.DangkeCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DangkeCommentbackView;

/**
 * 党课评价 Dao 接口
 *
 * @author 
 */
public interface DangkeCommentbackDao extends BaseMapper<DangkeCommentbackEntity> {

   List<DangkeCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
