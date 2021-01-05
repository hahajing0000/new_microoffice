package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.AppEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppMapper {
    /**
     * 根据应用类别id或者应用信息（appTypeid传入-1获取所有应用）
     *
     * @param appTypeid 应用类别id
     * @return
     */
    List<AppEntity> getApps(int appTypeid);

    /**
     * 根据用户id及应用类别id获取应用 （appTypeid传入-1获取所有应用）
     *
     * @param userid 用户id
     * @return
     */
    List<AppEntity> getAppsByUser(int userid, int appTypeid);

    /**
     * 订阅应用
     *
     * @param userid 用户id
     * @param appid  应用id
     * @return
     */
    boolean subscribeApp(int userid, int appid);

    /**
     * 取消订阅应用
     *
     * @param userid 用户id
     * @param appid  应用id
     * @return
     */
    boolean unSubscribeApp(int userid, int appid);

    /**
     * 获取应用详情
     *
     * @param appid 应用id
     * @return
     */
    AppEntity getAppDetail(int appid);
}
