package com.wash.wash_cloth_store;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wash.wash_cloth_store.entity.Administrator;
import com.wash.wash_cloth_store.entity.ClothesOrder;
import com.wash.wash_cloth_store.entity.ClothesType;
import com.wash.wash_cloth_store.entity.VIPMember;
import com.wash.wash_cloth_store.mapper.VIPMemberMapper;
import com.wash.wash_cloth_store.service.AdministratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WashClothStoreApplicationTests {


    @Autowired
    VIPMemberMapper vipMemberMapper;

    @Autowired
    AdministratorService administratorService;

    @Test
    void contextLoads() {
        VIPMember vipMember = new VIPMember();
        vipMember.setId(1);
        vipMember.setUsername("zhangsan");
        vipMember.setName("张三");
        vipMember.setAge(20);
        vipMember.setBalance(30.0);
        vipMember.setPhone("123456789");
        vipMember.setAddress("南京信息工程大学");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //String time = new SimpleDateFormat("yyyy/MM/dd").format(timestamp);
        vipMember.setRegister_date(timestamp);

        vipMemberMapper.updateVIPMember(2, vipMember);
    }

    @Test
    public void te() {
        VIPMember vipMember = vipMemberMapper.ifExist("zhangsan", "123123");
        System.out.println(vipMember);
    }

    @Test
    public void aa() {
        Administrator lry = administratorService.ifExist("1ry", "123123");
        System.out.println(lry);
    }

    @Test
    public void bb() {
        List<VIPMember> vipMembers = administratorService.queryAll();
        System.out.println(vipMembers);
    }

    @Test
    public void cc() {
        VIPMember vipMember = administratorService.queryMember(22);
        List<VIPMember> objects = new ArrayList<>();
        objects.add(vipMember);
        System.out.println(objects);
    }

    @Test
    public void dd() {
        List<ClothesOrder> allUserOrder = administratorService.getAllUserOrder();
        System.out.println(allUserOrder);
    }

    @Test
    public void ee() {
        List<ClothesType> clothesTypes = administratorService.getClothesTypes();
        System.out.println(clothesTypes);
    }

    @Test
    public void ff() {
        List<ClothesOrder> allUserOrder = administratorService.getAllUserOrder();
        System.out.println(allUserOrder);
    }

    @Test
    public void gg() {
        ClothesOrder orderByOrder_date = administratorService.getOrderByOrder_date(Timestamp.valueOf("2021-12-10 23:55:22.0"));
        System.out.println(orderByOrder_date.getFee());
        System.out.println(orderByOrder_date);
    }

    @Test
    public void hh() {
//        vipMemberMapper.updateVIPMember()
        List<ClothesOrder> allUnTakenOrders = vipMemberMapper.getAllUnTakenOrders(2);
        for (ClothesOrder allUnTakenOrder : allUnTakenOrders) {

            System.out.println(allUnTakenOrder);

        }
    }

    @Test
    public void ii() {
        int lisi = vipMemberMapper.updatePassword("lisi", "123123", "12");
        System.out.println(lisi);
    }
}
