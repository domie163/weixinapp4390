package com.entity.vo;

import com.entity.ShenqingYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 入党申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shenqing_yuyue")
public class ShenqingYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "shenqing_yuyue_uuid_number")
    private String shenqingYuyueUuidNumber;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 申请理由
     */

    @TableField(value = "shenqing_yuyue_text")
    private String shenqingYuyueText;


    /**
     * 上传图片
     */

    @TableField(value = "shenqing_yuyue_file")
    private String shenqingYuyueFile;


    /**
     * 入党申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "shenqing_yuyue_yesno_types")
    private Integer shenqingYuyueYesnoTypes;


    /**
     * 申请状态
     */

    @TableField(value = "shenqing_yuyue_types")
    private Integer shenqingYuyueTypes;


    /**
     * 审核回复
     */

    @TableField(value = "shenqing_yuyue_yesno_text")
    private String shenqingYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shenqing_yuyue_shenhe_time")
    private Date shenqingYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shenqing_yuyue_time")
    private Date shenqingYuyueTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名编号
	 */
    public String getShenqingYuyueUuidNumber() {
        return shenqingYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setShenqingYuyueUuidNumber(String shenqingYuyueUuidNumber) {
        this.shenqingYuyueUuidNumber = shenqingYuyueUuidNumber;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请理由
	 */
    public String getShenqingYuyueText() {
        return shenqingYuyueText;
    }


    /**
	 * 获取：申请理由
	 */

    public void setShenqingYuyueText(String shenqingYuyueText) {
        this.shenqingYuyueText = shenqingYuyueText;
    }
    /**
	 * 设置：上传图片
	 */
    public String getShenqingYuyueFile() {
        return shenqingYuyueFile;
    }


    /**
	 * 获取：上传图片
	 */

    public void setShenqingYuyueFile(String shenqingYuyueFile) {
        this.shenqingYuyueFile = shenqingYuyueFile;
    }
    /**
	 * 设置：入党申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：入党申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getShenqingYuyueYesnoTypes() {
        return shenqingYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setShenqingYuyueYesnoTypes(Integer shenqingYuyueYesnoTypes) {
        this.shenqingYuyueYesnoTypes = shenqingYuyueYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getShenqingYuyueTypes() {
        return shenqingYuyueTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setShenqingYuyueTypes(Integer shenqingYuyueTypes) {
        this.shenqingYuyueTypes = shenqingYuyueTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getShenqingYuyueYesnoText() {
        return shenqingYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setShenqingYuyueYesnoText(String shenqingYuyueYesnoText) {
        this.shenqingYuyueYesnoText = shenqingYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getShenqingYuyueShenheTime() {
        return shenqingYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setShenqingYuyueShenheTime(Date shenqingYuyueShenheTime) {
        this.shenqingYuyueShenheTime = shenqingYuyueShenheTime;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getShenqingYuyueTime() {
        return shenqingYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setShenqingYuyueTime(Date shenqingYuyueTime) {
        this.shenqingYuyueTime = shenqingYuyueTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
