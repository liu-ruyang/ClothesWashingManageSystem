package com.wash.wash_cloth_store.service;

import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderHandled;
import com.wash.wash_cloth_store.mapper.ClothesOrderHandledMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesOrderHandledServiceImpl implements ClothesOrderHandledService {

    @Autowired
    private ClothesOrderHandledMapper clothesOrderHandledMapper;

    @Override
    public List<ClothesOrderHandled> getAll(int id) {
        return clothesOrderHandledMapper.getAll(id);
    }

    @Override
    public List<ClothesOrderHandled> getByClothesType(int id, int clothesType) {
        return clothesOrderHandledMapper.getByClothesType(id, clothesType);
    }

    @Override
    public List<ClothesOrderHandled> getByOrderDate(int id, String orderDate) {
        return clothesOrderHandledMapper.getByOrderDate(id, orderDate);
    }

    @Override
    public List<ClothesOrderHandled> getById(@Param("id") int id) {
        return clothesOrderHandledMapper.getById(id);
    }

}
