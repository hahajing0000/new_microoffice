package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.AppTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppTypeMapper {
    /**
     * 获取所有应用类别
     * @return
     */
    List<AppTypeEntity> getAppTypes();
}
