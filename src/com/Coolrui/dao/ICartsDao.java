package com.Coolrui.dao;

import com.Coolrui.pojo.Carts;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 9:44
 */
public interface ICartsDao {

    /**
     * 向购物车中添加商品
     * @param userId
     * @param goodsId
     * @param cartNum
     * @return
     */
    int addGoods(Integer userId, Integer goodsId, Integer cartNum);

    /**
     * 通过用户id和商品id 查看购物车中是否有该商品出现
     * @param userid
     * @param goodsid
     * @return 返回0 表示没有
     */
    int queryCartByUserIdGoodId(int userid, int goodsid);

    /**
     * 通过用户id和商品id 更新购物车中商品的数量
     * @param userid
     * @param goodsid
     * @param goodsNum
     * @return
     */
    int updateCartByUserIdGoodId(int userid, int goodsid, int goodsNum);

    /**
     * 查询你购物车中商品的数量
     * @return
     */
    int queryCartNum(int userid);

    /**
     * 查询所有的商品
     * @param userid
     * @return
     */
    List<Carts> queryAllCart(int userid);

    /**
     * 删除指定id的商品
     * @param cartids
     * @return
     */
    int deleteCartByCartId(List<Integer> cartids);

    /**
     * 通过cartid 更新商品的状态
     * @param cartid
     * @return
     */
    int updateStatusByCartId(Integer cartid);

    /**
     * 通过userid 查询所有选中的商品
     * @return
     */
    List<Carts> queryAllChecked(Integer userid);

    /**
     * 通过userid 删除所有选中的商品
     * @return
     */
    int deleteAllChecked(Integer userid);
}
