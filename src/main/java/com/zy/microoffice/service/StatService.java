package com.zy.microoffice.service;

import com.zy.microoffice.entity.CalendarEntity;
import com.zy.microoffice.entity.InterViewCountEntity;
import com.zy.microoffice.entity.StatEntity;
import com.zy.microoffice.mapper.StatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StatService {

    @Autowired
    StatMapper statMapper;

    /**
     * 添加面试信息
     *
     * @param statEntity
     * @return
     */
    public boolean addStat(StatEntity statEntity) {
        return statMapper.addStat(statEntity);
    }

    /**
     * 修改面试信息
     *
     * @param statEntity
     * @return
     */
    public boolean modifyStat(StatEntity statEntity) {
        return statMapper.modifyStat(statEntity);
    }

    /**
     * 通过面试
     *
     * @param id
     * @return
     */
    public boolean pass(int id) {
        return statMapper.pass(id);
    }

    /**
     * 面试失败
     *
     * @param id
     * @return
     */
    public boolean failed(int id) {
        return statMapper.failed(id);
    }

    /**
     * 删除面试信息
     *
     * @param id
     * @return
     */
    public boolean remove(int id) {
        return statMapper.remove(id);
    }

    /**
     * 通过id获取面试信息
     *
     * @param id
     * @return
     */
    public StatEntity getStatById(int id) {
        return statMapper.getStatById(id);
    }

    /**
     * 根据添加获取面试信息
     *
     * @param starttime
     * @param endtime
     * @return
     */
    public List<StatEntity> getStats(String classname,String phonenumber, String starttime, String endtime, int page) {
        return statMapper.getStats(classname,phonenumber, starttime, endtime, page);
    }

    /**
     * 根据手机号码获取数据页数
     *
     * @param phonenumber
     * @return
     */
    public int getDataCount(String phonenumber,String classname) {
        return statMapper.getDataCount(phonenumber,classname);
    }

    /**
     * 获取有Offer的人数
     *
     * @return
     */
    public int getOfferCount(String classname) {
        return statMapper.getOfferCount(classname);
    }

    /**
     * 获取今天面试人数
     *
     * @return
     */
    public int getInterViewCountToday(String classname) {
        return statMapper.getInterViewCountToday(classname);
    }

    /**
     * 获取面试成功率
     *
     * @return
     */
    public double getInterViewSuccess(String classname) {
        return statMapper.getInterViewSuccess(classname);
    }

    /**
     * 获取已经下Offer的面试信息
     *
     * @return
     */
    public List<StatEntity> getStatEntityBySuccess(String classname) {
        return statMapper.getStatEntityBySuccess(classname);
    }

    /**
     * 获取面试成功统计数据
     *
     * @return
     */
    public HashMap<String, Integer> getSuceessRate(String classname) {
        return statMapper.getSuceessRate(classname);
    }

    /**
     * 获取日历相关数据
     *
     * @return
     */
    public List<CalendarEntity> getCalendarData(String phonenumber,String classname) {
        return statMapper.getCalendarData(phonenumber,classname);
    }

    /**
     * 获取用户预约面试数量
     *
     * @return
     */
    public List<InterViewCountEntity> getUserInterViewCount(String classname) {
        return statMapper.getUserInterViewCount(classname);
    }

    /**
     * 获取今天面试信息
     *
     * @return
     */
    public List<StatEntity> getStatEntityToady(String classname) {
        return statMapper.getStatEntityToady(classname);
    }
}
