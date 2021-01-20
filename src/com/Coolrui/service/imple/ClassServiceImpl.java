package com.Coolrui.service.imple;

import com.Coolrui.dao.IClassDao;
import com.Coolrui.dao.IHotsDao;
import com.Coolrui.dao.imple.ClassDaoImpl;
import com.Coolrui.dao.imple.HotsDaoImpl;
import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;
import com.Coolrui.service.IClassService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 15:31
 */
public class ClassServiceImpl implements IClassService {
    IClassDao iClassDao = new ClassDaoImpl();
    IHotsDao iHotsDao = new HotsDaoImpl();

    @Override
    public Map<String, List<Class>> showClass() {
        List<Class> classList = iClassDao.queryAllClass();
        Map<String, List<Class>> map = classList.stream().collect(Collectors.groupingBy(c -> c.getParentName(), Collectors.toList()));
        return map;
    }

    @Override
    public List<Goods> showMainClass() {
        List<Goods> goodsList = iHotsDao.queryAll();
        return goodsList;
    }

    @Override
    public List<Integer> shuffleClassId(int n) {
        List<Integer> integers = iClassDao.queryAllParentClassId();
        Collections.shuffle(integers);
        if (n > integers.size() - 1){
            return integers.subList(0, integers.size() - 1);
        }
        return integers.subList(0, n);
    }

    @Override
    public Class showOneClassByOneId(Integer oneId) {
        return iClassDao.queryClassById(oneId);
    }

    @Override
    public Class showTowClassByTowId(Integer towId) {
        return iClassDao.queryClassById(towId);
    }

    public static void main(String[] args) {
        ClassServiceImpl classService = new ClassServiceImpl();
        System.out.println(classService.showTowClassByTowId(1));
    }
}
