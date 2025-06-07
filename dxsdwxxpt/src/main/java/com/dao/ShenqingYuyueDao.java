package com.dao;

import com.entity.ShenqingYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenqingYuyueView;

/**
 * 入党申请 Dao 接口
 *
 * @author 
 */
public interface ShenqingYuyueDao extends BaseMapper<ShenqingYuyueEntity> {

   List<ShenqingYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
