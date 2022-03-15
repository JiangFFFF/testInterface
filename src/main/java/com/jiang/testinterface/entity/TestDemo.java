package com.jiang.testinterface.entity;

import lombok.Data;

import java.util.List;

/**
 * @author jiang
 * @create 2022-03-15-9:16 下午
 */
@Data
public class TestDemo {

    private Integer id;
    private String name;
    private Integer pid;
    private String icon;
    private Integer level;
    private List<TestDemo> children;
//    private Boolean isDeleted;

}
