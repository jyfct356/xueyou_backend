package com.jtf.xueyou.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Club {
    private Integer id;

    private String uuid;

    private String name;

    private Double rating;

    private String image;

    private String location;

    private Double longitude;

    private Double latitude;

    private Byte status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
