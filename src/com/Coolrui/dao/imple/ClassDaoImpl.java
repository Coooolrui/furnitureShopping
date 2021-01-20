package com.Coolrui.dao.imple;

import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.IClassDao;
import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 15:32
 */
public class ClassDaoImpl implements IClassDao {
    @Override
    public List<Class> queryAllClass() {
        String sql = "SELECT  b.`id`, a.`id` parentId, b.`className`, a.`className` parentName FROM `jj_class` a INNER JOIN `jj_class` b ON a.`id` = b.`parentId`";
        List<Class> classList = new ArrayList<>();
        JDBCTemplate.query(sql, null, rs -> {
            while (rs.next()){
                classList.add(new Class(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        });
        return classList;
    }

    @Override
    public List<Integer> queryAllParentClassId() {
        String sql = "SELECT id FROM jj_class WHERE parentId IS NULL";
        ArrayList<Integer> classId = new ArrayList<>();
        JDBCTemplate.query(sql, null, rs -> {
            while (rs.next()){
                classId.add(rs.getInt(1));
            }
        });
        return classId;
    }

    @Override
    public Class queryClassById(Integer oneId) {
        String sql = "select id, className from jj_class where id = ?";
        Class aClass = new Class();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, oneId);
        }, rs -> {
            if (rs.next()){
                aClass.setId(rs.getInt(1));
                aClass.setClassName(rs.getString(2));
            }
        });
        return aClass;
    }

    public static void main(String[] args) {
//        System.out.println(new ClassDaoImpl().queryGoodsById(Arrays.asList(1, 2, 3)).get(0));
    }
}
