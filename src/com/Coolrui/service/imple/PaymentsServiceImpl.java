package com.Coolrui.service.imple;

import com.Coolrui.dao.IPaymentsDao;
import com.Coolrui.dao.imple.PaymentsDaoImpl;
import com.Coolrui.pojo.Payments;
import com.Coolrui.service.IPaymentsService;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 16:14
 */
public class PaymentsServiceImpl implements IPaymentsService {
    IPaymentsDao iPaymentsDao = new PaymentsDaoImpl();
    @Override
    public List<Payments> getAllPayments() {
        return iPaymentsDao.queryAllPayments();
    }
}
