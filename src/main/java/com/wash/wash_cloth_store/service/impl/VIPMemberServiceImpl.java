package com.wash.wash_cloth_store.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrder;
import com.wash.wash_cloth_store.entity.VIPMember;
import com.wash.wash_cloth_store.mapper.VIPMemberMapper;
import com.wash.wash_cloth_store.service.VIPMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VIPMemberServiceImpl implements VIPMemberService {
    @Autowired
    VIPMemberMapper vipMemberMapper;

    @Override
    public VIPMember ifExist(String username, String password) {
        return vipMemberMapper.ifExist(username, password);
    }

    @Override
    public VIPMember queryPersonalInfo(int id) {
        return vipMemberMapper.queryPersonalInfo(id);
    }

    @Override
    public int updateVIPMember(int id, VIPMember vipmember) {
        return vipMemberMapper.updateVIPMember(id, vipmember);
    }

    @Override
    public List<ClothesOrder> getAllUnTakenOrders(int id) {
        return vipMemberMapper.getAllUnTakenOrders(id);
    }

    @Override
    public int takeAwayClothes(Timestamp order_date) {
        return vipMemberMapper.takeAwayClothes(order_date);
    }

    @Override
    public int updatePassword(String username, String oldPassword, String newPassword) {
        return vipMemberMapper.updatePassword(username, oldPassword, newPassword);
    }


    @Override
    public VIPMember getById(int id) {
        return vipMemberMapper.getById(id);
    }

    @Override
    public int updateVIPMemberById(VIPMember vipMember) {
        return vipMemberMapper.updateVIPMemberById(vipMember);
    }

}
