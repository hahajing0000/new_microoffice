package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.ScheduleEntity;
import com.zy.microoffice.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucheduleMapper {
    /**
     * 添加日程
     * @param scheduleEntity 日程实体
     * @return
     */
    boolean addSuchedule(ScheduleEntity scheduleEntity);

    /**
     * 修改日程
     * @param scheduleEntity 日程实体
     * @return
     */
    boolean modifySuchedule(ScheduleEntity scheduleEntity);

    /**
     * 删除日程
     * @param id 日程id
     * @return
     */
    boolean removeSuchedule(int id);

    /**
     * 根据id获取日程
     * @param id 日程id
     * @return
     */
    ScheduleEntity getScheduleById(int id);

    /**
     * 获取创建/加入的日程
     * @param userid 用户id
     * @return
     */
    List<ScheduleEntity> getSchedules(int userid);

    /**
     * 参与会议日程
     * @param scheduleidid 日程id
     * @param userid 用户id
     * @return
     */
    boolean addParticipant(int scheduleidid,int userid);

    /**
     * 退出会议日程
     * @param scheduleidid 日程id
     * @param userid 用户id
     * @return
     */
    boolean removeParticipant(int scheduleidid,int userid);

    /**
     * 获取会议日程的所有人员
     * @param scheduleidid 日程id
     * @return
     */
    List<UserEntity> getUsersByParticipant(int scheduleidid);
}
