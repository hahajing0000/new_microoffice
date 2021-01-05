package com.zy.microoffice.service;

import com.zy.microoffice.entity.MeetingRoomEntity;
import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.mapper.MeetingRoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MeetingRoomService {
    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    /**
     * 添加会议室
     *
     * @param meetingRoomEntity 会议室请求实体
     * @return
     */
    public ResponseEntity<Boolean> addMeetingRoom(MeetingRoomEntity meetingRoomEntity) {
        return ResponseUtils.success(meetingRoomMapper.addMeetingRoom(meetingRoomEntity));
    }

    /**
     * 删除会议室
     *
     * @param id      会议室id
     * @param creator 创建者id
     * @return
     */
    public ResponseEntity<Boolean> removeMeetingRoom(int id, int creator) {
        return ResponseUtils.success(meetingRoomMapper.removeMeetingRoom(id, creator));
    }
}
