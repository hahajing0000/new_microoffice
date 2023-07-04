package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "所在城市实体", description = "所在城市实体")
public class CityEntity {
    @ApiModelProperty(name = "id", value = "所在城市id", notes = "所在城市id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "cityname", value = "城市名称", notes = "城市名称", dataType = "String")
    private String cityname;
    @ApiModelProperty(name = "desc", value = "描述信息", notes = "描述信息", dataType = "String")
    private String desc;
}
