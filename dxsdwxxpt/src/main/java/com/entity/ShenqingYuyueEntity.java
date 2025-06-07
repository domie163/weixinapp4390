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
 * 入党申请
 *
 * @author 
 * @email
 */
@TableName("shenqing_yuyue")
public class ShenqingYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShenqingYuyueEntity() {

	}

	public ShenqingYuyueEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "shenqing_yuyue_uuid_number")

    private String shenqingYuyueUuidNumber;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请理由
     */
    @ColumnInfo(comment="申请理由",type="longtext")
    @TableField(value = "shenqing_yuyue_text")

    private String shenqingYuyueText;


    /**
     * 上传图片
     */
    @ColumnInfo(comment="上传图片",type="varchar(200)")
    @TableField(value = "shenqing_yuyue_file")

    private String shenqingYuyueFile;


    /**
     * 入党申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="入党申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "shenqing_yuyue_yesno_types")

    private Integer shenqingYuyueYesnoTypes;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "shenqing_yuyue_types")

    private Integer shenqingYuyueTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "shenqing_yuyue_yesno_text")

    private String shenqingYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "shenqing_yuyue_shenhe_time")

    private Date shenqingYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "shenqing_yuyue_time")

    private Date shenqingYuyueTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名编号
	 */
    public String getShenqingYuyueUuidNumber() {
        return shenqingYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setShenqingYuyueUuidNumber(String shenqingYuyueUuidNumber) {
        this.shenqingYuyueUuidNumber = shenqingYuyueUuidNumber;
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
	 * 获取：申请理由
	 */
    public String getShenqingYuyueText() {
        return shenqingYuyueText;
    }
    /**
	 * 设置：申请理由
	 */

    public void setShenqingYuyueText(String shenqingYuyueText) {
        this.shenqingYuyueText = shenqingYuyueText;
    }
    /**
	 * 获取：上传图片
	 */
    public String getShenqingYuyueFile() {
        return shenqingYuyueFile;
    }
    /**
	 * 设置：上传图片
	 */

    public void setShenqingYuyueFile(String shenqingYuyueFile) {
        this.shenqingYuyueFile = shenqingYuyueFile;
    }
    /**
	 * 获取：入党申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：入党申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getShenqingYuyueYesnoTypes() {
        return shenqingYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setShenqingYuyueYesnoTypes(Integer shenqingYuyueYesnoTypes) {
        this.shenqingYuyueYesnoTypes = shenqingYuyueYesnoTypes;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getShenqingYuyueTypes() {
        return shenqingYuyueTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setShenqingYuyueTypes(Integer shenqingYuyueTypes) {
        this.shenqingYuyueTypes = shenqingYuyueTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getShenqingYuyueYesnoText() {
        return shenqingYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setShenqingYuyueYesnoText(String shenqingYuyueYesnoText) {
        this.shenqingYuyueYesnoText = shenqingYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getShenqingYuyueShenheTime() {
        return shenqingYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setShenqingYuyueShenheTime(Date shenqingYuyueShenheTime) {
        this.shenqingYuyueShenheTime = shenqingYuyueShenheTime;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getShenqingYuyueTime() {
        return shenqingYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setShenqingYuyueTime(Date shenqingYuyueTime) {
        this.shenqingYuyueTime = shenqingYuyueTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShenqingYuyue{" +
            ", id=" + id +
            ", shenqingYuyueUuidNumber=" + shenqingYuyueUuidNumber +
            ", yonghuId=" + yonghuId +
            ", shenqingYuyueText=" + shenqingYuyueText +
            ", shenqingYuyueFile=" + shenqingYuyueFile +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", shenqingYuyueYesnoTypes=" + shenqingYuyueYesnoTypes +
            ", shenqingYuyueTypes=" + shenqingYuyueTypes +
            ", shenqingYuyueYesnoText=" + shenqingYuyueYesnoText +
            ", shenqingYuyueShenheTime=" + DateUtil.convertString(shenqingYuyueShenheTime,"yyyy-MM-dd") +
            ", shenqingYuyueTime=" + DateUtil.convertString(shenqingYuyueTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
