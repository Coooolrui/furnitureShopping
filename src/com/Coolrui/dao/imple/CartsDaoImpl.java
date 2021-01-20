package com.Coolrui.dao.imple;

import com.Coolrui.Utils.ModifyImgFormat;
import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.ICartsDao;
import com.Coolrui.pojo.Carts;
import com.Coolrui.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 9:44
 */
public class CartsDaoImpl implements ICartsDao {

    @Override
    public int addGoods(Integer userId, Integer goodsId, Integer cartNum) {
        String sql = "INSERT INTO jj_carts(userId, goodsId, cartNum) VALUE (?, ?, ?)";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setInt(1, userId);
            pstat.setInt(2, goodsId);
            pstat.setInt(3, cartNum);
        });
    }

    @Override
    public int queryCartByUserIdGoodId(int userid, int goodsid) {
        String sql = "SELECT id FROM jj_carts WHERE userId = ? AND goodsId = ?";
        Carts carts = new Carts();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
            pstat.setInt(2, goodsid);
        }, rs -> {
            if (rs.next()){
                carts.setId(rs.getInt(1));
            }
        });
        return carts.getId();
    }

    @Override
    public int updateCartByUserIdGoodId(int userid, int goodsid, int goodsNum) {
//        System.out.println("数量是："+goodsNum);
        String sql = "UPDATE jj_carts SET cartNum = cartNum + ? WHERE userId = ? AND goodsId = ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setInt(1, goodsNum);
            pstat.setInt(2, userid);
            pstat.setInt(3, goodsid);
        });
    }

    @Override
    public int queryCartNum(int userid) {
        String sql = "SELECT SUM(cartNum) FROM jj_carts where userid = ?";
        Carts carts = new Carts();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
        }, rs -> {
            if (rs.next()){
                carts.setId(rs.getInt(1));
            }
        });
        return carts.getId();
    }

    @Override
    public List<Carts> queryAllCart(int userid) {
        String sql = "SELECT c.`id`, c.`cartNum`, g.`Id`, g.`name`, g.`imgs`, g.`price`, c.`isCheck` FROM jj_carts c INNER JOIN jj_goods g ON c.`goodsId` = g.`Id` WHERE userid = ?";
        List<Carts> carts = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
        }, rs -> {
            while (rs.next()){
                carts.add(new Carts(rs.getInt(1),
                        rs.getInt(2),
                        new Goods(rs.getInt(3),
                                rs.getString(4),
                                ModifyImgFormat.modify(rs.getString(5)),
                                        rs.getBigDecimal(6)),
                        rs.getInt(7)));
            }
        });
        return carts;
    }

    @Override
    public int deleteCartByCartId(List<Integer> cartids) {
        String sql = "DELETE FROM jj_carts WHERE id IN (";
        for (int i = 0; i < cartids.size(); i++) {
            if (i == 0){
                sql += cartids.get(i);
            }else {
                sql += ", "+cartids.get(i);
            }
        }
        sql += ")";
        return JDBCTemplate.update(sql, null);
    }

    @Override
    public int updateStatusByCartId(Integer cartid) {
        String sql = "UPDATE `jj_carts` SET isCheck = abs(isCheck-1) WHERE id = ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setInt(1, cartid);
        });
    }

    @Override
    public List<Carts> queryAllChecked(Integer userid) {
        String sql = "SELECT c.`id`, c.`cartNum`, g.`Id`, g.`name`, g.`imgs`, g.`price`, c.`isCheck` FROM jj_carts c INNER JOIN jj_goods g ON c.`goodsId` = g.`Id` WHERE userid = ? and isCheck = 1";
        List<Carts> carts = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
        }, rs -> {
            while (rs.next()){
                carts.add(new Carts(rs.getInt(1),
                        rs.getInt(2),
                        new Goods(rs.getInt(3),
                                rs.getString(4),
                                ModifyImgFormat.modify(rs.getString(5)),
                                rs.getBigDecimal(6)),
                        rs.getInt(7)));
            }
        });
        return carts;
    }

    @Override
    public int deleteAllChecked(Integer userid) {
        String sql = "DELETE FROM `jj_carts` WHERE userid = ? AND isCheck = 1";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setInt(1, userid);
        });
    }
}
