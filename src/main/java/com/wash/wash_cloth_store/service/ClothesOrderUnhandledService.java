package com.wash.wash_cloth_store.service;

import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderUnhandled;
import org.apache.ibatis.annotations.Param;

public interface ClothesOrderUnhandledService {
    List<ClothesOrderUnhandled> getAll(int id);

    List<ClothesOrderUnhandled> getByClothesType(int id, int clothesType);

    List<ClothesOrderUnhandled> getByOrderDate(int id, String orderDate);

    int insert(ClothesOrderUnhandled clothesOrderUnhandled);

    int updateDescriptionById(ClothesOrderUnhandled clothesOrderUnhandled);

    int delete(int id);

    List<ClothesOrderUnhandled> getById(@Param("id") int id);

}
