package com.Coolrui.dao;

import com.Coolrui.pojo.Address;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 14:22
 */
public interface IAddressDao {

    /**
     * 通过用户id 查询所有的收货地址
     * @param userid
     * @param isNotDefault 0 表示默认 1 表示 普通
     * @return
     */
    List<Address> queryAllAddress(int userid, int isNotDefault);

    /**
     * 通过用户id和地址id查询对应地址
     * @param userid
     * @param aid
     * @return
     */
    Address queryAddress(int userid, int aid);

    /**
     * 通过地址id 和userid 更新地址信息
     * @param id
     * @param userid
     * @param username
     * @param userphone
     * @param proid
     * @param cityid
     * @param areaid
     * @param streetid
     * @param userAddres
     * @param postcode
     * @return
     */
    int updateAddress(int id, int userid, String username, String userphone, int proid, int cityid, int areaid, int streetid, String userAddres, String postcode);

    /**
     * 通过地址id和用户id删除地址
     * @param id
     * @param userid
     * @return
     */
    int deleteAddress(int id, int userid);

    /**
     * 添加地址
     * @param id
     * @param username
     * @param userphone
     * @param proid
     * @param cityid
     * @param areaid
     * @param streetid
     * @param userAddres
     * @param postcode
     * @return
     */
    int insertAddress(int id, String username, String userphone, int proid, int cityid, int areaid, int streetid, String userAddres, String postcode);

    /**
     * 通过新的默认地址id 更新默认地址
     * @param newAid
     * @return
     */
    int updateDefaultAddress(int newAid);
}
