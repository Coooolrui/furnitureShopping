package com.Coolrui.dao;

import com.Coolrui.pojo.Payments;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 16:09
 */
public interface IPaymentsDao {

    /**
     * 查询所有的支付方式
     * @return
     */
    List<Payments> queryAllPayments();
}
