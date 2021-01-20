package com.Coolrui.dao.imple;

import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.IPaymentsDao;
import com.Coolrui.pojo.Payments;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 16:09
 */
public class PaymentsDaoImpl implements IPaymentsDao {
    @Override
    public List<Payments> queryAllPayments() {
        String sql = "SELECT * FROM `jj_payments`";
        List<Payments> payments = new ArrayList<>();
        JDBCTemplate.query(sql, null, rs -> {
            while (rs.next()) {
                payments.add(new Payments(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        });
        return payments;
    }
}
