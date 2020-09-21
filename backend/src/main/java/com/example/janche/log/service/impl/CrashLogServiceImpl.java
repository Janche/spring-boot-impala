package com.example.janche.log.service.impl;

import com.example.janche.common.core.AbstractService;
import com.example.janche.common.restResult.PageParam;
import com.example.janche.log.dao.CrashLogMapper;
import com.example.janche.log.domain.CrashLog;
import com.example.janche.log.dto.QueryDTO;
import com.example.janche.log.service.CrashLogService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Generate
* @Description: // TODO 为类添加注释
* @date 2020-08-28 05:25:26
*/
@Slf4j
@Service
@Transactional
public class CrashLogServiceImpl extends AbstractService<CrashLog> implements CrashLogService {
    @Resource
    private CrashLogMapper crashLogMapper;

    /**
     * 根据分页、排序信息和检索条件查询 @size 条 字典表数据
     * @param pageParam 分页参数
     * @param queryDTO  查询关键字
     * @return
     */
    @Override
    public List<CrashLog> list(PageParam pageParam, QueryDTO queryDTO) {
        Integer size = pageParam.getSize();
        Integer page = pageParam.getPage();
        pageParam.setPage(( page - 1 ) * size);
        PageHelper.startPage(page, size);
        PageHelper.orderBy("`timestamp` desc ");
        Example example = new Example(CrashLog.class);
        if (null != queryDTO){
            if (StringUtils.isNotEmpty(queryDTO.getAppid())){
                example.and().andEqualTo("appid", queryDTO.getAppid());
            }
        }
        List<CrashLog> crashLogs = crashLogMapper.selectByExample(example);
        return crashLogs;
    }

    /**
     * 刷新元数据 INVALIDATE METADATA TABLE
     * 每天 1点执行一次
     */
    @Override
    public void scheduleRefreshMetadata() {
        crashLogMapper.scheduleRefreshMetadata();
    }

    /**
     * 刷新表的元数据 alter table spring-boot-impala recover partitions
     * 2分钟刷新一次
     */
    @Override
    public void scheduleRefreshPartitions() {
        crashLogMapper.scheduleRefreshPartitions();
    }
}
