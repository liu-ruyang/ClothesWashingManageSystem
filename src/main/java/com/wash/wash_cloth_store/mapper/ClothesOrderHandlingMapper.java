package com.wash.wash_cloth_store.mapper;

import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderHandling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClothesOrderHandlingMapper {
    List<ClothesOrderHandling> getAll(@Param("vip_member_id") int id);

    List<ClothesOrderHandling> getByClothesType(@Param("vip_member_id") int id, @Param("clothesType") int clothesType);

    List<ClothesOrderHandling> getByOrderDate(@Param("vip_member_id") int id, @Param("orderDate") String orderDate);

    List<ClothesOrderHandling> getById(@Param("id") int id);
}
