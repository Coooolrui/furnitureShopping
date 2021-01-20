package com.Coolrui.service.imple;

import com.Coolrui.dao.IHotsDao;
import com.Coolrui.dao.imple.HotsDaoImpl;
import com.Coolrui.pojo.Goods;
import com.Coolrui.service.IHotsService;

import java.util.Collections;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/8 11:38
 */
public class HotsServiceImpl implements IHotsService {
    IHotsDao iHotsDao = new HotsDaoImpl();
    @Override
    public List<Goods> showHotsByNum(int num) {
        List<Goods> goodsList = iHotsDao.queryAllHots();
        Collections.shuffle(goodsList);
        return goodsList.subList(0, num);
    }
}
