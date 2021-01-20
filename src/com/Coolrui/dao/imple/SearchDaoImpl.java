package com.Coolrui.dao.imple;

import com.Coolrui.Utils.ModifyImgFormat;
import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.ISearchDao;
import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/12 21:03
 */
public class SearchDaoImpl implements ISearchDao {
    @Override
    public List<Goods> search(String key) {
        String sql = "SELECT g.`Id`, g.`name`, g.`imgs`, g.`price` FROM jj_class a\n" +
                "INNER JOIN jj_class b ON a.id = b.`parentId`\n" +
                "INNER JOIN jj_goods g ON g.`classId2` = b.`id`\n" +
                "WHERE g.`name` LIKE ? OR a.`className` LIKE ? OR b.`className` LIKE ?";
        ArrayList<Goods> goods = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setString(1, "%"+key+"%");
            pstat.setString(2, "%"+key+"%");
            pstat.setString(3, "%"+key+"%");
        }, rs -> {
            while (rs.next()) {
                while (rs.next()){
                    goods.add(new Goods(rs.getInt(1),
                            rs.getString(2),
                            ModifyImgFormat.modify(rs.getString(3)),
                            rs.getBigDecimal(4)));
                }
            }
        });
        return goods;
    }

    public static void main(String[] args) {
        System.out.println(new SearchDaoImpl().search("客厅"));
    }
}
