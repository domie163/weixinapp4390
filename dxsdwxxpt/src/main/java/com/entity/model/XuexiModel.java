package com.entity.model;

import com.entity.XuexiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 在线学习
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuexiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 在线学习名称
     */
    private String xuexiName;


    /**
     * 在线学习编号
     */
    private String xuexiUuidNumber;


    /**
     * 在线学习照片
     */
    private String xuexiPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 文件
     */
    private String xuexiFile;


    /**
     * 视频
     */
    private String xuexiVideo;


    /**
     * 在线学习类型
     */
    private Integer xuexiTypes;


    /**
     * 在线学习介绍
     */
    private String xuexiContent;


    /**
     * 逻辑删除
     */
    private Integer xuexiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
