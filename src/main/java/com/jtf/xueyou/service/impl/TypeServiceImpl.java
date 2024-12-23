package com.jtf.xueyou.service.impl;

import com.jtf.xueyou.constant.TypeConstants;
import com.jtf.xueyou.entity.Type;
import com.jtf.xueyou.mapper.TypeMapper;
import com.jtf.xueyou.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Integer addType(Type type) {
        type.setStatus(TypeConstants.STATUS_VALID);
//        LocalDateTime now = LocalDateTime.now();
//        type.setCreateTime(now);
//        type.setUpdateTime(now);
        typeMapper.addType(type);
        return type.getId();
    }

    @Override
    public List<Type> getTypeList() {
        List<Type> typeList = typeMapper.getTypeList();
        return typeList;
    }
}
