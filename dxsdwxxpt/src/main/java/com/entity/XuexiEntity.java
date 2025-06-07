package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 在线学习
 *
 * @author 
 * @email
 */
@TableName("xuexi")
public class XuexiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuexiEntity() {

	}

	public XuexiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 在线学习名称
     */
    @ColumnInfo(comment="在线学习名称",type="varchar(200)")
    @TableField(value = "xuexi_name")

    private String xuexiName;


    /**
     * 在线学习编号
     */
    @ColumnInfo(comment="在线学习编号",type="varchar(200)")
    @TableField(value = "xuexi_uuid_number")

    private String xuexiUuidNumber;


    /**
     * 在线学习照片
     */
    @ColumnInfo(comment="在线学习照片",type="varchar(200)")
    @TableField(value = "xuexi_photo")

    private String xuexiPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 文件
     */
    @ColumnInfo(comment="文件",type="varchar(200)")
    @TableField(value = "xuexi_file")

    private String xuexiFile;


    /**
     * 视频
     */
    @ColumnInfo(comment="视频",type="varchar(200)")
    @TableField(value = "xuexi_video")

    private String xuexiVideo;


    /**
     * 在线学习类型
     */
    @ColumnInfo(comment="在线学习类型",type="int(11)")
    @TableField(value = "xuexi_types")

    private Integer xuexiTypes;


    /**
     * 在线学习介绍
     */
    @ColumnInfo(comment="在线学习介绍",type="longtext")
    @TableField(value = "xuexi_content")

    private String xuexiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xuexi_delete")

    private Integer xuexiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：在线学习名称
	 */
    public String getXuexiName() {
        return xuexiName;
    }
    /**
	 * 设置：在线学习名称
	 */

    public void setXuexiName(String xuexiName) {
        this.xuexiName = xuexiName;
    }
    /**
	 * 获取：在线学习编号
	 */
    public String getXuexiUuidNumber() {
        return xuexiUuidNumber;
    }
    /**
	 * 设置：在线学习编号
	 */

    public void setXuexiUuidNumber(String xuexiUuidNumber) {
        this.xuexiUuidNumber = xuexiUuidNumber;
    }
    /**
	 * 获取：在线学习照片
	 */
    public String getXuexiPhoto() {
        return xuexiPhoto;
    }
    /**
	 * 设置：在线学习照片
	 */

    public void setXuexiPhoto(String xuexiPhoto) {
        this.xuexiPhoto = xuexiPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：文件
	 */
    public String getXuexiFile() {
        return xuexiFile;
    }
    /**
	 * 设置：文件
	 */

    public void setXuexiFile(String xuexiFile) {
        this.xuexiFile = xuexiFile;
    }
    /**
	 * 获取：视频
	 */
    public String getXuexiVideo() {
        return xuexiVideo;
    }
    /**
	 * 设置：视频
	 */

    public void setXuexiVideo(String xuexiVideo) {
        this.xuexiVideo = xuexiVideo;
    }
    /**
	 * 获取：在线学习类型
	 */
    public Integer getXuexiTypes() {
        return xuexiTypes;
    }
    /**
	 * 设置：在线学习类型
	 */

    public void setXuexiTypes(Integer xuexiTypes) {
        this.xuexiTypes = xuexiTypes;
    }
    /**
	 * 获取：在线学习介绍
	 */
    public String getXuexiContent() {
        return xuexiContent;
    }
    /**
	 * 设置：在线学习介绍
	 */

    public void setXuexiContent(String xuexiContent) {
        this.xuexiContent = xuexiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXuexiDelete() {
        return xuexiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXuexiDelete(Integer xuexiDelete) {
        this.xuexiDelete = xuexiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xuexi{" +
            ", id=" + id +
            ", xuexiName=" + xuexiName +
            ", xuexiUuidNumber=" + xuexiUuidNumber +
            ", xuexiPhoto=" + xuexiPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", xuexiFile=" + xuexiFile +
            ", xuexiVideo=" + xuexiVideo +
            ", xuexiTypes=" + xuexiTypes +
            ", xuexiContent=" + xuexiContent +
            ", xuexiDelete=" + xuexiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
