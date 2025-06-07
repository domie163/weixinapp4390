package com.entity.model;

import com.entity.DangkeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 党课
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DangkeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 党课名称
     */
    private String dangkeName;


    /**
     * 党课编号
     */
    private String dangkeUuidNumber;


    /**
     * 党课照片
     */
    private String dangkePhoto;


    /**
     * 党课地点
     */
    private String dangkeAddress;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 党课类型
     */
    private Integer dangkeTypes;


    /**
     * 参加人员
     */
    private Integer dangkeKucunNumber;


    /**
     * 党课介绍
     */
    private String dangkeContent;


    /**
     * 逻辑删除
     */
    private Integer dangkeDelete;


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
