package com.jiang.testinterface.controller;

import com.jiang.testinterface.common.R;
import com.jiang.testinterface.entity.TestDemo;
import com.jiang.testinterface.service.InterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiang
 * @create 2022-03-15-9:32 下午
 */
@RestController
@RequestMapping("/inter/select")
public class InterController {

    @Resource
    private InterService interService;

    @GetMapping("/getAllItem")
    public R getAllItem(){
        List<TestDemo> list=interService.selectAll();
        return R.ok().data("list",list);
    }

    @GetMapping("/getCount")
    public Integer count(){
        Integer count=interService.getCount();
        return  count;
    }
}
