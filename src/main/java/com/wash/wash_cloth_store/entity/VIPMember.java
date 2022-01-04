package com.wash.wash_cloth_store.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VIPMember {

    private int id;
    private String password;
    private String username;
    private String name;
    private int age;
    private double balance;
    private String phone;
    private String address;
    private Timestamp register_date;

}