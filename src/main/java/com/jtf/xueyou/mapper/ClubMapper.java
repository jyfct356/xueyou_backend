package com.jtf.xueyou.mapper;

import com.github.pagehelper.Page;
import com.jtf.xueyou.annotation.TimeFill;
import com.jtf.xueyou.constant.TimeFillType;
import com.jtf.xueyou.entity.Club;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClubMapper {
    @TimeFill(value = TimeFillType.INSERT)
    void addClub(Club club);

    Page<Club> getClubPage();

    Integer count();

    Page<Club> getClubPageByTypeId(Integer typeId);
}
