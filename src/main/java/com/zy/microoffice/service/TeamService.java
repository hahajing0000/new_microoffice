package com.zy.microoffice.service;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.TeamEntity;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.mapper.TeamMapper;
import com.zy.microoffice.utils.NumberUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
    public ResponseEntity createTeam(TeamEntity entity){
        Random random=new Random();
        int result= NumberUtils.getNumberByRange(10000000,99999999);
        entity.setTeamcode(String.valueOf(result));
        return ResponseUtils.success(teamMapper.createTeam(entity));
    }

    /**
     * 删除团队
     * @param id 团队id
     * @return
     */
    public ResponseEntity removeTeam(int id){
        return ResponseUtils.success(teamMapper.removeTeam(id));
    }

    /**
     * 修改团队
     * @param entity 团队实体
     * @return
     */
    public ResponseEntity modifyTeam(TeamEntity entity){
        return ResponseUtils.success(teamMapper.modifyTeam(entity));
    }

    /**
     * 根据团队id获取团队信息
     * @param id 团队id
     * @return
     */
    public ResponseEntity<TeamEntity> getTeamInfoById(int id){
        return ResponseUtils.success(teamMapper.getTeamInfoById(id));
    }

    /**
     * 根据用户id获取团队信息
     * @param userid 用户id
     * @return
     */
    public ResponseEntity<List<TeamEntity>> getTeamInfosByUserId(int userid){
        return ResponseUtils.success(teamMapper.getTeamInfosByUserId(userid));
    }

    /**
     * 加入团队
     * @param teamcode 团队码
     * @param userid 用户id
     * @return
     */
    public ResponseEntity addUserToTeam(String teamcode, int userid){
        return ResponseUtils.success(teamMapper.addUserToTeam(teamcode,userid));
    }

    /**
     * 退出团队
     * @param teamcode 团队码
     * @param userid 用户id
     * @return
     */
    public ResponseEntity quitTeam(String teamcode,int userid){
        return ResponseUtils.success(teamMapper.quitTeam(teamcode,userid));
    }

    /**
     * 获取团队下的所有成员用户
     * @param teamcode 团队码
     * @return
     */
    public ResponseEntity<List<UserEntity>> getUsersFromTeam(String teamcode){
        return ResponseUtils.success(teamMapper.getUsersFromTeam(teamcode));
    }
}
