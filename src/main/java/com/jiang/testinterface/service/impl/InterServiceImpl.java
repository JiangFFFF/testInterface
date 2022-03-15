package com.jiang.testinterface.service.impl;

import com.jiang.testinterface.entity.TestDemo;
import com.jiang.testinterface.mapper.InterMapper;
import com.jiang.testinterface.service.InterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiang
 * @create 2022-03-15-9:34 下午
 */
@Service
public class InterServiceImpl implements InterService {
    @Resource
    private InterMapper interMapper;

    @Override
    public List<TestDemo> selectAll() {
        List<TestDemo> testDemoList = interMapper.queryAll();
        //把查询出来的所有List集合按照要求进行封装
        List<TestDemo> resultList=bulidPermission(testDemoList);
        return resultList;
    }

    @Override
    public Integer getCount() {
        return interMapper.count();

    }

    //把返回所有项目list集合进行封装的方法
    private static List<TestDemo> bulidPermission(List<TestDemo> testDemoList) {
        //创建list集合，用于数据最终封装
        List<TestDemo> finalNode=new ArrayList<>();
        //把所有项目list集合遍历，得到顶层菜单pid=0的菜单，设置level是1
        for(TestDemo item:testDemoList){
            //得到顶层菜单pid=0
            if(item.getPid()==0){
                //设置顶层菜单的level为1
                item.setLevel(1);
                //根据顶层项目，向里面进行查询子项目，封装到finalNode里面
                finalNode.add(selectChildren(item,testDemoList));
            }
        }
        return finalNode;

    }

    /**
     * 一级项目对象
     * @param item
     * @param testDemoList
     * @return
     */
    private static TestDemo selectChildren(TestDemo item, List<TestDemo> testDemoList) {
        //1 因为向一层菜单里面放二层菜单，二层里面还要放三层，把对象初始化
        item.setChildren(new ArrayList<TestDemo>());
        //2、遍历所有项目list集合，进行判断比较，比较id和pid是否相同
        for(TestDemo tt:testDemoList){
            //判断父节点的id是否和子节点的pid相同,如果相同则进行封装
            if(item.getId().equals(tt.getPid())){
                //把父菜单的level值加1赋值给下一级菜单的level值
                tt.setLevel(item.getLevel()+1);
                //如果children为空，进行初始化操作
                if(item.getChildren()==null){
                    item.setChildren(new ArrayList<TestDemo>());
                }
                item.getChildren().add(selectChildren(tt,testDemoList));
            }
        }
        return item;
    }
}
