package com.Coolrui.dao;

import com.Coolrui.pojo.Goods;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 18:40
 */
public interface IGoodsDao {
    /***
     * 通过指定一级id集合查询商品
     * @param classIds
     * @return
     */
    List<Goods> queryGoodsByIds(List<Integer> classIds);

    /**
     * 通过一级id查询 所属物品
     * @param oneId
     */
    List<Goods> queryOneClassListByOneId(Integer oneId);

    /**
     * 通过二级id查询所属物品
     * @param towId
     * @return
     */
    List<Goods> queryGoodsByTowId2List(Integer towId);

    /**
     * 通过商品id查询商品详细信息
     * @param id
     * @return
     */
    Goods queryGoodsByGoodsId(int id);


    /**
     * 通过商品id查询商品一级分类
     * @param goodsId
     * @return
     */
    List<Integer> queryGoodsByGoodsId(List<Integer> goodsId);
}
