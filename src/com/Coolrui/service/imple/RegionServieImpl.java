package com.Coolrui.service.imple;

import com.Coolrui.dao.IRegionDao;
import com.Coolrui.dao.imple.RegionDaoImpl;
import com.Coolrui.pojo.Region;
import com.Coolrui.service.IRegionServie;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/11 14:17
 */
public class RegionServieImpl implements IRegionServie {
    IRegionDao iRegionDao = new RegionDaoImpl();
    @Override
    public List<Region> getRegionByCode(String code) {
        return iRegionDao.queryAreaByCode(code);
    }
}
