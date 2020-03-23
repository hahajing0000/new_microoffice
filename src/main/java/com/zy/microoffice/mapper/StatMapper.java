package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.CalendarEntity;
import com.zy.microoffice.entity.InterViewCountEntity;
import com.zy.microoffice.entity.StatEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface StatMapper {
    /**
     * 添加面试信息
     * @param statEntity
     * @return
     */
    boolean addStat(StatEntity statEntity);

    /**
     * 修改面试信息
     * @param statEntity
     * @return
     */
    boolean modifyStat(StatEntity statEntity);

    /**
     * 通过面试
     * @param id
     * @return
     */
    boolean pass(int id);

    /**
     * 面试失败
     * @param id
     * @return
     */
    boolean failed(int id);

    /**
     * 删除面试信息
     * @param id
     * @return
     */
    boolean remove(int id);

    /**
     * 通过id获取面试信息
     * @param id
     * @return
     */
    StatEntity getStatById(int id);

    /**
     * 根据添加获取面试信息
     * @param starttime
     * @param endtime
     * @return
     */
    List<StatEntity> getStats(String phonenumber,String starttime,String endtime,int currentpage);

    /**
     * 根据手机号码获取数据页数
     * @param phonenumber
     * @return
     */
    int getDataCount(String phonenumber);

    /**
     * 获取有Offer的人数
     * @return
     */
    int getOfferCount();

    /**
     * 获取今天面试人数
     * @return
     */
    int getInterViewCountToday();

    /**
     * 获取面试成功率
     * @return
     */
    int getInterViewSuccess();

    /**
     * 获取已经下Offer的面试信息
     * @return
     */
    List<StatEntity> getStatEntityBySuccess();

    /**
     * 获取面试成功统计数据
     * @return
     */
    HashMap<String,Integer> getSuceessRate();

    /**
     * 获取日历相关数据
     * @return
     */
    List<CalendarEntity> getCalendarData(String phonenumber);

    /**
     * 获取用户预约面试数量
     * @return
     */
    List<InterViewCountEntity> getUserInterViewCount();

    /**
     * 获取今日面试信息
     * @return
     */
    List<StatEntity> getStatEntityToady();
}
