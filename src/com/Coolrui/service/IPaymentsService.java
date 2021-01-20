package com.Coolrui.service;

import com.Coolrui.pojo.Payments;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 16:13
 */
public interface IPaymentsService {

    /**
     * 得到所有的支付方式
     * @return
     */
    List<Payments> getAllPayments();
}
