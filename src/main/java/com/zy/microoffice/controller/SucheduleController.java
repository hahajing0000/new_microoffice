package com.zy.microoffice.controller;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.ScheduleEntity;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.service.SucheduleService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "日程模块", description = "日程模块", tags = "日程模块")
@RestController
@RequestMapping(value = "/suchedule")
public class SucheduleController {

    @Autowired
    SucheduleService scheduledService;

    /**
     * 添加日程
     *
     * @param scheduleEntity 日程实体
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "添加日程", notes = "添加日程", httpMethod = "POST")
    @PostMapping("/addSuchedule")
    public ResponseEntity<Boolean> addSuchedule(@RequestBody
                                                @ApiParam(name = "scheduleEntity", value = "日程实体 （id不需要传）", required = true)
                                                        ScheduleEntity scheduleEntity) {
        return scheduledService.addSuchedule(scheduleEntity);
    }

    /**
     * 修改日程
     *
     * @param scheduleEntity 日程实体
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "修改日程", notes = "修改日程", httpMethod = "PUT")
    @PutMapping("/modifySuchedule")
    public ResponseEntity<Boolean> modifySuchedule(
            @RequestBody
            @ApiParam(name = "scheduleEntity", value = "日程实体", required = true)
                    ScheduleEntity scheduleEntity) {
        return scheduledService.modifySuchedule(scheduleEntity);
    }

    /**
     * 删除日程
     *
     * @param id 日程id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "删除日程", notes = "删除日程", httpMethod = "DELETE")
    @DeleteMapping("/removeSuchedule")
    public ResponseEntity<Boolean> removeSuchedule(
            @RequestParam
            @ApiParam(name = "id", value = "日程id", required = true)
                    int id) {
        return scheduledService.removeSuchedule(id);
    }

    /**
     * 根据id获取日程
     *
     * @param id 日程id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据id获取日程", notes = "根据id获取日程", httpMethod = "GET")
    @GetMapping("/getScheduleById")
    public ResponseEntity<ScheduleEntity> getScheduleById(
            @RequestParam
            @ApiParam(name = "id", value = "日程id", required = true)
                    int id) {
        return scheduledService.getScheduleById(id);
    }

    /**
     * 获取创建/加入的日程
     *
     * @param userid 用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "获取创建/加入的日程", notes = "获取创建/加入的日程", httpMethod = "GET")
    @GetMapping("/getSchedules")
    public ResponseEntity<List<ScheduleEntity>> getSchedules(
            @RequestParam
            @ApiParam(name = "userid", value = "用户id", required = true)
                    int userid) {
        return scheduledService.getSchedules(userid);
    }

    /**
     * 参与会议日程
     *
     * @param scheduleidid 日程id
     * @param userid       用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "参与会议日程", notes = "参与会议日程", httpMethod = "POST")
    @PostMapping("/addParticipant")
    public ResponseEntity<Boolean> addParticipant(
            @RequestParam
            @ApiParam(name = "scheduleidid", value = "日程id", required = true)
                    int scheduleidid,
            @RequestParam
            @ApiParam(name = "userid", value = "用户id", required = true)
                    int userid) {
        return scheduledService.addParticipant(scheduleidid, userid);
    }

    /**
     * 退出会议日程
     *
     * @param scheduleidid 日程id
     * @param userid       用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "退出会议日程", notes = "退出会议日程", httpMethod = "DELETE")
    @DeleteMapping("/removeParticipant")
    public ResponseEntity<Boolean> removeParticipant(
            @RequestParam
            @ApiParam(name = "scheduleidid", value = "日程id", required = true)
                    int scheduleidid,
            @RequestParam
            @ApiParam(name = "userid", value = "用户id", required = true)
                    int userid) {
        return scheduledService.removeParticipant(scheduleidid, userid);
    }

    /**
     * 获取会议日程的所有人员
     *
     * @param scheduleidid 日程id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "获取会议日程的所有人员", notes = "获取会议日程的所有人员", httpMethod = "GET")
    @GetMapping("/getUsersByParticipant")
    public ResponseEntity<List<UserEntity>> getUsersByParticipant(
            @RequestParam
            @ApiParam(name = "scheduleidid", value = "日程id", required = true)
                    int scheduleidid) {
        return scheduledService.getUsersByParticipant(scheduleidid);
    }
}
