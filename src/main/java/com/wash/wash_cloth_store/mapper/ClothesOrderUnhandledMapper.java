package com.wash.wash_cloth_store.mapper;

import java.util.List;

import com.wash.wash_cloth_store.entity.ClothesOrderUnhandled;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClothesOrderUnhandledMapper {

    List<ClothesOrderUnhandled> getAll(@Param("vip_member_id") int id);

    List<ClothesOrderUnhandled> getByClothesType(@Param("vip_member_id") int id, @Param("clothesType") int clothesType);

    List<ClothesOrderUnhandled> getByOrderDate(@Param("vip_member_id") int id, @Param("orderDate") String orderDate);

    List<ClothesOrderUnhandled> getById(@Param("id") int id);

    int insert(ClothesOrderUnhandled clothesOrderUnhandled);

    int updateDescriptionById(ClothesOrderUnhandled clothesOrderUnhandled);

    int delete(@Param("id") int id);

}
