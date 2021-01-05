package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.ChatEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMapper {
    /**
     * 添加聊天实体
     *
     * @param chatEntity 聊天实体对象
     * @return
     */
    boolean addChat(ChatEntity chatEntity);

    /**
     * 获取聊天内容
     *
     * @param from 发送人
     * @param to   接收人
     * @return
     */
    List<ChatEntity> getChats(int from, int to);
}
