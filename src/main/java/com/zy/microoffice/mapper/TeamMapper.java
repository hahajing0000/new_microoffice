package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.TeamEntity;
import com.zy.microoffice.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public interface TeamMapper {
    /**
     * 创建团队
     *
     * @param entity 团队实体
     * @return
     */
    boolean createTeam(TeamEntity entity);

    /**
     * 删除团队
     *
     * @param teamid 团队id
     * @return
     */
    boolean removeTeam(int teamid);

    /**
     * 修改团队
     *
     * @param entity 团队实体
     * @return
     */
    boolean modifyTeam(TeamEntity entity);

    /**
     * 根据团队id获取团队信息
     *
     * @param id 团队id
     * @return
     */
    TeamEntity getTeamInfoById(int id);

    /**
     * 根据用户id获取团队信息
     *
     * @param userid 用户id
     * @return
     */
    List<TeamEntity> getTeamInfosByUserId(int userid);

    /**
     * 加入团队
     *
     * @param teamcode 团队码
     * @param userid   用户id
     * @return
     */
    boolean addUserToTeam(String teamcode, int userid);

    /**
     * 退出团队
     *
     * @param teamcode 团队码
     * @param userid   用户id
     * @return
     */
    boolean quitTeam(String teamcode, int userid);

    /**
     * 获取团队下的所有成员用户
     *
     * @param teamcode 团队码
     * @return
     */
    List<UserEntity> getUsersFromTeam(String teamcode);

    /**
     * 获取加入团队申请
     *
     * @param teamcode 团队Code
     * @return
     */
    List<UserEntity> getAddApply(String teamcode);

    /**
     * 同意加入团队
     *
     * @param userid   用户id
     * @param teamcode 团队Code
     * @return
     */
    boolean agreeApply(int userid, String teamcode);
}
