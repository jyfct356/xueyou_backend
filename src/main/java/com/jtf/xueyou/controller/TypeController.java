package com.jtf.xueyou.controller;


import com.jtf.xueyou.constant.TypeConstants;
import com.jtf.xueyou.entity.Type;
import com.jtf.xueyou.service.TypeService;
import com.jtf.xueyou.util.ValidateUtil;
import com.jtf.xueyou.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping("/add")
    public Result addType(@RequestBody Type type) {
        if (type == null) {
            return Result.fail("type不能为空");
        }
        if (ValidateUtil.isStrNullorEmpty(type.getName())) {
            return Result.fail("type:name不能为空");
        }
        if (ValidateUtil.isStrLongerThan(type.getName(), TypeConstants.NAME_MAX_LENGTH)) {
            return Result.fail("type:name长度超过" + TypeConstants.NAME_MAX_LENGTH + "个字符");
        }
        Integer id = typeService.addType(type);
        return Result.success(id);
    }

    @GetMapping("/list")
    public Result getTypeList() {
        List<Type> typeList = typeService.getTypeList();
        return Result.success(typeList);
    }
}
