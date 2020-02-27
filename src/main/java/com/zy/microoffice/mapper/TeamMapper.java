package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.TeamEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public interface TeamMapper {
    /**
     * 创建团队
     * @param entity 团队实体
     * @return
     */
    boolean createTeam(TeamEntity entity);

    /**
     * 删除团队
     * @param teamid 团队id
     * @return
     */
    boolean removeTeam(int teamid);

    /**
     * 修改团队
     * @param entity 团队实体
     * @return
     */
    boolean modifyTeam(TeamEntity entity);

    /**
     * 根据团队id获取团队信息
     * @param id 团队id
     * @return
     */
    TeamEntity getTeamInfoById(int id);

    /**
     * 根据用户id获取团队信息
     * @param userid 用户id
     * @return
     */
    List<TeamEntity> getTeamInfosByUserId(int userid);

    /**
     * 加入团队
     * @param teamcode 团队码
     * @param userid 用户id
     * @return
     */
    boolean addUserToTeam(String teamcode, int userid);

    /**
     * 退出团队
     * @param teamcode 团队码
     * @param userid 用户id
     * @return
     */
    boolean quitTeam(String teamcode,int userid);
}
