package com.wash.wash_cloth_store.service;

import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderHandled;
import org.apache.ibatis.annotations.Param;

public interface ClothesOrderHandledService {
    List<ClothesOrderHandled> getAll(int id);

    List<ClothesOrderHandled> getByClothesType(int id, int clothesType);

    List<ClothesOrderHandled> getByOrderDate(int id, String orderDate);

    List<ClothesOrderHandled> getById(@Param("id") int id);

}
