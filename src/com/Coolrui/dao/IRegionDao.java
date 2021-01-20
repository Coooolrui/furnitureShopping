package com.Coolrui.dao;

import com.Coolrui.pojo.Address;
import com.Coolrui.pojo.Region;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/11 14:11
 */
public interface IRegionDao {

    /**
     * 通过父级地区识别码 查找相应区域
     * @param code
     * @return
     */
    List<Region> queryAreaByCode(String code);
}
