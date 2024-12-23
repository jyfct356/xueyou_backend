package com.jtf.xueyou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubDTO {
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

    private List<Integer> typeIds;
}
