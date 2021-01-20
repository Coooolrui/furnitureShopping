package com.Coolrui.dao.imple;

import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.ITransportsDao;
import com.Coolrui.pojo.Transports;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 16:30
 */
public class TransportsDaoImpl implements ITransportsDao {
    @Override
    public List<Transports> queryAll() {
        String sql = "SELECT * FROM `jj_transports`";
        List<Transports> transports = new ArrayList<>();
        JDBCTemplate.query(sql, null, rs -> {
            while (rs.next()) {
                transports.add(new Transports(rs.getInt(1),
                        rs.getString(2)));
            }
        });
        return transports;
    }
}
