package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.MeetingRoomEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRoomMapper {
    /**
     * 添加会议室
     *
     * @param meetingRoomEntity 会议室请求实体
     * @return
     */
    boolean addMeetingRoom(MeetingRoomEntity meetingRoomEntity);

    /**
     * 删除会议室
     *
     * @param id      会议室id
     * @param creator 创建者id
     * @return
     */
    boolean removeMeetingRoom(int id, int creator);
}
