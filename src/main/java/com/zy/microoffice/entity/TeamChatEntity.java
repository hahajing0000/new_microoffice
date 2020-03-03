package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "TeamChatEntity",description = "团队聊天实体")
public class TeamChatEntity extends MsgEntity {

    @ApiModelProperty(name = "teamcode",value = "团队码",notes = "团队码",dataType = "String")
    private String teamcode;
    @ApiModelProperty(name = "fromuser",value = "发送人",notes = "发送人",dataType = "int")
    private int fromuser;

}
