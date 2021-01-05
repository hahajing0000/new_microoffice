package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgEntity", description = "消息实体")
public class MsgEntity {
    @ApiModelProperty(name = "id", value = "表主键", notes = "表主键", dataType = "int")
    private int id;
    @ApiModelProperty(name = "msgtype", value = "消息类型", notes = "消息类型", dataType = "int")
    private int msgtype;
    @ApiModelProperty(name = "content", value = "消息内容", notes = "消息内容", dataType = "String")
    private String content;
    @ApiModelProperty(name = "ctime", value = "发送时间", notes = "发送时间", dataType = "String")
    private String ctime;
}

