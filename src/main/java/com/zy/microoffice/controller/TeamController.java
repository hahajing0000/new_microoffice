package com.zy.microoffice.controller;

import com.zy.microoffice.entity.TeamEntity;
import com.zy.microoffice.service.TeamService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@Api(value = "团队模块API接口",description = "该模块提供对团队信息的CRUD操作",tags = "团队模块")
public class TeamController {
    @Autowired
    TeamService teamService;

    /**
     * 创建团队
     * @param entity 团队实体
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "创建团队",notes = "创建团队",httpMethod = "POST")
//    @ApiImplicitParam(value = "团队请求实体",dataType = "com.zy.microoffice.entity.TeamEntity",name = "entity",required = true)
    @PostMapping("/createTeam")
    public boolean createTeam(@RequestBody @ApiParam(name = "entity",value = "传入json格式",required = true) TeamEntity entity){
        return teamService.createTeam(entity);
    }

    /**
     * 删除团队
     * @param id 团队id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "删除团队",notes = "删除团队",httpMethod = "POST")
    @PostMapping("/removeTeam")
    public boolean removeTeam(@RequestParam @ApiParam(name = "id",value = "团队id",required = true) int id){
        return teamService.removeTeam(id);
    }

    /**
     * 修改团队
     * @param entity 团队实体
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "修改团队信息",notes = "修改团队信息",httpMethod = "POST")
    @PostMapping("/modifyTeam")
    public boolean modifyTeam(@RequestBody @ApiParam(name = "entity",value = "团队请求实体",required = true) TeamEntity entity){
        return teamService.modifyTeam(entity);
    }

    /**
     * 根据团队id获取团队信息
     * @param id 团队id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据id获取团队信息",notes = "根据id获取团队信息",httpMethod = "GET")
    @GetMapping("/getTeamInfoById")
    public TeamEntity getTeamInfoById(@RequestParam @ApiParam(name = "id",value = "团队id",required = true) int id){
        return teamService.getTeamInfoById(id);
    }

    /**
     * 根据用户id获取团队信息
     * @param userid 用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据用户id获取其参加或者创建的团队信息",notes = "根据用户id获取其参加或者创建的团队信息",httpMethod = "GET")
    @GetMapping("getTeamInfosByUserId")
    public List<TeamEntity> getTeamInfosByUserId(@RequestParam @ApiParam(name = "userid",value = "用户id",required = true) int userid){
        return teamService.getTeamInfosByUserId(userid);
    }
}