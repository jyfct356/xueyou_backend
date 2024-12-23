package com.jtf.xueyou.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Type {
    private Integer id;
    private String name;
    private Byte status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
