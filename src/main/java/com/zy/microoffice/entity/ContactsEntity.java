package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ContactsEntity",description = "联系人实体上")
public class ContactsEntity {

    @ApiModelProperty(name = "id",value = "主键id",notes = "主键id",dataType = "int")
    private int id;
    @ApiModelProperty(name = "userid",value = "用户id",notes = "用户id",dataType = "int")
    private int userid;
    @ApiModelProperty(name = "contactsid",value = "联系人id",notes = "联系人id",dataType = "int")
    private int contactsid;
    @ApiModelProperty(name = "agree",value = "是否同意",notes = "是否同意",dataType = "int")
    private int agree;
}
