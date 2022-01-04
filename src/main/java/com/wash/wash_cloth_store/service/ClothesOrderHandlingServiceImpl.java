package com.wash.wash_cloth_store.service;

import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderHandling;
import com.wash.wash_cloth_store.mapper.ClothesOrderHandlingMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesOrderHandlingServiceImpl implements ClothesOrderHandlingService {

    @Autowired
    private ClothesOrderHandlingMapper clothesOrderHandlingMapper;

    @Override
    public List<ClothesOrderHandling> getAll(int id) {
        return clothesOrderHandlingMapper.getAll(id);
    }

    @Override
    public List<ClothesOrderHandling> getByClothesType(int id, int clothesType) {
        return clothesOrderHandlingMapper.getByClothesType(id, clothesType);
    }

    @Override
    public List<ClothesOrderHandling> getByOrderDate(int id, String orderDate) {
        return clothesOrderHandlingMapper.getByOrderDate(id, orderDate);
    }

    @Override
    public List<ClothesOrderHandling> getById(@Param("id") int id) {
        return clothesOrderHandlingMapper.getById(id);
    }

}
