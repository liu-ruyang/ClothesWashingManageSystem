package com.wash.wash_cloth_store.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.wash.wash_cloth_store.entity.Administrator;
import com.wash.wash_cloth_store.entity.ClothesOrder;
import com.wash.wash_cloth_store.entity.ClothesType;
import com.wash.wash_cloth_store.entity.VIPMember;
import com.wash.wash_cloth_store.mapper.AdministratorMapper;
import com.wash.wash_cloth_store.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {


    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public Administrator ifExist(String username, String password) {
        return administratorMapper.ifExist(username, password);
    }

    @Override
    public List<VIPMember> queryAll() {
        return administratorMapper.queryAll();
    }

    @Override
    public int deleteMember(int id) {
        return administratorMapper.deleteMember(id);
    }

    @Override
    public int addMember(VIPMember vipMember) {
        return administratorMapper.addMember(vipMember);
    }

    @Override
    public VIPMember queryMember(int id) {
        return administratorMapper.queryMember(id);
    }

    @Override
    public int updateBalance(int id, int newBlance) {
        return administratorMapper.updateBalance(id, newBlance);
    }

    @Override
    public List<ClothesOrder> getAllUserOrder() {
        return administratorMapper.getAllUserOrder();
    }

    @Override
    public List<ClothesType> getClothesTypes() {
        return administratorMapper.getClothesTypes();
    }

    @Override
    public ClothesOrder getOrderByOrder_date(Timestamp orderdate) {
        return administratorMapper.getOrderByOrder_date(orderdate);
    }

    @Override
    public int deleteUnhandledOrder(int id) {
        return administratorMapper.deleteUnhandledOrder(id);
    }

    @Override
    public int addHandlingOrder(ClothesOrder clothesOrder) {
        return administratorMapper.addHandlingOrder(clothesOrder);
    }

    @Override
    public int deleteHandlingOrder(int id) {
        return administratorMapper.deleteHandlingOrder(id);
    }

    @Override
    public int addHandledOrder(ClothesOrder clothesOrder) {
        return administratorMapper.addHandledOrder(clothesOrder);
    }
}
