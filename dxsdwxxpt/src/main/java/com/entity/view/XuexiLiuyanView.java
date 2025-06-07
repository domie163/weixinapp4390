package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XuexiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 在线学习留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuexi_liuyan")
public class XuexiLiuyanView extends XuexiLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 在线学习
		/**
		* 在线学习名称
		*/

		@ColumnInfo(comment="在线学习名称",type="varchar(200)")
		private String xuexiName;
		/**
		* 在线学习编号
		*/

		@ColumnInfo(comment="在线学习编号",type="varchar(200)")
		private String xuexiUuidNumber;
		/**
		* 在线学习照片
		*/

		@ColumnInfo(comment="在线学习照片",type="varchar(200)")
		private String xuexiPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 文件
		*/

		@ColumnInfo(comment="文件",type="varchar(200)")
		private String xuexiFile;
		/**
		* 视频
		*/

		@ColumnInfo(comment="视频",type="varchar(200)")
		private String xuexiVideo;
		/**
		* 在线学习类型
		*/
		@ColumnInfo(comment="在线学习类型",type="int(11)")
		private Integer xuexiTypes;
			/**
			* 在线学习类型的值
			*/
			@ColumnInfo(comment="在线学习类型的字典表值",type="varchar(200)")
			private String xuexiValue;
		/**
		* 在线学习介绍
		*/

		@ColumnInfo(comment="在线学习介绍",type="longtext")
		private String xuexiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer xuexiDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 申请状态
		*/
		@ColumnInfo(comment="申请状态",type="int(11)")
		private Integer shenqingYuyueTypes;
			/**
			* 申请状态的值
			*/
			@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
			private String shenqingYuyueValue;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;



	public XuexiLiuyanView() {

	}

	public XuexiLiuyanView(XuexiLiuyanEntity xuexiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, xuexiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 在线学习

		/**
		* 获取： 在线学习名称
		*/
		public String getXuexiName() {
			return xuexiName;
		}
		/**
		* 设置： 在线学习名称
		*/
		public void setXuexiName(String xuexiName) {
			this.xuexiName = xuexiName;
		}

		/**
		* 获取： 在线学习编号
		*/
		public String getXuexiUuidNumber() {
			return xuexiUuidNumber;
		}
		/**
		* 设置： 在线学习编号
		*/
		public void setXuexiUuidNumber(String xuexiUuidNumber) {
			this.xuexiUuidNumber = xuexiUuidNumber;
		}

		/**
		* 获取： 在线学习照片
		*/
		public String getXuexiPhoto() {
			return xuexiPhoto;
		}
		/**
		* 设置： 在线学习照片
		*/
		public void setXuexiPhoto(String xuexiPhoto) {
			this.xuexiPhoto = xuexiPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 文件
		*/
		public String getXuexiFile() {
			return xuexiFile;
		}
		/**
		* 设置： 文件
		*/
		public void setXuexiFile(String xuexiFile) {
			this.xuexiFile = xuexiFile;
		}

		/**
		* 获取： 视频
		*/
		public String getXuexiVideo() {
			return xuexiVideo;
		}
		/**
		* 设置： 视频
		*/
		public void setXuexiVideo(String xuexiVideo) {
			this.xuexiVideo = xuexiVideo;
		}
		/**
		* 获取： 在线学习类型
		*/
		public Integer getXuexiTypes() {
			return xuexiTypes;
		}
		/**
		* 设置： 在线学习类型
		*/
		public void setXuexiTypes(Integer xuexiTypes) {
			this.xuexiTypes = xuexiTypes;
		}


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

		/**
		* 获取： 在线学习介绍
		*/
		public String getXuexiContent() {
			return xuexiContent;
		}
		/**
		* 设置： 在线学习介绍
		*/
		public void setXuexiContent(String xuexiContent) {
			this.xuexiContent = xuexiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getXuexiDelete() {
			return xuexiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setXuexiDelete(Integer xuexiDelete) {
			this.xuexiDelete = xuexiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}
		/**
		* 获取： 申请状态
		*/
		public Integer getShenqingYuyueTypes() {
			return shenqingYuyueTypes;
		}
		/**
		* 设置： 申请状态
		*/
		public void setShenqingYuyueTypes(Integer shenqingYuyueTypes) {
			this.shenqingYuyueTypes = shenqingYuyueTypes;
		}


			/**
			* 获取： 申请状态的值
			*/
			public String getShenqingYuyueValue() {
				return shenqingYuyueValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setShenqingYuyueValue(String shenqingYuyueValue) {
				this.shenqingYuyueValue = shenqingYuyueValue;
			}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "XuexiLiuyanView{" +
			", xuexiName=" + xuexiName +
			", xuexiUuidNumber=" + xuexiUuidNumber +
			", xuexiPhoto=" + xuexiPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", xuexiFile=" + xuexiFile +
			", xuexiVideo=" + xuexiVideo +
			", xuexiContent=" + xuexiContent +
			", xuexiDelete=" + xuexiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
