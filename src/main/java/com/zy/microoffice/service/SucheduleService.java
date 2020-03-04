package com.zy.microoffice.service;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.ScheduleEntity;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.mapper.SucheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucheduleService {

    @Autowired
    SucheduleMapper sucheduleMapper;

    /**
     * 添加日程
     * @param scheduleEntity 日程实体
     * @return
     */
    public ResponseEntity<Boolean> addSuchedule(ScheduleEntity scheduleEntity){
        return ResponseUtils.success(sucheduleMapper.addSuchedule(scheduleEntity));
    }

    /**
     * 修改日程
     * @param scheduleEntity 日程实体
     * @return
     */
    public ResponseEntity<Boolean> modifySuchedule(ScheduleEntity scheduleEntity){
        return ResponseUtils.success(sucheduleMapper.modifySuchedule(scheduleEntity));
    }

    /**
     * 删除日程
     * @param id 日程id
     * @return
     */
    public ResponseEntity<Boolean> removeSuchedule(int id){
        return ResponseUtils.success(sucheduleMapper.removeSuchedule(id));
    }

    /**
     * 根据id获取日程
     * @param id 日程id
     * @return
     */
    public ResponseEntity<ScheduleEntity> getScheduleById(int id){
        return ResponseUtils.success(sucheduleMapper.getScheduleById(id));
    }

    /**
     * 获取创建/加入的日程
     * @param userid 用户id
     * @return
     */
    public ResponseEntity<List<ScheduleEntity>> getSchedules(int userid){
        return ResponseUtils.success(sucheduleMapper.getSchedules(userid));
    }

    /**
     * 参与会议日程
     * @param scheduleidid 日程id
     * @param userid 用户id
     * @return
     */
    public ResponseEntity<Boolean> addParticipant(int scheduleidid, int userid){
        return ResponseUtils.success(sucheduleMapper.addParticipant(scheduleidid,userid));
    }

    /**
     * 退出会议日程
     * @param scheduleidid 日程id
     * @param userid 用户id
     * @return
     */
    public ResponseEntity<Boolean> removeParticipant(int scheduleidid, int userid){
        return ResponseUtils.success(sucheduleMapper.removeParticipant(scheduleidid,userid));
    }

    /**
     * 获取会议日程的所有人员
     * @param scheduleidid 日程id
     * @return
     */
    public ResponseEntity<List<UserEntity>> getUsersByParticipant(int scheduleidid){
        return ResponseUtils.success(sucheduleMapper.getUsersByParticipant(scheduleidid));
    }
}
