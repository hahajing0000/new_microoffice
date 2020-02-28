package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsMapper {
    /**
     * 添加联系人
     * @param userid 用户id
     * @param contactsid 联系人id
     * @return
     */
    boolean addContacts(int userid,int contactsid);

    /**
     * 获取联系人
     * @param userid 用户id
     * @return
     */
    List<UserEntity> getContacts(int userid);
}
