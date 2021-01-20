package com.Coolrui.service.imple;

import com.Coolrui.dao.ISearchDao;
import com.Coolrui.dao.imple.SearchDaoImpl;
import com.Coolrui.pojo.Goods;
import com.Coolrui.service.ISearchService;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/12 21:09
 */
public class SearchServiceImpl implements ISearchService {
    ISearchDao iSearchDao = new SearchDaoImpl();
    @Override
    public List<Goods> search(String key) {
        return iSearchDao.search(key);
    }
}
