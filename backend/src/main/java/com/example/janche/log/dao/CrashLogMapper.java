package com.example.janche.log.dao;

import com.example.janche.common.core.Mapper;
import com.example.janche.log.domain.CrashLog;

public interface CrashLogMapper extends Mapper<CrashLog> {

    void scheduleRefreshMetadata();

    void scheduleRefreshPartitions();
}