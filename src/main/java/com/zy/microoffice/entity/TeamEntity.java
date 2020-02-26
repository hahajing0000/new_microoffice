package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "团队信息",description = "团队实体信息")
public class TeamEntity {
    @ApiModelProperty(value = "团队id")
    private int id;
    @ApiModelProperty(value = "团队名称")
    private String teamname;
    @ApiModelProperty(value = "团队码")
    private String teamcode;
    @ApiModelProperty(value = "团队创建者id")
    private int creator;
    @ApiModelProperty(value = "团队创建者真实姓名")
    private String creatorname;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "创建时间")
    public String ctime;

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", teamname='" + teamname + '\'' +
                ", teamcode='" + teamcode + '\'' +
                ", creator=" + creator +
                ", creatorname='" + creatorname + '\'' +
                ", description='" + description + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getTeamcode() {
        return teamcode;
    }

    public void setTeamcode(String teamcode) {
        this.teamcode = teamcode;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

}
