package com.zy.microoffice.controller;

import com.zy.microoffice.entity.MeetingRoomEntity;
import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.service.MeetingRoomService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meetingroom")
@Api(value = "会议室模块", description = "会议室模块", tags = "会议室模块")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    /**
     * 添加会议室
     *
     * @param meetingRoomEntity 会议室请求实体
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "添加会议室", notes = "添加会议室", httpMethod = "POST")
    @PostMapping("addMeetingRoom")
    public ResponseEntity<Boolean> addMeetingRoom(@RequestBody
                                                  @ApiParam(name = "meetingRoomEntity", value = "会议室请求实体", required = true)
                                                          MeetingRoomEntity meetingRoomEntity) {
        return meetingRoomService.addMeetingRoom(meetingRoomEntity);
    }

    /**
     * 删除会议室
     *
     * @param id      会议室id
     * @param creator 创建者id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "删除会议室", notes = "删除会议室", httpMethod = "DELETE")
    @DeleteMapping("removeMeetingRoom")
    public ResponseEntity<Boolean> removeMeetingRoom(@RequestParam
                                                     @ApiParam(name = "id", value = "会议室id", required = true)
                                                             int id,
                                                     @RequestParam
                                                     @ApiParam(name = "creator", value = "创建者id", required = true)
                                                             int creator) {
        return meetingRoomService.removeMeetingRoom(id, creator);
    }
}
