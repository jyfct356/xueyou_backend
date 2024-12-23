package com.jtf.xueyou.controller;

import com.jtf.xueyou.constant.ClubConstants;
import com.jtf.xueyou.dto.ClubDTO;
import com.jtf.xueyou.entity.Club;
import com.jtf.xueyou.service.ClubService;
import com.jtf.xueyou.util.ValidateUtil;
import com.jtf.xueyou.vo.PageResult;
import com.jtf.xueyou.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    /**
     *
     * @param clubDTO
     * @return
     */
    @PostMapping("/add")
    public Result addClub(@RequestBody ClubDTO clubDTO) {
        // 数据校验
        if (clubDTO == null) {
            return Result.fail("clubDTO不能为空");
        }
        if (clubDTO.getName() == null || clubDTO.getName().trim().isEmpty()) {
            return Result.fail("clubDTO:name字段不能为空");
        }
        if (clubDTO.getLocation() == null || clubDTO.getLocation().trim().isEmpty()) {
            return Result.fail("clubDTO:location字段不能为空");
        }
        if (clubDTO.getImage() == null || clubDTO.getImage().trim().isEmpty()) {
            return Result.fail("clubDTO:image字段不能为空");
        }
        if (ValidateUtil.isStrLongerThan(clubDTO.getName(), ClubConstants.NAME_MAX_LENGTH)) {
            return Result.fail("clubDTO:name字段长度超过" + ClubConstants.NAME_MAX_LENGTH + "个字符");
        }
        if (ValidateUtil.isStrLongerThan(clubDTO.getLocation(), ClubConstants.LOCATION_MAX_LENGTH)) {
            return Result.fail("clubDTO:location字段长度超过" + ClubConstants.LOCATION_MAX_LENGTH + "个字符");
        }
        if (ValidateUtil.isStrLongerThan(clubDTO.getImage(), ClubConstants.IMAGE_MAX_LENGTH)) {
            return Result.fail("club:image字段长度超过" + ClubConstants.IMAGE_MAX_LENGTH + "个字符");
        }

        // 插入记录
        Integer id = clubService.addClub(clubDTO);
        return Result.success(id);
    }

    @GetMapping("/page")
    public Result getClubPage(@RequestParam(name = "pageNum") Integer pageNum,
                              @RequestParam(name = "pageSize") Integer pageSize,
                              @RequestParam(name = "typeId", required = false) Integer typeId) {
        // 数据校验
        if (pageNum == null || pageSize == null) {
            return Result.fail("pageNum和pageSize不能为空");
        }
        PageResult clubPage = clubService.getClubPage(pageNum, pageSize, typeId);
        return Result.success(clubPage);
    }

    @GetMapping("/count")
    public Result countClub() {
        Integer count = clubService.countClub();
        return Result.success(count);
    }
}
