package com.wash.wash_cloth_store.service;

import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderHandling;
import org.apache.ibatis.annotations.Param;

public interface ClothesOrderHandlingService {
    List<ClothesOrderHandling> getAll(int id);

    List<ClothesOrderHandling> getByClothesType(int id, int clothesType);

    List<ClothesOrderHandling> getByOrderDate(int id, String orderDate);

    List<ClothesOrderHandling> getById(@Param("id") int id);

}
