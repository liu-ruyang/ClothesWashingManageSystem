package com.wash.wash_cloth_store.service;

import java.sql.Timestamp;
import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrder;
import com.wash.wash_cloth_store.entity.VIPMember;
import org.apache.ibatis.annotations.Param;

public interface VIPMemberService {

    //查看用户是否存在
    VIPMember ifExist(String username, String password);

    //用户查看个人信息
    VIPMember queryPersonalInfo(int id);

    //修改用户个人信息
    int updateVIPMember(int id, VIPMember vipmember);

    //根据会员ID查询个人所有未取订单
    List<ClothesOrder> getAllUnTakenOrders(int id);

    //取走衣物
    int takeAwayClothes(Timestamp order_date);

    //修改密码
    int updatePassword(String username, String oldPassword, String newPassword);

    VIPMember getById(@Param("id") int id);

    int updateVIPMemberById(VIPMember vipMember);


}
