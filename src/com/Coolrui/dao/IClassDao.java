package com.Coolrui.dao;

import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 15:32
 */
public interface IClassDao {
    /**
     * 查询所有的分类
     * @return
     */
    List<Class> queryAllClass();

    /**
     * 查询所有的一级分类Id
     * @return
     */
    List<Integer> queryAllParentClassId();

    /**
     * 通过一级id查看级别的名称
     * @param id
     * @return
     */
    Class queryClassById(Integer id);
}
