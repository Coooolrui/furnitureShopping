package com.Coolrui.service;

import com.Coolrui.pojo.Carts;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 9:41
 */
public interface ICartsService {
    /**
     * 如果购物车中没有该商品 则添加该商品 如果有则改变他的数量 包裹增加和减少
     * @param userid
     * @param goodsId
     * @param goodsNum
     * @return
     */
    int changeCartsOfGoods(Integer userid, Integer goodsId, Integer goodsNum);

    /**
     * 查询购物车中商品的数量
     * @return
     */
    int showCartsNum(int userid);

    /**
     * 通过userid 查询所有的商品
     * @param userid
     * @return
     */
    List<Carts> queryAllCartsByuserId(int userid);

    /**
     * 通过id删除购物车中的商品
     * @param cartids
     * @return
     */
    int deleteCartByCartIds(List<Integer> cartids);

    /**
     * 通过cartid 更新商品的状态
     * @param cartid
     * @return
     */
    int updateCartStatusByCarti(Integer cartid);


    /**
     * 通过userid 查询所有选中的商品
     * @return
     */
    List<Carts> getAllChecked(Integer userid);

    /**
     * 通过userid 删除所有选中的商品
     * @return
     */
    int deleteAllChecked(Integer userid);
}
