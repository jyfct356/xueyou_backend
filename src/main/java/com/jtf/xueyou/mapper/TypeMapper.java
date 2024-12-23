package com.jtf.xueyou.mapper;

import com.jtf.xueyou.annotation.TimeFill;
import com.jtf.xueyou.constant.TimeFillType;
import com.jtf.xueyou.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.util.List;

@Mapper
public interface TypeMapper {
    @TimeFill(TimeFillType.INSERT)
    void addType(Type type);

    List<Type> getTypeList();
}
