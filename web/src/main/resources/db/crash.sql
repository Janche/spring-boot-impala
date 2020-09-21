/*
    在impala上创建crash表
*/
CREATE TABLE crash
(
    udid STRING,
    appid STRING,
    devicetype STRING,
    channel STRING,
    `version` STRING,
    confversion STRING,
    logtype STRING,
    logcontent STRING,
    devicemodel STRING,
    osversion STRING,
    v1 STRING,
    v2 STRING,
    v3 STRING,
    v4 STRING,
    v5 STRING,
    v6 STRING,
    v7 STRING,
    v8 STRING,
    `localtime` STRING,
    localtimezone STRING,
    `timestamp` BIGINT,
    ip STRING,
    country STRING,
    city STRING
) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'
STORED AS TEXTFILE;

/*
    插入数据
*/

insert into table crash_t values("01","com.example.gymnasticsqueen","Android","APP_STORE","1.0.0","","crash","日志内容001","","",
    "1","","","","","","","","2020-06-27 14:35:24","GMT+08:00",1599207585,"192.168.0.26","CN","chengdu");
insert into table crash_t values("02","com.example.gymnasticsqueen","Android","APP_STORE","1.0.0","","crash","日志内容002","","",
    "1","","","","","","","","2020-06-27 14:35:24","GMT+08:00",1599207685,"192.168.0.26","CN","beijing");
insert into table crash_t values("03","com.example.gymnasticsqueen","Android","APP_STORE","1.0.0","","crash","日志内容003","","",
    "1","","","","","","","","2020-06-27 14:35:24","GMT+08:00",1599207785,"192.168.0.26","CN","beijing");
insert into table crash_t values("02","com.example.gymnasticsqueen","Android","APP_STORE","1.0.0","","crash","日志内容002","","",
    "1","","","","","","","","2020-06-28 14:35:24","GMT+08:00",1599207885,"192.168.0.26","CN","chengdu");
insert into table crash_t values("01","com.example.gymnasticsqueen","Android","APP_STORE","1.0.0","","crash","日志内容003","","",
    "1","","","","","","","","2020-06-28 14:35:24","GMT+08:00",1599209585,"192.168.0.26","CN","chengdu");
insert into table crash_t values("02","com.example.gymnasticsqueen","Android","APP_STORE","1.0.0","","crash","日志内容004","","",
    "1","","","","","","","","2020-06-28 14:35:24","GMT+08:00",1599209585,"192.168.0.26","CN","chengdu");