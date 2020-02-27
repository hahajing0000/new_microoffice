package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TeamChatEntity",description = "团队聊天实体")
public class TeamChatEntity {
    @ApiModelProperty(name = "id",value = "表主键",notes = "表主键",dataType = "int")
    private int id;
    @ApiModelProperty(name = "teamcode",value = "团队码",notes = "团队码",dataType = "String")
    private String teamcode;
    @ApiModelProperty(name = "fromuser",value = "发送人",notes = "发送人",dataType = "int")
    private int fromuser;
    @ApiModelProperty(name = "msgtype",value = "消息类型",notes = "消息类型",dataType = "int")
    private int msgtype;
    @ApiModelProperty(name = "content",value = "消息内容",notes = "消息内容",dataType = "String")
    private String content;
    @ApiModelProperty(name = "ctime",value = "发送时间",notes = "发送时间",dataType = "String")
    private String ctime;
}
