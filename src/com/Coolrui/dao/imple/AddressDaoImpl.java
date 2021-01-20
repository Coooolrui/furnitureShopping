package com.Coolrui.dao.imple;

import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.IAddressDao;
import com.Coolrui.pojo.Address;
import com.Coolrui.pojo.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 14:23
 */
public class AddressDaoImpl implements IAddressDao {
    @Override
    public List<Address> queryAllAddress(int userid, int isNotDefault) {
        String sql = "SELECT a.`Id`, a.`userName`, a.`userPhone`, a.`userAddress`, a.`isDefault`, \n" +
                "b.`ID`, b.`NAME`, c.`ID`, c.`NAME`, d.`ID`, d.`NAME`, e.`ID`, e.`NAME` FROM jj_address a \n" +
                "INNER JOIN cn_region b ON a.`provinceid` = b.`ID` \n" +
                "INNER JOIN cn_region c ON a.`cityid` = c.`ID` \n" +
                "INNER JOIN cn_region d ON a.`areaId` = d.`ID`\n" +
                "INNER JOIN cn_region e ON a.`streetId` = e.`ID`\n" +
                "WHERE a.`userId` = ? and a.`isDefault` != ? and a.status = 1";

        List<Address> addressList = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
            pstat.setInt(2, isNotDefault);
        }, rs -> {
            while (rs.next()) {
                Region pro = new Region();
                pro.setId(rs.getInt(6));
                pro.setName(rs.getString(7));
                Region city = new Region();
                city.setId(rs.getInt(8));
                city.setName(rs.getString(9));
                Region area = new Region();
                area.setId(rs.getInt(10));
                area.setName(rs.getString(11));
                Region street = new Region();
                street.setId(rs.getInt(12));
                street.setName(rs.getString(13));
                addressList.add(new Address(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        pro,
                        city,
                        area,
                        street
                        ));
            }
        });
        return addressList;
    }

    @Override
    public Address queryAddress(int userid, int aid) {
        String sql = "SELECT a.`Id`, a.`userName`, a.`userPhone`, a.`userAddress`, a.`isDefault`, a.`postcode`,\n" +
                "b.`ID`, b.`NAME`, b.`CODE`, c.`ID`, c.`NAME`, c.`CODE`, d.`ID`, d.`NAME`,d.`CODE`, e.`ID`, e.`NAME`,e.`CODE` FROM jj_address a \n" +
                "INNER JOIN cn_region b ON a.`provinceid` = b.`ID` \n" +
                "INNER JOIN cn_region c ON a.`cityid` = c.`ID` \n" +
                "INNER JOIN cn_region d ON a.`areaId` = d.`ID`\n" +
                "INNER JOIN cn_region e ON a.`streetId` = e.`ID`\n" +
                "WHERE a.`userId` = ? AND a.`Id` = ? and a.status = 1";

        Address address = new Address();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
            pstat.setInt(2, aid);
        }, rs -> {
            while (rs.next()) {
                Region pro = new Region();
                pro.setId(rs.getInt(7));
                pro.setName(rs.getString(8));
                pro.setCode(rs.getString(9));

                Region city = new Region();
                city.setId(rs.getInt(10));
                city.setName(rs.getString(11));
                city.setCode(rs.getString(12));

                Region area = new Region();
                area.setId(rs.getInt(13));
                area.setName(rs.getString(14));
                area.setCode(rs.getString(15));

                Region street = new Region();
                street.setId(rs.getInt(16));
                street.setName(rs.getString(17));
                street.setCode(rs.getString(18));

                address.setId(rs.getInt(1));
                address.setUserName(rs.getString(2));
                address.setUserPhone(rs.getString(3));
                address.setUserAddress(rs.getString(4));
                address.setIsDefault(rs.getInt(5));
                address.setPostcode(rs.getString(6));
                address.setProvince(pro);
                address.setCity(city);
                address.setArea(area);
                address.setStreet(street);

            }
        });
        return address;
    }

    @Override
    public int updateAddress(int id, int userid, String username, String userphone, int proid, int cityid, int areaid, int streetid, String userAddres, String postcode) {
        String sql = "UPDATE jj_address SET userName = ?, userPhone = ?, provinceid = ?, cityid = ?, areaId = ?, streetId = ?, userAddress = ?, postcode = ? WHERE id = ? AND userid = ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setString(1, username);
            pstat.setString(2, userphone);
            pstat.setInt(3, proid);
            pstat.setInt(4, cityid);
            pstat.setInt(5, areaid);
            pstat.setInt(6, streetid);
            pstat.setString(7, userAddres);
            pstat.setString(8, postcode);
            pstat.setInt(9, id);
            pstat.setInt(10, userid);
        });
    }

    @Override
    public int deleteAddress(int id, int userid) {
        String sql = "UPDATE jj_address SET STATUS = 0  WHERE id = ? AND userid =  ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setInt(1, id);
            pstat.setInt(2, userid);
        });
    }

    @Override
    public int insertAddress(int id, String username, String userphone, int proid, int cityid, int areaid, int streetid, String userAddres, String postcode) {
        String sql = "INSERT INTO jj_address(userid, userName, userPhone, provinceid, cityid, areaId, streetId, userAddress, postcode, isDefault, createTime)\n" +
                "VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, 0, NOW())";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setInt(1, id);
            pstat.setString(2, username);
            pstat.setString(3, userphone);
            pstat.setInt(4, proid);
            pstat.setInt(5, cityid);
            pstat.setInt(6, areaid);
            pstat.setInt(7, streetid);
            pstat.setString(8, userAddres);
            pstat.setString(9, postcode);
        });
    }

    @Override
    public int updateDefaultAddress(int newAid) {
        String sql = "UPDATE jj_address SET isDefault = 0 WHERE id IN (SELECT id WHERE isDefault = 1)";
        String sql2 = "UPDATE jj_address SET isDefault = 1 WHERE id = ?";
        JDBCTemplate.update(sql, null);
        return JDBCTemplate.update(sql2, pstat -> {
            pstat.setInt(1, newAid);
        });
    }

    public static void main(String[] args) {
        System.out.println(new AddressDaoImpl().queryAllAddress(23, 1));
    }
}
