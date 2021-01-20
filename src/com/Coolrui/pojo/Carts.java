package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 16:40
 */

/**
 * 购物车类
 */
public class Carts {
    private int id;
    private int userId;
    //是否选中
    private int isCheck;
    private int goodsId;
    //商品数量
    private int cartNum;

    private Goods goods;

    public Carts() {
    }

    public Carts(int id, int cartNum, Goods goods, int isCheck) {
        this.id = id;
        this.cartNum = cartNum;
        this.goods = goods;
        this.isCheck = isCheck;
    }

    public Carts(int id, int userId, int isCheck, int goodsId, int cartNum) {
        this.id = id;
        this.userId = userId;
        this.isCheck = isCheck;
        this.goodsId = goodsId;
        this.cartNum = cartNum;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCartNum() {
        return cartNum;
    }

    public void setCartNum(int cartNum) {
        this.cartNum = cartNum;
    }
}
