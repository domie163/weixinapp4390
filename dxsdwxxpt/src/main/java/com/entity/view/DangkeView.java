package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DangkeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 党课
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("dangke")
public class DangkeView extends DangkeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 党课类型的值
	*/
	@ColumnInfo(comment="党课类型的字典表值",type="varchar(200)")
	private String dangkeValue;




	public DangkeView() {

	}

	public DangkeView(DangkeEntity dangkeEntity) {
		try {
			BeanUtils.copyProperties(this, dangkeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 党课类型的值
	*/
	public String getDangkeValue() {
		return dangkeValue;
	}
	/**
	* 设置： 党课类型的值
	*/
	public void setDangkeValue(String dangkeValue) {
		this.dangkeValue = dangkeValue;
	}




	@Override
	public String toString() {
		return "DangkeView{" +
			", dangkeValue=" + dangkeValue +
			"} " + super.toString();
	}
}
