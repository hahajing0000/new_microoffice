package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "会议室实体",description = "会议室实体")
public class MeetingRoomEntity {
    @ApiModelProperty(name = "id",value = "表主键",notes = "表主键",dataType = "int")
    private int id;
    @ApiModelProperty(name = "meetingroomname",value = "会议室名称",notes = "会议室名称",dataType = "String")
    private String meetingroomname;
    @ApiModelProperty(name = "teamcode",value = "团队编码",notes = "团队编码",dataType = "String")
    private String teamcode;
    @ApiModelProperty(name = "creator",value = "创建者",notes = "创建者",dataType = "int")
    private int creator;
}
