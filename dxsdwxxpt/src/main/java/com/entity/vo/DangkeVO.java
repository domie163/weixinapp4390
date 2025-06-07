package com.entity.vo;

import com.entity.DangkeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 党课
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dangke")
public class DangkeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 党课名称
     */

    @TableField(value = "dangke_name")
    private String dangkeName;


    /**
     * 党课编号
     */

    @TableField(value = "dangke_uuid_number")
    private String dangkeUuidNumber;


    /**
     * 党课照片
     */

    @TableField(value = "dangke_photo")
    private String dangkePhoto;


    /**
     * 党课地点
     */

    @TableField(value = "dangke_address")
    private String dangkeAddress;


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
     * 党课类型
     */

    @TableField(value = "dangke_types")
    private Integer dangkeTypes;


    /**
     * 参加人员
     */

    @TableField(value = "dangke_kucun_number")
    private Integer dangkeKucunNumber;


    /**
     * 党课介绍
     */

    @TableField(value = "dangke_content")
    private String dangkeContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "dangke_delete")
    private Integer dangkeDelete;


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
	 * 设置：党课名称
	 */
    public String getDangkeName() {
        return dangkeName;
    }


    /**
	 * 获取：党课名称
	 */

    public void setDangkeName(String dangkeName) {
        this.dangkeName = dangkeName;
    }
    /**
	 * 设置：党课编号
	 */
    public String getDangkeUuidNumber() {
        return dangkeUuidNumber;
    }


    /**
	 * 获取：党课编号
	 */

    public void setDangkeUuidNumber(String dangkeUuidNumber) {
        this.dangkeUuidNumber = dangkeUuidNumber;
    }
    /**
	 * 设置：党课照片
	 */
    public String getDangkePhoto() {
        return dangkePhoto;
    }


    /**
	 * 获取：党课照片
	 */

    public void setDangkePhoto(String dangkePhoto) {
        this.dangkePhoto = dangkePhoto;
    }
    /**
	 * 设置：党课地点
	 */
    public String getDangkeAddress() {
        return dangkeAddress;
    }


    /**
	 * 获取：党课地点
	 */

    public void setDangkeAddress(String dangkeAddress) {
        this.dangkeAddress = dangkeAddress;
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
	 * 设置：党课类型
	 */
    public Integer getDangkeTypes() {
        return dangkeTypes;
    }


    /**
	 * 获取：党课类型
	 */

    public void setDangkeTypes(Integer dangkeTypes) {
        this.dangkeTypes = dangkeTypes;
    }
    /**
	 * 设置：参加人员
	 */
    public Integer getDangkeKucunNumber() {
        return dangkeKucunNumber;
    }


    /**
	 * 获取：参加人员
	 */

    public void setDangkeKucunNumber(Integer dangkeKucunNumber) {
        this.dangkeKucunNumber = dangkeKucunNumber;
    }
    /**
	 * 设置：党课介绍
	 */
    public String getDangkeContent() {
        return dangkeContent;
    }


    /**
	 * 获取：党课介绍
	 */

    public void setDangkeContent(String dangkeContent) {
        this.dangkeContent = dangkeContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDangkeDelete() {
        return dangkeDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDangkeDelete(Integer dangkeDelete) {
        this.dangkeDelete = dangkeDelete;
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
