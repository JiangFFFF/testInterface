package com.jiang.testinterface.service;

import com.jiang.testinterface.entity.TestDemo;

import java.util.List;

/**
 * @author jiang
 * @create 2022-03-15-9:33 下午
 */
public interface InterService {

    List<TestDemo> selectAll();

    Integer getCount();
}
