package com.Coolrui.service;

import com.Coolrui.pojo.Transports;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 16:32
 */
public interface ITransportSrevice {
    /**
     * 得到所有的运输方式
     * @return
     */
    List<Transports> getAllTransports();
}
