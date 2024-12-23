package com.jtf.xueyou.service;

import com.jtf.xueyou.entity.Type;

import java.util.List;

public interface TypeService {

    Integer addType(Type type);

    List<Type> getTypeList();
}
