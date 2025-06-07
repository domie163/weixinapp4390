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
 * 党课
 *
 * @author 
 * @email
 */
@TableName("dangke")
public class DangkeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DangkeEntity() {

	}

	public DangkeEntity(T t) {
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
     * 党课名称
     */
    @ColumnInfo(comment="党课名称",type="varchar(200)")
    @TableField(value = "dangke_name")

    private String dangkeName;


    /**
     * 党课编号
     */
    @ColumnInfo(comment="党课编号",type="varchar(200)")
    @TableField(value = "dangke_uuid_number")

    private String dangkeUuidNumber;


    /**
     * 党课照片
     */
    @ColumnInfo(comment="党课照片",type="varchar(200)")
    @TableField(value = "dangke_photo")

    private String dangkePhoto;


    /**
     * 党课地点
     */
    @ColumnInfo(comment="党课地点",type="varchar(200)")
    @TableField(value = "dangke_address")

    private String dangkeAddress;


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
     * 党课类型
     */
    @ColumnInfo(comment="党课类型",type="int(11)")
    @TableField(value = "dangke_types")

    private Integer dangkeTypes;


    /**
     * 参加人员
     */
    @ColumnInfo(comment="参加人员",type="int(11)")
    @TableField(value = "dangke_kucun_number")

    private Integer dangkeKucunNumber;


    /**
     * 党课介绍
     */
    @ColumnInfo(comment="党课介绍",type="longtext")
    @TableField(value = "dangke_content")

    private String dangkeContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "dangke_delete")

    private Integer dangkeDelete;


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
	 * 获取：党课名称
	 */
    public String getDangkeName() {
        return dangkeName;
    }
    /**
	 * 设置：党课名称
	 */

    public void setDangkeName(String dangkeName) {
        this.dangkeName = dangkeName;
    }
    /**
	 * 获取：党课编号
	 */
    public String getDangkeUuidNumber() {
        return dangkeUuidNumber;
    }
    /**
	 * 设置：党课编号
	 */

    public void setDangkeUuidNumber(String dangkeUuidNumber) {
        this.dangkeUuidNumber = dangkeUuidNumber;
    }
    /**
	 * 获取：党课照片
	 */
    public String getDangkePhoto() {
        return dangkePhoto;
    }
    /**
	 * 设置：党课照片
	 */

    public void setDangkePhoto(String dangkePhoto) {
        this.dangkePhoto = dangkePhoto;
    }
    /**
	 * 获取：党课地点
	 */
    public String getDangkeAddress() {
        return dangkeAddress;
    }
    /**
	 * 设置：党课地点
	 */

    public void setDangkeAddress(String dangkeAddress) {
        this.dangkeAddress = dangkeAddress;
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
	 * 获取：党课类型
	 */
    public Integer getDangkeTypes() {
        return dangkeTypes;
    }
    /**
	 * 设置：党课类型
	 */

    public void setDangkeTypes(Integer dangkeTypes) {
        this.dangkeTypes = dangkeTypes;
    }
    /**
	 * 获取：参加人员
	 */
    public Integer getDangkeKucunNumber() {
        return dangkeKucunNumber;
    }
    /**
	 * 设置：参加人员
	 */

    public void setDangkeKucunNumber(Integer dangkeKucunNumber) {
        this.dangkeKucunNumber = dangkeKucunNumber;
    }
    /**
	 * 获取：党课介绍
	 */
    public String getDangkeContent() {
        return dangkeContent;
    }
    /**
	 * 设置：党课介绍
	 */

    public void setDangkeContent(String dangkeContent) {
        this.dangkeContent = dangkeContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDangkeDelete() {
        return dangkeDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDangkeDelete(Integer dangkeDelete) {
        this.dangkeDelete = dangkeDelete;
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
        return "Dangke{" +
            ", id=" + id +
            ", dangkeName=" + dangkeName +
            ", dangkeUuidNumber=" + dangkeUuidNumber +
            ", dangkePhoto=" + dangkePhoto +
            ", dangkeAddress=" + dangkeAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", dangkeTypes=" + dangkeTypes +
            ", dangkeKucunNumber=" + dangkeKucunNumber +
            ", dangkeContent=" + dangkeContent +
            ", dangkeDelete=" + dangkeDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
