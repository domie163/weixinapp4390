package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XuexiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 在线学习
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuexi")
public class XuexiView extends XuexiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 在线学习类型的值
	*/
	@ColumnInfo(comment="在线学习类型的字典表值",type="varchar(200)")
	private String xuexiValue;




	public XuexiView() {

	}

	public XuexiView(XuexiEntity xuexiEntity) {
		try {
			BeanUtils.copyProperties(this, xuexiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 在线学习类型的值
	*/
	public String getXuexiValue() {
		return xuexiValue;
	}
	/**
	* 设置： 在线学习类型的值
	*/
	public void setXuexiValue(String xuexiValue) {
		this.xuexiValue = xuexiValue;
	}




	@Override
	public String toString() {
		return "XuexiView{" +
			", xuexiValue=" + xuexiValue +
			"} " + super.toString();
	}
}
