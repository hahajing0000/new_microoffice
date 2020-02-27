package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.TeamChatEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamChatMapper {
    /**
     * 发送消息
     * @param teamChatEntity 消息实体
     * @return
     */
    boolean sendMsg(TeamChatEntity teamChatEntity);

    /**
     * 根据团队码获取消息
     * @param teamCode 团队码
     * @return
     */
    List<TeamChatEntity> getMsgsFromTeamCode(String teamCode);
}
