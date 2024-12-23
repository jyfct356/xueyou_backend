package com.jtf.xueyou.service;

import com.jtf.xueyou.dto.ClubDTO;
import com.jtf.xueyou.vo.PageResult;

public interface ClubService {
    Integer addClub(ClubDTO clubDTO);

    PageResult getClubPage(Integer pageNum, Integer pageSize, Integer typeId);

    Integer countClub();
}
