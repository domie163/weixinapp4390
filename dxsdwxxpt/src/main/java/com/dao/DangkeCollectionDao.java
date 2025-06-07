package com.dao;

import com.entity.DangkeCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DangkeCollectionView;

/**
 * 党课收藏 Dao 接口
 *
 * @author 
 */
public interface DangkeCollectionDao extends BaseMapper<DangkeCollectionEntity> {

   List<DangkeCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
