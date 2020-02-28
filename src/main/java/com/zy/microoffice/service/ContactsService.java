package com.zy.microoffice.service;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.mapper.ContactsMapper;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContactsService {

    @Autowired
    ContactsMapper contactsMapper;

    /**
     * 添加联系人
     * @param userid 用户id
     * @param contactsid 联系人id
     * @return
     */
    public ResponseEntity addContacts(int userid, int contactsid){
        return ResponseUtils.success(contactsMapper.addContacts(userid,contactsid));
    }

    /**
     * 获取联系人
     * @param userid 用户id
     * @return
     */
    public ResponseEntity<List<UserEntity>> getContacts(int userid){
        return ResponseUtils.success(contactsMapper.getContacts(userid));
    }
}
