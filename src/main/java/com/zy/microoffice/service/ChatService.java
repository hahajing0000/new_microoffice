package com.zy.microoffice.service;

import com.zy.microoffice.entity.ChatEntity;
import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.mapper.ChatMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ChatService {

    @Autowired
    ChatMapper chatMapper;

    /**
     * 添加聊天实体
     *
     * @param chatEntity 聊天实体对象
     * @return
     */
    public ResponseEntity addChat(ChatEntity chatEntity) {
        return ResponseUtils.success(chatMapper.addChat(chatEntity));
    }

    /**
     * 获取聊天内容
     *
     * @param from 发送人
     * @param to   接收人
     * @return
     */
    public ResponseEntity<List<ChatEntity>> getChats(int from, int to) {
        return ResponseUtils.success(chatMapper.getChats(from, to));
    }
}
