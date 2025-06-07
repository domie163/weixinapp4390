package com.entity.model;

import com.entity.ShenqingYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 入党申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShenqingYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String shenqingYuyueUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 申请理由
     */
    private String shenqingYuyueText;


    /**
     * 上传图片
     */
    private String shenqingYuyueFile;


    /**
     * 入党申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer shenqingYuyueYesnoTypes;


    /**
     * 申请状态
     */
    private Integer shenqingYuyueTypes;


    /**
     * 审核回复
     */
    private String shenqingYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shenqingYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shenqingYuyueTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
