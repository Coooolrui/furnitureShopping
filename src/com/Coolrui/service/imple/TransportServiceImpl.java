package com.Coolrui.service.imple;

import com.Coolrui.dao.ITransportsDao;
import com.Coolrui.dao.imple.TransportsDaoImpl;
import com.Coolrui.pojo.Transports;
import com.Coolrui.service.ITransportSrevice;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 16:33
 */
public class TransportServiceImpl implements ITransportSrevice {
    ITransportsDao iTransportsDao = new TransportsDaoImpl();
    @Override
    public List<Transports> getAllTransports() {
        return iTransportsDao.queryAll();
    }
}
