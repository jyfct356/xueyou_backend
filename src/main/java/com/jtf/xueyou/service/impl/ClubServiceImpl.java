package com.jtf.xueyou.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jtf.xueyou.constant.ClubConstants;
import com.jtf.xueyou.constant.ClubTypeConstants;
import com.jtf.xueyou.dto.ClubDTO;
import com.jtf.xueyou.entity.Club;
import com.jtf.xueyou.entity.ClubType;
import com.jtf.xueyou.mapper.ClubMapper;
import com.jtf.xueyou.mapper.ClubTypeMapper;
import com.jtf.xueyou.service.ClubService;
import com.jtf.xueyou.util.GenUtil;
import com.jtf.xueyou.vo.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private ClubTypeMapper clubTypeMapper;

    @Override
    @Transactional()
    public Integer addClub(ClubDTO clubDTO) {
        Club club = new Club();
        BeanUtils.copyProperties(clubDTO, club);

        club.setUuid(GenUtil.genUUID());
        Pair<Double, Double> position = GenUtil.genPosition();
        club.setLongitude(position.getFirst());
        club.setLatitude(position.getSecond());
        club.setRating(ClubConstants.INITIAL_RATE);
        club.setStatus(ClubConstants.STATUS_VALID);
//        LocalDateTime now = LocalDateTime.now();
//        club.setCreateTime(now);
//        club.setUpdateTime(now);

        clubMapper.addClub(club);

        List<Integer> typeIds = clubDTO.getTypeIds();
        for (Integer typeId : typeIds) {
            ClubType clubType = new ClubType();
            clubType.setTypeId(typeId);
            clubType.setClubId(club.getId());
            clubType.setStatus(ClubTypeConstants.STATUS_VALID);
            clubTypeMapper.addClubType(clubType);
        }
        return club.getId();
    }

    @Override
    public PageResult getClubPage(Integer pageNum, Integer pageSize, Integer typeId) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Club> page;
        if (typeId != null && typeId > 0) {
            page = clubMapper.getClubPageByTypeId(typeId);
        } else {
            page = clubMapper.getClubPage();
        }
        PageResult pageResult = new PageResult();
        pageResult.setRecords(page);
        pageResult.setTotal(pageResult.getRecords().size());
        return pageResult;
    }

    @Override
    public Integer countClub() {
        Integer count = clubMapper.count();
        return count;
    }
}
