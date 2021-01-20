package com.Coolrui.service;

import com.Coolrui.pojo.Goods;

import java.util.List;
import java.util.Map;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 18:42
 */
public interface IGoodsService {
    /**
     * 通过若干个一级id 随机选择若干个对应的 产品
     * @param goodsNum 要获得的商品数
     * @return
     */
    Map<String, List<Goods>> getShuffleGoods(List<Integer> ids, int goodsNum);

    /**
     * 通过若干个一级id 返回一组随机的商品啊
     * @param goodsNum 要获得的商品数
     * @return
     */
    List<Goods> getShuffleGoods2List(List<Integer> ids, int goodsNum);

    /**
     * 通过一级id随机查询若干个同类型的商品
     * @param oneId
     * @param goodsNum 商品数
     * @return 返回List集合
     */
    List<Goods> getShuffleGoods(Integer oneId, int goodsNum);

    /**
     * 通过二级id随机查询若干个同类型的商品
     * @param towId
     * @param goodsNum
     * @return
     */
    List<Goods> getShuffleGoods2(int towId, int goodsNum);

    /**
     * 通过一级id查询商品，并以商品列别名分组
     * @param oneId
     * @return
     */
    Map<String, List<Goods>> getGoodsByClassOneId2Map(Integer oneId);

    /**
     * 通过二级分类名查询商品
     * @param towId
     * @return
     */
    List<Goods> getGoodsByClassTowId2List(Integer towId);

    /**
     * 按新品上市时间排序
     * @param goodsList
     * @return
     */
    List<Goods> sortGoodsByDateDesc2List(List<Goods> goodsList);

    /**
     * 根据销量进行排序
     * @param goodsList
     * @param order 1 asc 0 desc
     * @return
     */
    List<Goods> sortGoodsBySales2List(List<Goods> goodsList, int order);

    /**
     * 根据价格进行排序
     * @param goodsList
     * @param order 1 asc 0 desc
     * @return
     */
    List<Goods> sortGoodsByPrice2List(List<Goods> goodsList, int order);

    /**
     * 通过商品id获得商品信息
     * @param id
     * @return
     */
    Goods getGoodsByGid(int id);

    /**
     * 通过商品id集合的得到商品的一级分类
     * @param goodsId
     * @return
     */
    List<Integer> getGoodsOneIdByGoodsId(List<Integer> goodsId);
}
