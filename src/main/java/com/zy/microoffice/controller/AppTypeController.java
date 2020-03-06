package com.zy.microoffice.controller;

import com.zy.microoffice.entity.AppTypeEntity;
import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.service.AppTypeService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "应用类型模块",description = "应用类型模块",tags = "应用类型模块")
@RestController
@RequestMapping("/apptype")
public class AppTypeController {

    @Autowired
    private AppTypeService appTypeService;

    /**
     * 获取所有应用类别
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "获取应用类型",notes = "获取应用类型",httpMethod = "GET")
    @GetMapping("/getAppTypes")
    public ResponseEntity<List<AppTypeEntity>> getAppTypes(){
        return appTypeService.getAppTypes();
    }
}
