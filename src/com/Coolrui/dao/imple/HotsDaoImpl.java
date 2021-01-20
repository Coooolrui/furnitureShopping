package com.Coolrui.dao.imple;

import com.Coolrui.Utils.ModifyImgFormat;
import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.IHotsDao;
import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/8 11:30
 */
public class HotsDaoImpl implements IHotsDao {
    @Override
    public List<Goods> queryAllHots() {
        String sql = "SELECT hots.`img`, hots.`goodsId` FROM `jj_goods` goods RIGHT JOIN `jj_hots` hots ON goods.`Id` = hots.`goodsId` WHERE goods.`stock` != 0";
        ArrayList<Goods> goods = new ArrayList<>();
        JDBCTemplate.query(sql, null, rs -> {
            while (rs.next()){
                goods.add(new Goods(rs.getInt(2), new String[]{rs.getString(1)}));
            }
        });
        return goods;
    }

    @Override
    public List<Goods> queryAll() {
        String sql = "SELECT class.`id`, class.`className`, hots.`img` FROM `jj_hots` hots INNER JOIN jj_class class ON hots.`classid` = class.`id`";
        List<Goods> goods = new ArrayList<>();
        JDBCTemplate.query(sql, null, rs -> {
            while (rs.next()) {
                Goods goods1 = new Goods();
                Class aClass = new Class(rs.getInt(1), rs.getString(2));
                goods1.setaClass(aClass);
                goods1.setImgs(new String[]{rs.getString(3)});
                goods.add(goods1);
            }
        });
        return goods;
    }
}
