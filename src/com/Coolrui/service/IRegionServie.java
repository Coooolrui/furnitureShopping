package com.Coolrui.service;

import com.Coolrui.pojo.Region;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/11 14:15
 */
public interface IRegionServie {
    /**
     * 通过地区码的得到 所属的地区集合
     * @param code
     * @return
     */
    List<Region> getRegionByCode(String code);
}
