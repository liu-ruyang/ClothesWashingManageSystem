package com.wash.wash_cloth_store.service;

import java.sql.Timestamp;
import java.util.List;

import com.wash.wash_cloth_store.entity.Administrator;
import com.wash.wash_cloth_store.entity.ClothesOrder;
import com.wash.wash_cloth_store.entity.ClothesType;
import com.wash.wash_cloth_store.entity.VIPMember;

public interface AdministratorService {

    //查管理员信息
    Administrator ifExist(String username, String password);

    //查看所有会员
    List<VIPMember> queryAll();

    //删除单个用户信息
    int deleteMember(int id);

    //添加用户
    int addMember(VIPMember vipMember);

    //查找用户
    VIPMember queryMember(int id);

    //进行充值（修改余额）
    int updateBalance(int id, int newBlance);

    //查询所有用户的订单
    List<ClothesOrder> getAllUserOrder();

    //查询所有衣物种类
    List<ClothesType> getClothesTypes();

    //根据日期查询指定的订单
    ClothesOrder getOrderByOrder_date(Timestamp orderdate);

    //删除未洗订单
    int deleteUnhandledOrder(int id);

    //添加进行中订单
    int addHandlingOrder(ClothesOrder clothesOrder);

    //删除进行中订单
    int deleteHandlingOrder(int id);

    //添加已洗订单
    int addHandledOrder(ClothesOrder clothesOrder);
}
