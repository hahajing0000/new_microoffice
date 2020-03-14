package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.StatEntity;
import org.springframework.stereotype.Repository;

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
    List<StatEntity> getStats(String starttime,String endtime);
}
