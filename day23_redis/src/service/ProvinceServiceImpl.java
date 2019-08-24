package service;

import dao.impl.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao=new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }
}
