package com.jtf.xueyou.mapper;

import com.jtf.xueyou.annotation.TimeFill;
import com.jtf.xueyou.constant.TimeFillType;
import com.jtf.xueyou.entity.ClubType;
import org.apache.ibatis.annotations.Mapper;

/**
* @author jtfsh
* @description 针对表【club_type】的数据库操作Mapper
* @createDate 2024-12-19 10:14:16
* @Entity com.jtf.xueyou.entity.ClubType
*/
@Mapper
public interface ClubTypeMapper  {

    @TimeFill(TimeFillType.INSERT)
    void addClubType(ClubType clubType);
}




