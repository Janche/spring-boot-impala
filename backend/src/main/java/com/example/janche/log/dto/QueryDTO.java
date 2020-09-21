package com.example.janche.log.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询条件")
public class QueryDTO {

    @ApiModelProperty("游戏id")
    private String appid;

    @ApiModelProperty("设备类型：IOS/Android")
    private String devicetype;

    @ApiModelProperty("渠道ID")
    private String channel;

    @ApiModelProperty("应用版本")
    private String version;

    @ApiModelProperty("开始时间")
    private Object startTime;

    @ApiModelProperty("结束时间")
    private Object endTime;
}
