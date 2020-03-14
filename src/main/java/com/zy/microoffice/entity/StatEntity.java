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
}
