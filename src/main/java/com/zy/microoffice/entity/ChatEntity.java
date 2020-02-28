package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ChatEntity",description = "个人聊天实体")
public class ChatEntity extends MsgEntity {
    @ApiModelProperty(name = "fromuser",value = "发送人",notes = "发送人",dataType = "int")
    private int fromuser;
    @ApiModelProperty(name = "touser",value = "接收人",notes = "接收人",dataType = "int")
    private int touser;
}
