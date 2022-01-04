package com.wash.wash_cloth_store.service;


import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderUnhandled;
import com.wash.wash_cloth_store.mapper.ClothesOrderUnhandledMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesOrderUnhandledServiceImpl implements ClothesOrderUnhandledService {

    @Autowired
    private ClothesOrderUnhandledMapper clothesOrderUnhandledMapper;

    @Override
    public List<ClothesOrderUnhandled> getAll(int id) {
        return clothesOrderUnhandledMapper.getAll(id);
    }

    @Override
    public List<ClothesOrderUnhandled> getByClothesType(int id, int clothesType) {
        return clothesOrderUnhandledMapper.getByClothesType(id, clothesType);
    }

    @Override
    public List<ClothesOrderUnhandled> getByOrderDate(int id, String orderDate) {
        return clothesOrderUnhandledMapper.getByOrderDate(id, orderDate);
    }

    @Override
    public int insert(ClothesOrderUnhandled clothesOrderUnhandled) {
        return clothesOrderUnhandledMapper.insert(clothesOrderUnhandled);
    }

    @Override
    public int updateDescriptionById(ClothesOrderUnhandled clothesOrderUnhandled) {
        return clothesOrderUnhandledMapper.updateDescriptionById(clothesOrderUnhandled);
    }

    @Override
    public int delete(int id) {
        return clothesOrderUnhandledMapper.delete(id);
    }

    @Override
    public List<ClothesOrderUnhandled> getById(@Param("id") int id) {
        return clothesOrderUnhandledMapper.getById(id);
    }
}
