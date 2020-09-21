package com.example.janche.log.dto;

import lombok.Data;

@Data
public class CrashOutputDTO {

    private String logcontent;

    private String v1;

    private Long userCount;

    private Long totalCount;

    private String crashTime;
}
