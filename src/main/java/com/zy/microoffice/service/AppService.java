package com.zy.microoffice.service;

import com.zy.microoffice.entity.AppEntity;
import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private AppMapper appMapper;

    /**
     * 根据应用类别id或者应用信息（appTypeid传入-1获取所有应用）
     *
     * @param appTypeid 应用类别id
     * @return
     */
    public ResponseEntity<List<AppEntity>> getApps(int appTypeid) {
        return ResponseUtils.success(appMapper.getApps(appTypeid));
    }

    /**
     * 根据用户id及应用类别id获取应用 （appTypeid传入-1获取所有应用）
     *
     * @param userid 用户id
     * @return
     */
    public ResponseEntity<List<AppEntity>> getAppsByUser(int userid, int appTypeid) {
        return ResponseUtils.success(appMapper.getAppsByUser(userid, appTypeid));
    }

    /**
     * 订阅应用
     *
     * @param userid 用户id
     * @param appid  应用id
     * @return
     */
    public ResponseEntity<Boolean> subscribeApp(int userid, int appid) {
        return ResponseUtils.success(appMapper.subscribeApp(userid, appid));
    }

    /**
     * 取消订阅应用
     *
     * @param userid 用户id
     * @param appid  应用id
     * @return
     */
    public ResponseEntity<Boolean> unSubscribeApp(int userid, int appid) {
        return ResponseUtils.success(appMapper.unSubscribeApp(userid, appid));
    }

    /**
     * 获取应用详情
     *
     * @param appid 应用id
     * @return
     */
    public ResponseEntity<AppEntity> getAppDetail(int appid) {
        return ResponseUtils.success(appMapper.getAppDetail(appid));
    }
}
