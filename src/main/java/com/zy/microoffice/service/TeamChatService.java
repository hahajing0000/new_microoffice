package com.zy.microoffice.service;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.TeamChatEntity;
import com.zy.microoffice.mapper.TeamChatMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeamChatService {

    @Autowired
    TeamChatMapper teamChatMapper;

    /**
     * 发送消息
     *
     * @param teamChatEntity 消息实体
     * @return
     */
    public ResponseEntity sendMsg(TeamChatEntity teamChatEntity) {
        return ResponseUtils.success(teamChatMapper.sendMsg(teamChatEntity));
    }

    /**
     * 根据团队码获取消息
     *
     * @param teamCode 团队码
     * @return
     */
    public ResponseEntity<List<TeamChatEntity>> getMsgsFromTeamCode(String teamCode) {
        return ResponseUtils.success(teamChatMapper.getMsgsFromTeamCode(teamCode));
    }
}
