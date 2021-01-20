package com.Coolrui.dao.imple;

import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.IRegionDao;
import com.Coolrui.pojo.Address;
import com.Coolrui.pojo.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/11 14:11
 */
public class RegionDaoImpl implements IRegionDao {

    @Override
    public List<Region> queryAreaByCode(String code) {
        String sql = "SELECT cn.`CODE`, cn.`NAME`, cn.`ID` FROM cn_region cn WHERE SUPERIOR_CODE = ?";
        List<Region> regionList = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setString(1, code);
        }, rs -> {
            while (rs.next()) {
                regionList.add(new Region(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        });
        return regionList;
    }
}
