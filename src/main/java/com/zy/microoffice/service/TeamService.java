package com.zy.microoffice.service;

import com.zy.microoffice.entity.TeamEntity;
import com.zy.microoffice.mapper.TeamMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeamService {

    @Autowired
    TeamMapper teamMapper;

    /**
     * 创建团队
     * @param entity 团队实体
     * @return
     */
    public boolean createTeam(TeamEntity entity){
        return teamMapper.createTeam(entity);
    }

    /**
     * 删除团队
     * @param id 团队id
     * @return
     */
    public boolean removeTeam(int id){
        return teamMapper.removeTeam(id);
    }

    /**
     * 修改团队
     * @param entity 团队实体
     * @return
     */
    public boolean modifyTeam(TeamEntity entity){
        return teamMapper.modifyTeam(entity);
    }

    /**
     * 根据团队id获取团队信息
     * @param id 团队id
     * @return
     */
    public TeamEntity getTeamInfoById(int id){
        return teamMapper.getTeamInfoById(id);
    }

    /**
     * 根据用户id获取团队信息
     * @param userid 用户id
     * @return
     */
    public List<TeamEntity> getTeamInfosByUserId(int userid){
        return teamMapper.getTeamInfosByUserId(userid);
    }
}
