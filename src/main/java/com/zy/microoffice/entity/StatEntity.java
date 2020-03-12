package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

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
     * 用户id
     */
    private int userid;
    /**
     * 用户姓名
     */
    private String realname;
    /**
     * 公司名称
     */
    private String companyname;
    /**
     * 岗位
     */
    private String post;
    /**
     * 面试时间
     */
    private String interviewtime;
    /**
     * 面试结果
     */
    private int interviewresult;
    /**
     * 岗位需求
     */
    private String requestinfo;
}
