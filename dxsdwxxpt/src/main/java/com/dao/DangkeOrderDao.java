package com.dao;

import com.entity.DangkeOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DangkeOrderView;

/**
 * 党课报名 Dao 接口
 *
 * @author 
 */
public interface DangkeOrderDao extends BaseMapper<DangkeOrderEntity> {

   List<DangkeOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
