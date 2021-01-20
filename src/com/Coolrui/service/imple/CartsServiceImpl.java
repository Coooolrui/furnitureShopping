package com.Coolrui.service.imple;

import com.Coolrui.dao.ICartsDao;
import com.Coolrui.dao.imple.CartsDaoImpl;
import com.Coolrui.pojo.Carts;
import com.Coolrui.service.ICartsService;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 9:41
 */
public class CartsServiceImpl implements ICartsService {
    ICartsDao iCartsDao = new CartsDaoImpl();

    @Override
    public int changeCartsOfGoods(Integer userid, Integer goodsId, Integer goodsNum) {
        int i = iCartsDao.queryCartByUserIdGoodId(userid, goodsId);
        if (i == 0){
            return iCartsDao.addGoods(userid, goodsId, goodsNum);
        }else {
            return iCartsDao.updateCartByUserIdGoodId(userid, goodsId, goodsNum);
        }
    }

    @Override
    public int showCartsNum(int userid) {
        return iCartsDao.queryCartNum(userid);
    }

    @Override
    public List<Carts> queryAllCartsByuserId(int userid) {
        return iCartsDao.queryAllCart(userid);
    }

    @Override
    public int deleteCartByCartIds(List<Integer> cartids) {
        return iCartsDao.deleteCartByCartId(cartids);
    }

    @Override
    public int updateCartStatusByCarti(Integer cartid) {
        return iCartsDao.updateStatusByCartId(cartid);
    }

    @Override
    public List<Carts> getAllChecked(Integer userid) {
        return iCartsDao.queryAllChecked(userid);
    }

    @Override
    public int deleteAllChecked(Integer userid) {
        System.out.println("现在正在删除");
        return iCartsDao.deleteAllChecked(userid);
    }
}
