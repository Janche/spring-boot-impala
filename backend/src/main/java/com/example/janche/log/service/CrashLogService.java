package com.example.janche.log.service;

import com.example.janche.common.core.Service;
import com.example.janche.log.domain.CrashLog;
import com.example.janche.log.dto.QueryDTO;
import com.github.pagehelper.PageInfo;
import com.example.janche.common.restResult.PageParam;

import java.util.List;

/**
* @author Generate
* @Description: // TODO 为类添加注释
* @date 2020-08-28 05:25:26
*/
public interface CrashLogService extends Service<CrashLog> {

    /**
     * 根据分页、排序信息和检索条件查询 @size 条 日志数据
     * @param pageParam 分页参数
     * @param queryDTO  查询关键字
     * @return
     */
    List<CrashLog> list(PageParam pageParam, QueryDTO queryDTO);

    /**
     * 刷新元数据 INVALIDATE METADATA TABLE
     * 每天 1点执行一次
     */
    void scheduleRefreshMetadata();

    /**
     * 刷新表的元数据 alter table spring-boot-impala recover partitions
     * 2分钟刷新一次
     */
    void scheduleRefreshPartitions();
}
