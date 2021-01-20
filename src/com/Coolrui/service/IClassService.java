package com.Coolrui.service;

import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;

import java.util.List;
import java.util.Map;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 15:30
 */

public interface IClassService {
    /**
     * 展示所有分类
     * @return
     */
    Map<String, List<Class>> showClass();

    /**
     * 展示主分类
     * @return
     */
    List<Goods> showMainClass();

    /**
     * 随机选择 n 个 一级分类id 若不足则返回全部
     * @param n
     * @return
     */
    List<Integer> shuffleClassId(int n);

    /**
     * 展示导航栏一级分类的名字
     * @param oneId
     * @return
     */
    Class showOneClassByOneId(Integer oneId);

    /**
     * 展示导航栏二级分类
     * @param towId
     * @return
     */
    Class showTowClassByTowId(Integer towId);
}
