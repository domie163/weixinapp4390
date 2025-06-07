package com.entity.model;

import com.entity.GongzuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 党务工作者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongzuoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 党务工作者姓名
     */
    private String gongzuoName;


    /**
     * 党务工作者手机号
     */
    private String gongzuoPhone;


    /**
     * 党务工作者身份证号
     */
    private String gongzuoIdNumber;


    /**
     * 党务工作者头像
     */
    private String gongzuoPhoto;


    /**
     * 申请状态
     */
    private Integer shenqingYuyueTypes;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String gongzuoEmail;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：党务工作者姓名
	 */
    public String getGongzuoName() {
        return gongzuoName;
    }


    /**
	 * 设置：党务工作者姓名
	 */
    public void setGongzuoName(String gongzuoName) {
        this.gongzuoName = gongzuoName;
    }
    /**
	 * 获取：党务工作者手机号
	 */
    public String getGongzuoPhone() {
        return gongzuoPhone;
    }


    /**
	 * 设置：党务工作者手机号
	 */
    public void setGongzuoPhone(String gongzuoPhone) {
        this.gongzuoPhone = gongzuoPhone;
    }
    /**
	 * 获取：党务工作者身份证号
	 */
    public String getGongzuoIdNumber() {
        return gongzuoIdNumber;
    }


    /**
	 * 设置：党务工作者身份证号
	 */
    public void setGongzuoIdNumber(String gongzuoIdNumber) {
        this.gongzuoIdNumber = gongzuoIdNumber;
    }
    /**
	 * 获取：党务工作者头像
	 */
    public String getGongzuoPhoto() {
        return gongzuoPhoto;
    }


    /**
	 * 设置：党务工作者头像
	 */
    public void setGongzuoPhoto(String gongzuoPhoto) {
        this.gongzuoPhoto = gongzuoPhoto;
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
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getGongzuoEmail() {
        return gongzuoEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setGongzuoEmail(String gongzuoEmail) {
        this.gongzuoEmail = gongzuoEmail;
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

    }
