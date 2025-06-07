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
 * 档案
 *
 * @author 
 * @email
 */
@TableName("dangan")
public class DanganEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DanganEntity() {

	}

	public DanganEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 档案名称
     */
    @ColumnInfo(comment="档案名称",type="varchar(200)")
    @TableField(value = "dangan_name")

    private String danganName;


    /**
     * 档案编号
     */
    @ColumnInfo(comment="档案编号",type="varchar(200)")
    @TableField(value = "dangan_uuid_number")

    private String danganUuidNumber;


    /**
     * 档案照片
     */
    @ColumnInfo(comment="档案照片",type="varchar(200)")
    @TableField(value = "dangan_photo")

    private String danganPhoto;


    /**
     * 档案类型
     */
    @ColumnInfo(comment="档案类型",type="int(11)")
    @TableField(value = "dangan_types")

    private Integer danganTypes;


    /**
     * 档案文件
     */
    @ColumnInfo(comment="档案文件",type="varchar(200)")
    @TableField(value = "dangan_file")

    private String danganFile;


    /**
     * 档案介绍
     */
    @ColumnInfo(comment="档案介绍",type="longtext")
    @TableField(value = "dangan_content")

    private String danganContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "dangan_delete")

    private Integer danganDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间    listShow
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：档案名称
	 */
    public String getDanganName() {
        return danganName;
    }
    /**
	 * 设置：档案名称
	 */

    public void setDanganName(String danganName) {
        this.danganName = danganName;
    }
    /**
	 * 获取：档案编号
	 */
    public String getDanganUuidNumber() {
        return danganUuidNumber;
    }
    /**
	 * 设置：档案编号
	 */

    public void setDanganUuidNumber(String danganUuidNumber) {
        this.danganUuidNumber = danganUuidNumber;
    }
    /**
	 * 获取：档案照片
	 */
    public String getDanganPhoto() {
        return danganPhoto;
    }
    /**
	 * 设置：档案照片
	 */

    public void setDanganPhoto(String danganPhoto) {
        this.danganPhoto = danganPhoto;
    }
    /**
	 * 获取：档案类型
	 */
    public Integer getDanganTypes() {
        return danganTypes;
    }
    /**
	 * 设置：档案类型
	 */

    public void setDanganTypes(Integer danganTypes) {
        this.danganTypes = danganTypes;
    }
    /**
	 * 获取：档案文件
	 */
    public String getDanganFile() {
        return danganFile;
    }
    /**
	 * 设置：档案文件
	 */

    public void setDanganFile(String danganFile) {
        this.danganFile = danganFile;
    }
    /**
	 * 获取：档案介绍
	 */
    public String getDanganContent() {
        return danganContent;
    }
    /**
	 * 设置：档案介绍
	 */

    public void setDanganContent(String danganContent) {
        this.danganContent = danganContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDanganDelete() {
        return danganDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDanganDelete(Integer danganDelete) {
        this.danganDelete = danganDelete;
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
	 * 获取：创建时间    listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间    listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Dangan{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", danganName=" + danganName +
            ", danganUuidNumber=" + danganUuidNumber +
            ", danganPhoto=" + danganPhoto +
            ", danganTypes=" + danganTypes +
            ", danganFile=" + danganFile +
            ", danganContent=" + danganContent +
            ", danganDelete=" + danganDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
