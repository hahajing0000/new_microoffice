package com.zy.microoffice.entity;

import com.zy.microoffice.config.RepeatmodeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "ScheduleEntity", description = "日程实体")
public class ScheduleEntity {
    @ApiModelProperty(name = "id", value = "日程表id", notes = "日程表id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "title", value = "标题", notes = "标题", dataType = "String")
    private String title;
    @ApiModelProperty(name = "starttime", value = "开始时间", notes = "开始时间", dataType = "String")
    private String starttime;
    @ApiModelProperty(name = "endtime", value = "结束时间", notes = "结束时间", dataType = "String")
    private String endtime;
    @ApiModelProperty(name = "color", value = "日程颜色 RGB值", notes = "日程颜色 RGB值", dataType = "String")
    private String color;
    @ApiModelProperty(name = "remindtime", value = "提醒时间间隔（5分钟 10分钟 15分钟...）", notes = "提醒时间间隔（5分钟 10分钟 15分钟...）", dataType = "int")
    private int remindtime;
    @ApiModelProperty(name = "description", value = "日程描述", notes = "日程描述", dataType = "String")
    private String description;
    @ApiModelProperty(name = "meetingroomid", value = "会议室id", notes = "会议室id", dataType = "int")
    private int meetingroomid;
    @ApiModelProperty(name = "address", value = "会议地址", notes = "会议地址", dataType = "String")
    private String address;
    @ApiModelProperty(name = "repeatmode", value = "日程重复模式", notes = "日程重复模式", dataType = "int")
    private RepeatmodeType repeatmode;
    @ApiModelProperty(name = "creator", value = "创建者id", notes = "创建者id", dataType = "int")
    private int creator;
    @ApiModelProperty(name = "ctime", value = "创建时间", notes = "创建时间", dataType = "String")
    private String ctime;
}
