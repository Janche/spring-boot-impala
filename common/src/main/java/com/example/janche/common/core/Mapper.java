package com.example.janche.common.core;

import tk.mybatis.mapper.additional.aggregation.AggregationMapper;
import tk.mybatis.mapper.common.*;

/**
 * @author lirong
 * @Description mybatis通用Mapper
 * @date 2019-7-24 14:50:45
 */
public interface Mapper<T> extends
        BaseMapper<T>,
        MySqlMapper<T>,
        AggregationMapper<T>,
        ConditionMapper<T>,
        ExampleMapper<T>{
}
