package com.wash.wash_cloth_store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    private int id;
    private String username;
    private String password;

}
