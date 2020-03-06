package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "应用实体",description = "应用实体")
public class AppEntity {
    @ApiModelProperty(name = "id",value = "应用id",notes = "应用id",dataType = "int")
    private int id;
    @ApiModelProperty(name = "appname",value = "应用名称",notes = "应用名称",dataType = "String")
    private String appname;
    @ApiModelProperty(name = "imgpath",value = "应用图标",notes = "应用图标",dataType = "String")
    private String imgpath;
    @ApiModelProperty(name = "apptypeid",value = "应用类别id",notes = "应用类别id",dataType = "int")
    private int apptypeid;
    @ApiModelProperty(name = "description",value = "描述信息",notes = "描述信息",dataType = "String")
    private String description;

}
