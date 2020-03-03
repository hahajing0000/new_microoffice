package com.zy.microoffice.controller;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.service.ContactsService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "联系人模块",description = "联系人模块",tags = "联系人模块")
@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    ContactsService contactsService;

    /**
     * 添加联系人
     * @param userid 用户id
     * @param contactsid 联系人id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "添加联系人",notes = "添加联系人",httpMethod = "POST")
    @PostMapping("/addContacts")
    public ResponseEntity addContacts(@RequestParam
                                                  @ApiParam(name = "userid",value = "用户id",required = true)
                                                  int userid,
                                      @RequestParam
                                              @ApiParam(name = "contactsid",value = "联系人id",required = true)
                                      int contactsid){
        return contactsService.addContacts(userid,contactsid);
    }

    /**
     * 获取联系人
     * @param userid 用户id
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "获取联系人",notes = "获取联系人",httpMethod = "GET")
    @GetMapping("/getContacts")
    public ResponseEntity<List<UserEntity>> getContacts(@RequestParam
                                                                    @ApiParam(name = "userid",value = "用户id",required = true)
                                                                    int userid){
        return contactsService.getContacts(userid);
    }

    /**
     * 获取添加好友的申请
     * @param userid
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "获取添加好友的申请",notes = "获取添加好友的申请",httpMethod = "GET")
    @GetMapping("/getAddApply")
    public ResponseEntity<List<UserEntity>> getAddApply(@RequestParam
                                                                    @ApiParam(name = "userid",value = "用户id",required = true)
                                                                    int userid){
        return contactsService.getAddApply(userid);
    }

    /**
     * 同意申请
     * @param userid
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "同意申请",notes = "同意申请",httpMethod = "POST")
    @PostMapping("/agreeApply")
    public ResponseEntity<Boolean> agreeApply(int userid, int contactsid){
        return contactsService.agreeApply(userid,contactsid);
    }
}
