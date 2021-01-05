package com.zy.microoffice.controller;

import com.zy.microoffice.entity.AppEntity;
import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.service.AppService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "应用模块", description = "应用模块", tags = "应用模块")
@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    /**
     * 根据应用类别id或者应用信息（appTypeid传入-1获取所有应用）
     *
     * @param appTypeid 应用类别id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据应用类别id或者应用信息（appTypeid传入-1获取所有应用）", notes = "根据应用类别id或者应用信息（appTypeid传入-1获取所有应用）", httpMethod = "GET")
    @GetMapping("/getApps")
    public ResponseEntity<List<AppEntity>> getApps(
            @RequestParam
            @ApiParam(value = "应用类别id", name = "appTypeid", required = true)
                    int appTypeid) {
        return appService.getApps(appTypeid);
    }

    /**
     * 根据用户id及应用类别id获取应用 （appTypeid传入-1获取所有应用）
     *
     * @param userid 用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据用户id及应用类别id获取应用 （appTypeid传入-1获取所有应用）", notes = "根据用户id及应用类别id获取应用 （appTypeid传入-1获取所有应用）", httpMethod = "GET")
    @GetMapping("/getAppsByUser")
    public ResponseEntity<List<AppEntity>> getAppsByUser(
            @RequestParam
            @ApiParam(value = "用户id", name = "userid", required = true)
                    int userid,
            @RequestParam
            @ApiParam(value = "应用类型id", name = "appTypeid", required = true)
                    int appTypeid) {
        return appService.getAppsByUser(userid, appTypeid);
    }

    /**
     * 订阅应用
     *
     * @param userid 用户id
     * @param appid  应用id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "订阅应用", notes = "订阅应用", httpMethod = "POST")
    @PostMapping("/subscribeApp")
    public ResponseEntity<Boolean> subscribeApp(
            @RequestParam
            @ApiParam(value = "用户id", name = "userid", required = true)
                    int userid,
            @RequestParam
            @ApiParam(value = "应用id", name = "appid", required = true)
                    int appid) {
        return appService.subscribeApp(userid, appid);
    }

    /**
     * 取消订阅应用
     *
     * @param userid 用户id
     * @param appid  应用id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "取消订阅应用", notes = "取消订阅应用", httpMethod = "DELETE")
    @DeleteMapping("/unSubscribeApp")
    public ResponseEntity<Boolean> unSubscribeApp(
            @RequestParam
            @ApiParam(value = "用户id", name = "userid", required = true)
                    int userid,
            @RequestParam
            @ApiParam(value = "应用id", name = "appid", required = true)
                    int appid) {
        return appService.unSubscribeApp(userid, appid);
    }

    /**
     * 获取应用详情
     *
     * @param appid 应用id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "获取应用详情", notes = "获取应用详情", httpMethod = "GET")
    @GetMapping("/getAppDetail")
    public ResponseEntity<AppEntity> getAppDetail(
            @RequestParam
            @ApiParam(value = "应用id", name = "appid", required = true)
                    int appid) {
        return appService.getAppDetail(appid);
    }
}
