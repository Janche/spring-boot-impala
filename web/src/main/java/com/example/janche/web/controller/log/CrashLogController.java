package com.example.janche.web.controller.log;

import com.example.janche.common.exception.CustomException;
import com.example.janche.common.restResult.PageParam;
import com.example.janche.common.restResult.RestResult;
import com.example.janche.common.restResult.ResultCode;
import com.example.janche.common.restResult.ResultGenerator;
import com.example.janche.log.domain.CrashLog;
import com.example.janche.log.dto.QueryDTO;
import com.example.janche.log.service.CrashLogService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
*
* @author lirong
* @Description:
* @date 2020-9-21 17:33:28
*/
@Slf4j
@RestController
@RequestMapping("/log")
@Api(tags = "崩溃日志模块管理")
public class CrashLogController {
    @Resource
    private CrashLogService crashLogService;

    @PostMapping
    @ApiOperation(value = "新增崩溃日志", notes = "单个新增", produces = "application/json")
    public RestResult add(@ApiParam(name = "崩溃日志信息", required = true) @RequestBody CrashLog crashLog) {
        crashLogService.save(crashLog);
        return ResultGenerator.genSuccessResult().setMessage("保存成功");
    }

    /**
     * 用于分页查询,默认可以不用传分页信息
     * 默认值：page=1,size=10,sortField="id",sortOrder="ASC"
     */
    @GetMapping(value = "/list")
    @ApiOperation(value = "崩溃日志列表分页查询", notes = "分页列表", produces = "application/json")
    public RestResult list(@ApiParam(value = "分页信息") PageParam pageParam,
                           @ApiParam(value = "查询条件") QueryDTO queryDTO) {
        try {
            List<CrashLog> list = crashLogService.list(pageParam, queryDTO);
            PageInfo pageInfo = new PageInfo(list);
            return ResultGenerator.genSuccessResult(pageInfo);
            // todo impala服务重启后，第一次查询，可能会抛出连接失败的异常，需要再查询一次，即可解决问题，生产环境中impala基本不会怎么重启，所以问题不大。
        }catch (CannotCreateTransactionException e){
            throw new CustomException(ResultCode.CONNECTION_FAILED);
        }catch (Exception e){
            throw new CustomException(ResultCode.FAIL);
        }
    }

    /**
     * 刷新元数据 INVALIDATE METADATA TABLE
     * 每天 1点执行一次
     */
//    @Scheduled(cron = "0 0 1 * * ?")
    public void scheduleRefreshMetadata() {
        crashLogService.scheduleRefreshMetadata();
    }

    /**
     * 刷新表的元数据 alter table spring-boot-impala recover partitions
     * 2分钟刷新一次
     */
//    @Scheduled(cron = "0 0/2 * * * ?")
    public void scheduleRefreshPartitions() {
        crashLogService.scheduleRefreshPartitions();
    }

}
