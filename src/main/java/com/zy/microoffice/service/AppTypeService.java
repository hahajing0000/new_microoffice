package com.zy.microoffice.service;

import com.zy.microoffice.entity.AppTypeEntity;
import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.mapper.AppTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppTypeService {

    @Autowired
    AppTypeMapper appTypeMapper;

    /**
     * 获取所有应用类别
     * @return
     */
    public ResponseEntity<List<AppTypeEntity>> getAppTypes(){
        return ResponseUtils.success(appTypeMapper.getAppTypes());
    }
}
