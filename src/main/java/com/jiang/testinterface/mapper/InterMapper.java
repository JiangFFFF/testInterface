package com.jiang.testinterface.mapper;

import com.jiang.testinterface.entity.TestDemo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author jiang
 * @create 2022-03-15-9:35 下午
 */
//@Mapper
public interface InterMapper {

    //查询所有菜单并按id进行排序
    public List<TestDemo> queryAll();

    Integer count();
}
