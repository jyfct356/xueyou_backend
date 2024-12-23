package com.jtf.xueyou.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * @TableName club_type
 */
@Data
public class ClubType implements Serializable {
    private Integer id;

    private Integer typeId;

    private Integer clubId;

    private Byte status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}