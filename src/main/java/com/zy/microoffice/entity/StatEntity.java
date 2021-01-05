package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 面试实体
 */
@Data
@ToString
public class StatEntity {
    /**
     * 表主键
     */
    private int id;
    /**
     * 用户电话号码
     */
    private String phonenumber;
    /**
     * 用户姓名
     */
    private String realname;
    /**
     * 公司名称
     */
    @NotBlank(message = "公司名称不允许为空")
    private String companyname;
    /**
     * 岗位
     */
    @NotBlank(message = "岗位不允为空")
    private String post;
    /**
     * 面试时间
     */
    @NotBlank(message = "面试时间不允许为空")
    private String interviewtime;
    /**
     * 面试结果
     */
    private int interviewresult;
    /**
     * 岗位需求
     */
    private String requestinfo;
    /**
     * 公司所在省市
     */
    private String area;
    /**
     * 薪资
     */
    private String pay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getInterviewtime() {
        return interviewtime;
    }

    public void setInterviewtime(String interviewtime) {
        this.interviewtime = interviewtime;
    }

    public int getInterviewresult() {
        return interviewresult;
    }

    public void setInterviewresult(int interviewresult) {
        this.interviewresult = interviewresult;
    }

    public String getRequestinfo() {
        return requestinfo;
    }

    public void setRequestinfo(String requestinfo) {
        this.requestinfo = requestinfo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
