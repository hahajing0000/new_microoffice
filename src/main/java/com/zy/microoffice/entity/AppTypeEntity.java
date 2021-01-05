package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "应用类别实体", description = "应用类别实体")
public class AppTypeEntity {
    @ApiModelProperty(name = "id", value = "应用类型id", notes = "应用类型id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "apptypename", value = "应用类型名称", notes = "应用类型名称", dataType = "String")
    private String apptypename;
    @ApiModelProperty(name = "imgpath", value = "图标", notes = "图标", dataType = "String")
    private String imgpath;
}
