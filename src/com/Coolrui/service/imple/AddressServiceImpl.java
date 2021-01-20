package com.Coolrui.service.imple;

import com.Coolrui.dao.IAddressDao;
import com.Coolrui.dao.imple.AddressDaoImpl;
import com.Coolrui.pojo.Address;
import com.Coolrui.service.IAddressService;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 15:27
 */
public class AddressServiceImpl implements IAddressService {
    IAddressDao iAddressDao = new AddressDaoImpl();
    @Override
    public List<Address> getAllAddressByUserId(int userid, int isNotDefault) {
        return iAddressDao.queryAllAddress(userid, isNotDefault);
    }

    @Override
    public Address getAddressByUserIdaid(int userid, int aid) {
        return iAddressDao.queryAddress(userid, aid);
    }

    @Override
    public int updateAddress(int id, int userid, String username, String userphone, int proid, int cityid, int areaid, int streetid, String userAddres, String postcode) {
        return iAddressDao.updateAddress(id, userid, username, userphone, proid, cityid, areaid, streetid, userAddres, postcode);
    }

    @Override
    public int deleteAddress(int id, int userid) {
        return iAddressDao.deleteAddress(id, userid);
    }

    @Override
    public int addAddress(int id, String username, String userphone, int proid, int cityid, int areaid, int streetid, String userAddres, String postcode) {
        return iAddressDao.insertAddress(id, username, userphone, proid, cityid, areaid, streetid, userAddres, postcode);
    }

    @Override
    public int changeDefaultAddress(int newAid) {
        return iAddressDao.updateDefaultAddress(newAid);
    }
}
