package com.example.janche.common.model;

/**
 * 常量
 */
public interface Constant {

    /**
     * 时间格式化
     */
    String DATE_FORMATTER_TIME = "YYYY-MM-dd HH:mm:ss";
    String DATE_FORMATTER_DATE = "YYYY-MM-dd";

    /**
     * 公共状态： 启用、未启用
     */
    int STATUS_ENABLE = 1;
    int STATUS_DISABLE = 0;

    /**
     * 选择: 全选、半选、不选
     */
    int ALL_SELECT = 2;
    int HALF_SELECT = 1;
    int NO_SELECT = 0;

}
