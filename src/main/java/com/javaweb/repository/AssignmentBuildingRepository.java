//package com.javaweb.repository;
//
//import com.javaweb.entity.AssignmentBuildingEntity;
//import com.javaweb.entity.RentAreaEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity,Long> {
//    void deleteAllByBuildingIdIn(List<Long> ids);
//    List<AssignmentBuildingEntity> findByBuildingIdIn(Long id);
//    void deleteAllByBuildingIdIn(Long id);
//}
