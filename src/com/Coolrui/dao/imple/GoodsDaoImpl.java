package com.Coolrui.dao.imple;

import com.Coolrui.Utils.ModifyImgFormat;
import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.IGoodsDao;
import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;
import sun.management.jdp.JdpGenericPacket;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 18:40
 */
public class GoodsDaoImpl implements IGoodsDao {

    @Override
    public List<Goods> queryGoodsByIds(List<Integer> classIds) {
        String sql = "SELECT goods.Id, goods.`name`, goods.`imgs`, goods.`price`, class.`id`, class.`className` FROM `jj_goods` goods INNER JOIN `jj_class` class ON goods.`classId1` = class.`id` WHERE class.`Id` IN (";
        for (int i = 0; i < classIds.size(); i++) {
            if (i == 0){
                sql += classIds.get(i);
            }else {
                sql += ","+classIds.get(i);
            }
        }
        sql += ")";
//        System.out.println(sql);
        List<Goods> goodsList = new ArrayList<>();
        JDBCTemplate.query(sql, null, rs -> {
            while (rs.next()){
                goodsList.add(new Goods(rs.getInt(1),
                        rs.getString(2),
                        ModifyImgFormat.modify(rs.getString(3)),
                        rs.getBigDecimal(4),
                        new Class(rs.getInt(5), rs.getString(6))));
            }
        });
        return goodsList;
    }

    @Override
    public List<Goods> queryOneClassListByOneId(Integer oneId) {
        String sql = "SELECT g.`Id`, g.`name`, g.`imgs`, g.`price`, c.`id`, c.`className` FROM jj_goods g INNER JOIN jj_class c ON g.`classId2` = c.`id` WHERE g.`classId1` = ?";
        List<Goods> goodsList = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, oneId);
        }, rs -> {
            while (rs.next()) {
                goodsList.add(new Goods(rs.getInt(1),
                        rs.getString(2),
                        ModifyImgFormat.modify(rs.getString(3)),
                        rs.getBigDecimal(4),
                        new Class(rs.getInt(5), rs.getString(6))));
            }
        });
        return goodsList;
    }

    @Override
    public List<Goods> queryGoodsByTowId2List(Integer towId) {
        String sql = "SELECT goods.`Id`, goods.`name`, goods.`imgs`, goods.`price`, goods.`createTime`, goods.`stock`, class.`className` FROM jj_goods goods INNER JOIN jj_class class ON goods.`classId2` = class.`id` WHERE goods.`classId2` = ?";
        List<Goods> goods = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, towId);
        }, rs -> {
            while (rs.next()) {
                goods.add(new Goods(rs.getInt(1),
                        rs.getString(2),
                        ModifyImgFormat.modify(rs.getString(3)),
                        rs.getBigDecimal(4),
                        rs.getInt(6),
                        rs.getDate(5),
                        new Class(rs.getString(7))));
            }
        });
        return goods;
    }

    @Override
    public Goods queryGoodsByGoodsId(int id) {
        String sql = "SELECT * FROM jj_goods g WHERE g.Id = ?";
        Goods goods = new Goods();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, id);
        }, rs ->{
            if (rs.next()) {
                goods.setId(rs.getInt(1));
                goods.setName(rs.getString(2));
                goods.setImgs(ModifyImgFormat.modify(rs.getString(3)));
                goods.setPrice(rs.getBigDecimal(4));
                goods.setGdesc(rs.getString(5));
                goods.setStock(rs.getInt(6));
                goods.setAppraiseNum(rs.getInt(7));
                goods.setInfo(ModifyImgFormat.modify(rs.getString(8)));
                goods.setCreateTime(rs.getDate(9));
                goods.setClassId1(rs.getInt(10));
                goods.setClassId2(rs.getInt(11));
            }
        });
        return goods;
    }

    @Override
    public List<Integer> queryGoodsByGoodsId(List<Integer> goodsId) {
        String sql = "SELECT distinct classId1 FROM jj_goods WHERE id IN (";
        List<Integer> idOneList = new ArrayList<>();
        for (int i = 0; i < goodsId.size(); i++) {
            if (i == 0){
                sql += goodsId.get(i);
            }else {
                sql += ","+goodsId.get(i);
            }
        }
        sql += ")";

        JDBCTemplate.query(sql, null, rs -> {
            while (rs.next()) {
                idOneList.add(rs.getInt(1));
            }
        });
        return idOneList;
    }

    public static void main(String[] args) {
//        List<Goods> goodsList = new GoodsDaoImpl().queryGoodsByIds(Arrays.asList(1));
//        System.out.println(Arrays.toString(goodsList.get(1).getImgs()));
//        System.out.println(new GoodsDaoImpl().queryGoodsByTowId2List(104));
        System.out.println(new GoodsDaoImpl().queryGoodsByGoodsId(Arrays.asList(1, 2, 5)));
    }
}
