package com.example.janche.log.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Table(name = "crash_t")
public class CrashLog {
    private String udid;

    private String appid;

    private String devicetype;

    private String channel;

    private String version;

    private String confversion;

    private String logtype;

    private String logcontent;

    private String devicemodel;

    private String osversion;

    private String v1;

    private String v2;

    private String v3;

    private String v4;

    private String v5;

    private String v6;

    private String v7;

    private String v8;

    private String localtime;

    @Column(name = "`localtimezone`")
    private String localtimezone;

    @Column(name = "`timestamp`")
    private Long timestamp;

    private String ip;

    private String country;

    private String city;
}