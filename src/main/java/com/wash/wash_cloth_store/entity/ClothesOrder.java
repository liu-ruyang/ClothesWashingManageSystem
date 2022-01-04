package com.wash.wash_cloth_store.entity;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothesOrder {
    private int id;
    private String description;
    private Timestamp order_date;
    private int count;
    private int clothes_type;
    private int vip_member_id;
    private String name;
    private double fee;
    private int status;
    private int taken;
    private Timestamp finished_date;

    private Timestamp orderDate;
    private int clothesType;
    private int vipMemberId;
    private Timestamp finishedDate;
    private List<ClothesType> clothesTypes;
    private List<VIPMember> vipMembers;

}