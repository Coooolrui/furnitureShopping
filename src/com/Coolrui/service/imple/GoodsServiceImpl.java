package com.Coolrui.service.imple;

import com.Coolrui.dao.IGoodsDao;
import com.Coolrui.dao.imple.GoodsDaoImpl;
import com.Coolrui.pojo.Goods;
import com.Coolrui.service.IGoodsService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 18:42
 */
public class GoodsServiceImpl implements IGoodsService {
    IGoodsDao iGoodsDao = new GoodsDaoImpl();

    @Override
    public Map<String, List<Goods>> getShuffleGoods(List<Integer> ids, int goodsNum) {
        List<Goods> goodsList = iGoodsDao.queryGoodsByIds(ids);
        Map<String, List<Goods>> collect = goodsList.stream()
                .collect(Collectors.groupingBy(goods -> goods.getaClass().getClassName(), Collectors.toList()));
        collect.forEach((key, value)->{
            Collections.shuffle(value);
            collect.replace(key, value.subList(0, goodsNum));
        });
        return collect;
    }

    @Override
    public List<Goods> getShuffleGoods2List(List<Integer> ids, int goodsNum) {
        List<Goods> goodsList = iGoodsDao.queryGoodsByIds(ids);
        Collections.shuffle(goodsList);
        return goodsList.subList(0, goodsNum);
    }

    @Override
    public List<Goods> getShuffleGoods(Integer oneId, int goodsNum) {
        List<Goods> goodsList = iGoodsDao.queryGoodsByIds(Arrays.asList(oneId));
        Collections.shuffle(goodsList);
        if (goodsList.size() < goodsNum){
            return goodsList.subList(0, goodsList.size());
        }
        return goodsList.subList(0, goodsNum);
    }

    @Override
    public List<Goods> getShuffleGoods2(int towId, int goodsNum) {
        List<Goods> goodsList = iGoodsDao.queryGoodsByTowId2List(towId);
        Collections.shuffle(goodsList);
        if (goodsList.size() < goodsNum){
            return goodsList.subList(0, goodsList.size());
        }
        return goodsList.subList(0, goodsNum);
    }

    @Override
    public Map<String, List<Goods>> getGoodsByClassOneId2Map(Integer oneId) {
        List<Goods> goodsList = iGoodsDao.queryOneClassListByOneId(oneId);
        return goodsList.stream().collect(Collectors.groupingBy(goods -> goods.getaClass().getClassName(), Collectors.toList()));
    }

    @Override
    public List<Goods> getGoodsByClassTowId2List(Integer towId) {
        List<Goods> goodsList = iGoodsDao.queryGoodsByTowId2List(towId);
        return goodsList;
    }

    @Override
    public List<Goods> sortGoodsByDateDesc2List(List<Goods> goodsList) {
        List<Goods> collect = goodsList.stream().sorted(Comparator.comparing(Goods::getCreateTime).reversed()).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Goods> sortGoodsBySales2List(List<Goods> goodsList, int order) {
        if (order == 1){
            return goodsList.stream().sorted(Comparator.comparing(Goods::getStock))
                    .collect(Collectors.toList());
        }else {
            return goodsList.stream().sorted(Comparator.comparing(Goods::getStock).reversed())
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Goods> sortGoodsByPrice2List(List<Goods> goodsList, int order) {
        if (order == 1){
            return goodsList.stream().sorted(Comparator.comparing(Goods::getPrice))
                    .collect(Collectors.toList());
        }else {
            return goodsList.stream().sorted(Comparator.comparing(Goods::getPrice).reversed())
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Goods getGoodsByGid(int id) {
        return iGoodsDao.queryGoodsByGoodsId(id);
    }

    @Override
    public List<Integer> getGoodsOneIdByGoodsId(List<Integer> goodsId) {
        return iGoodsDao.queryGoodsByGoodsId(goodsId);
    }


    public static void main(String[] args) {
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        List<Goods> goodsByClassTowId2List = goodsService.getGoodsByClassTowId2List(104);
        for (Goods goods : goodsByClassTowId2List) {
            System.out.println(goods);
        }
        System.out.println("====================================");
        List<Goods> goodsList = goodsService.sortGoodsBySales2List(goodsByClassTowId2List, 1);
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }
}
