package com.Coolrui.dao;

import com.Coolrui.pojo.Transports;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 16:29
 */
public interface ITransportsDao {
    /**
     * 查询所有的运输方式
     * @return
     */
    List<Transports> queryAll();
}
