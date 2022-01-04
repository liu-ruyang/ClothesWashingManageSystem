package com.wash.wash_cloth_store.mapper;

import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderHandled;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClothesOrderHandledMapper {
    List<ClothesOrderHandled> getAll(@Param("vip_member_id") int id);

    List<ClothesOrderHandled> getByClothesType(@Param("vip_member_id") int id, @Param("clothesType") int clothesType);

    List<ClothesOrderHandled> getByOrderDate(@Param("vip_member_id") int id, @Param("orderDate") String orderDate);

    List<ClothesOrderHandled> getById(@Param("id") int id);
}
