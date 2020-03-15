package com.zy.microoffice.service;

import com.zy.microoffice.entity.CalendarEntity;
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
     * @param statEntity
     * @return
     */
    public boolean addStat(StatEntity statEntity){
        return statMapper.addStat(statEntity);
    }

    /**
     * 修改面试信息
     * @param statEntity
     * @return
     */
    public boolean modifyStat(StatEntity statEntity){
        return statMapper.modifyStat(statEntity);
    }

    /**
     * 通过面试
     * @param id
     * @return
     */
    public boolean pass(int id){
        return statMapper.pass(id);
    }

    /**
     * 面试失败
     * @param id
     * @return
     */
    public boolean failed(int id){
        return statMapper.failed(id);
    }

    /**
     * 删除面试信息
     * @param id
     * @return
     */
    public boolean remove(int id){
        return statMapper.remove(id);
    }

    /**
     * 通过id获取面试信息
     * @param id
     * @return
     */
    public StatEntity getStatById(int id){
        return statMapper.getStatById(id);
    }

    /**
     * 根据添加获取面试信息
     * @param starttime
     * @param endtime
     * @return
     */
    public List<StatEntity> getStats(String phonenumber,String starttime, String endtime){
        return statMapper.getStats(phonenumber,starttime,endtime);
    }

    /**
     * 获取有Offer的人数
     * @return
     */
    public int getOfferCount(){
        return statMapper.getOfferCount();
    }

    /**
     * 获取今天面试人数
     * @return
     */
    public int getInterViewCountToday(){
        return statMapper.getInterViewCountToday();
    }

    /**
     * 获取面试成功率
     * @return
     */
    public double getInterViewSuccess(){
        return statMapper.getInterViewSuccess();
    }

    /**
     * 获取已经下Offer的面试信息
     * @return
     */
    public List<StatEntity> getStatEntityBySuccess(){
        return statMapper.getStatEntityBySuccess();
    }

    /**
     * 获取面试成功统计数据
     * @return
     */
    public HashMap<String,Integer> getSuceessRate(){
        return statMapper.getSuceessRate();
    }

    /**
     * 获取日历相关数据
     * @return
     */
    public List<CalendarEntity> getCalendarData(){
        return statMapper.getCalendarData();
    }
}
