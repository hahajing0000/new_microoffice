package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "班级实体", description = "班级实体")
public class ClassEntity {
    @ApiModelProperty(name = "id", value = "班级id", notes = "班级id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "classname", value = "班级名称", notes = "班级名称", dataType = "String")
    private String classname;
    @ApiModelProperty(name = "desc", value = "描述信息", notes = "描述信息", dataType = "String")
    private String desc;
}
