package com.example.janche.common.core;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;

/**
 * @author lirong
 * @Description mybatis通用Mapper
 * @date 2019-7-24 14:50:45
 */
public interface TkMapper<T> extends
        BaseMapper<T>,
        InsertListMapper<T>,
        ConditionMapper<T>,
        ExampleMapper<T>{
}
