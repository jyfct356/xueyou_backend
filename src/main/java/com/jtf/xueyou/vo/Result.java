package com.jtf.xueyou.vo;

import com.jtf.xueyou.constant.ResultConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Result implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        return new Result(ResultConstants.SUCCESS, null, null);
    }

    public static Result success(Object data) {
        return new Result(ResultConstants.SUCCESS, null, data);
    }

    public static Result fail(String msg) {
        return new Result(ResultConstants.FAIL, msg, null);
    }

}
