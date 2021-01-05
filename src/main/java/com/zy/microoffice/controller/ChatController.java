package com.zy.microoffice.controller;

import com.zy.microoffice.entity.ChatEntity;
import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.service.ChatService;
import com.zy.microoffice.service.UserService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "个人聊天模块", description = "个人聊天模块", tags = "个人聊天模块")
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatService chatService;

    /**
     * 添加聊天实体
     *
     * @param chatEntity 聊天实体对象
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "发送聊天内容", notes = "发送聊天内容", httpMethod = "POST")
    @PostMapping("/addChat")
    public ResponseEntity addChat(@RequestBody @ApiParam(value = "聊天实体", name = "chatEntity", required = true) ChatEntity chatEntity) {
        return chatService.addChat(chatEntity);
    }

    /**
     * 获取聊天内容
     *
     * @param from 发送人
     * @param to   接收人
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "获取聊天内容", notes = "获取聊天内容", httpMethod = "GET")
    @GetMapping("/getChats")
    public ResponseEntity<List<ChatEntity>> getChats(@RequestParam @ApiParam(name = "from", value = "发送人", required = true)
                                                             int from,
                                                     @RequestParam
                                                     @ApiParam(name = "to", value = "接收人", required = true)
                                                             int to) {
        return chatService.getChats(from, to);
    }
}
