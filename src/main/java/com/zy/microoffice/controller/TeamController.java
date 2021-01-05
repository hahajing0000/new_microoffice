package com.zy.microoffice.controller;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.TeamEntity;
import com.zy.microoffice.entity.UserEntity;
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
@Api(value = "团队模块API接口", description = "该模块提供对团队信息的CRUD操作", tags = "团队模块")
public class TeamController {
    @Autowired
    TeamService teamService;

    /**
     * 创建团队
     *
     * @param entity 团队实体
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "创建团队(请求参数中id与teamcode不需要传入)", notes = "创建团队(请求参数中id与teamcode不需要传入)", httpMethod = "POST")
//    @ApiImplicitParam(value = "团队请求实体",dataType = "com.zy.microoffice.entity.TeamEntity",name = "entity",required = true)
    @PostMapping("/createTeam")
    public ResponseEntity createTeam(@RequestBody @ApiParam(name = "entity", value = "传入json格式", required = true) TeamEntity entity) {
        return teamService.createTeam(entity);
    }

    /**
     * 删除团队
     *
     * @param id 团队id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "删除团队（同时删除团队下所有成员）", notes = "删除团队（同时删除团队下所有成员）", httpMethod = "DELETE")
    @DeleteMapping("/removeTeam")
    public ResponseEntity removeTeam(@RequestParam @ApiParam(name = "id", value = "团队id", required = true) int id) {
        return teamService.removeTeam(id);
    }

    /**
     * 修改团队
     *
     * @param entity 团队实体
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "修改团队信息", notes = "修改团队信息", httpMethod = "PUT")
    @PutMapping("/modifyTeam")
    public ResponseEntity modifyTeam(@RequestBody @ApiParam(name = "entity", value = "团队请求实体", required = true) TeamEntity entity) {
        return teamService.modifyTeam(entity);
    }

    /**
     * 根据团队id获取团队信息
     *
     * @param id 团队id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据id获取团队信息", notes = "根据id获取团队信息", httpMethod = "GET")
    @GetMapping("/getTeamInfoById")
    public ResponseEntity<TeamEntity> getTeamInfoById(@RequestParam
                                                      @ApiParam(name = "id", value = "团队id", required = true)
                                                              int id) {
        return teamService.getTeamInfoById(id);
    }

    /**
     * 根据用户id获取团队信息
     *
     * @param userid 用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据用户id获取其参加或者创建的团队信息", notes = "根据用户id获取其参加或者创建的团队信息", httpMethod = "GET")
    @GetMapping("getTeamInfosByUserId")
    public ResponseEntity<List<TeamEntity>> getTeamInfosByUserId(@RequestParam
                                                                 @ApiParam(name = "userid", value = "用户id", required = true)
                                                                         int userid) {
        return teamService.getTeamInfosByUserId(userid);
    }

    /**
     * 添加用户到团队
     *
     * @param teamcode 团队码
     * @param userid   用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "加入团队", notes = "加入团队", httpMethod = "POST")
    @PostMapping("/addUserToTeam")
    public ResponseEntity addUserToTeam(@RequestParam
                                        @ApiParam(name = "teamcode", value = "团队码", required = true)
                                                String teamcode,
                                        @RequestParam
                                        @ApiParam(name = "userid", value = "用户id", required = true)
                                                int userid) {
        return teamService.addUserToTeam(teamcode, userid);
    }

    /**
     * 退出团队
     *
     * @param teamcode 团队码
     * @param userid   用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "退出团队", notes = "退出团队", httpMethod = "DELETE")
    @DeleteMapping("/quitTeam")
    public ResponseEntity quitTeam(@RequestParam @ApiParam(name = "teamcode", value = "团队码", required = true)
                                           String teamcode,
                                   @RequestParam @ApiParam(name = "userid", value = "用户id", required = true)
                                           int userid) {
        return teamService.quitTeam(teamcode, userid);
    }

    /**
     * 获取团队下的所有成员用户
     *
     * @param teamcode 团队码
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据团队码获取所有成员", notes = "根据团队码获取所有成员", httpMethod = "GET")
    @GetMapping("/getUsersFromTeam")
    public ResponseEntity<List<UserEntity>> getUsersFromTeam(@RequestParam
                                                             @ApiParam(name = "teamcode", value = "团队码", required = true)
                                                                     String teamcode) {
        return teamService.getUsersFromTeam(teamcode);
    }

//    /**
//     * 获取团队二维码
//     * @param teamCode 团队码
//     * @return
//     */
//    @UserLoginToken
//    @ApiOperation(value = "获取团队二维码连接",notes = "获取团队二维码连接",httpMethod = "GET")
//    @GetMapping("/getQRcode")
//    public ResponseEntity getQRcode(String teamCode){
//        return teamService.getQRcode(teamCode);
//    }

    /**
     * 获取加入团队申请
     *
     * @param teamcode 团队Code
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "获取加入团队申请", notes = "获取加入团队申请", httpMethod = "GET")
    @GetMapping("/getAddApply")
    public ResponseEntity<List<UserEntity>> getAddApply(@RequestParam
                                                        @ApiParam(name = "teamcode", value = "团队Code", required = true)
                                                                String teamcode) {
        return teamService.getAddApply(teamcode);
    }

    /**
     * 同意加入团队
     *
     * @param userid   用户id
     * @param teamcode 团队Code
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "同意加入团队", notes = "同意加入团队", httpMethod = "PUT")
    @PutMapping("/agreeApply")
    public ResponseEntity<Boolean> agreeApply(@RequestParam
                                              @ApiParam(name = "userid", value = "用户id", required = true)
                                                      int userid,
                                              @RequestParam
                                              @ApiParam(name = "teamcode", value = "团队Code", required = true)
                                                      String teamcode) {
        return teamService.agreeApply(userid, teamcode);
    }
}
