package com.entity.vo;

import com.entity.XuexiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 在线学习
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuexi")
public class XuexiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 在线学习名称
     */

    @TableField(value = "xuexi_name")
    private String xuexiName;


    /**
     * 在线学习编号
     */

    @TableField(value = "xuexi_uuid_number")
    private String xuexiUuidNumber;


    /**
     * 在线学习照片
     */

    @TableField(value = "xuexi_photo")
    private String xuexiPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 文件
     */

    @TableField(value = "xuexi_file")
    private String xuexiFile;


    /**
     * 视频
     */

    @TableField(value = "xuexi_video")
    private String xuexiVideo;


    /**
     * 在线学习类型
     */

    @TableField(value = "xuexi_types")
    private Integer xuexiTypes;


    /**
     * 在线学习介绍
     */

    @TableField(value = "xuexi_content")
    private String xuexiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "xuexi_delete")
    private Integer xuexiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：在线学习名称
	 */
    public String getXuexiName() {
        return xuexiName;
    }


    /**
	 * 获取：在线学习名称
	 */

    public void setXuexiName(String xuexiName) {
        this.xuexiName = xuexiName;
    }
    /**
	 * 设置：在线学习编号
	 */
    public String getXuexiUuidNumber() {
        return xuexiUuidNumber;
    }


    /**
	 * 获取：在线学习编号
	 */

    public void setXuexiUuidNumber(String xuexiUuidNumber) {
        this.xuexiUuidNumber = xuexiUuidNumber;
    }
    /**
	 * 设置：在线学习照片
	 */
    public String getXuexiPhoto() {
        return xuexiPhoto;
    }


    /**
	 * 获取：在线学习照片
	 */

    public void setXuexiPhoto(String xuexiPhoto) {
        this.xuexiPhoto = xuexiPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：文件
	 */
    public String getXuexiFile() {
        return xuexiFile;
    }


    /**
	 * 获取：文件
	 */

    public void setXuexiFile(String xuexiFile) {
        this.xuexiFile = xuexiFile;
    }
    /**
	 * 设置：视频
	 */
    public String getXuexiVideo() {
        return xuexiVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setXuexiVideo(String xuexiVideo) {
        this.xuexiVideo = xuexiVideo;
    }
    /**
	 * 设置：在线学习类型
	 */
    public Integer getXuexiTypes() {
        return xuexiTypes;
    }


    /**
	 * 获取：在线学习类型
	 */

    public void setXuexiTypes(Integer xuexiTypes) {
        this.xuexiTypes = xuexiTypes;
    }
    /**
	 * 设置：在线学习介绍
	 */
    public String getXuexiContent() {
        return xuexiContent;
    }


    /**
	 * 获取：在线学习介绍
	 */

    public void setXuexiContent(String xuexiContent) {
        this.xuexiContent = xuexiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXuexiDelete() {
        return xuexiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXuexiDelete(Integer xuexiDelete) {
        this.xuexiDelete = xuexiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
