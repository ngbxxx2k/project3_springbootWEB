//package com.javaweb.repository;
//
//import java.util.List;
//
//import com.javaweb.entity.BuildingEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.javaweb.Builder.BuildingSearchBuilder;
//import com.javaweb.custom.BuildingRepositoryCustom;
//import com.javaweb.repository.entity.BuildingEntity;
//
//public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>,BuildingRepositoryCustom {
//
//    List<BuildingEntity> FindBuilding(BuildingSearchBuilder buildingsearchbuilder);
//    //xoá theo danh sách
//    void deleteByIdIn(List<Long> ids);
//
//
//}