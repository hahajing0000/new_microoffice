package com.zy.microoffice.controller;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.TeamChatEntity;
import com.zy.microoffice.service.TeamChatService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "团队聊天模块",description = "团队聊天模块",tags = "团队聊天模块")
@RequestMapping("/teamchat")
public class TeamChatController {

    @Autowired
    TeamChatService teamChatService;

    /**
     * 发送消息
     * @param teamChatEntity 消息实体
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "发送消息", notes = "发送消息",httpMethod = "POST")
    @PostMapping("/sendMsg")
    public ResponseEntity sendMsg(@RequestBody
                                              @ApiParam(value = "团队消息实体",name = "teamChatEntity",required = true)
                                              TeamChatEntity teamChatEntity){
        return teamChatService.sendMsg(teamChatEntity);
    }

    /**
     * 根据团队码获取消息
     * @param teamCode 团队码
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据团队码获取消息", notes = "根据团队码获取消息",httpMethod = "GET")
    @GetMapping("/getMsgsFromTeamCode")
    public ResponseEntity<List<TeamChatEntity>> getMsgsFromTeamCode(@RequestParam
                                                                                @ApiParam(name = "teamCode",value = "团队码",required = true)
                                                                                String teamCode){
        return teamChatService.getMsgsFromTeamCode(teamCode);
    }
}
