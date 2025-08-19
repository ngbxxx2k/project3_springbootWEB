package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity,Long> {
    public void deleteAllByBuildingEntityId(Long id);
    void deleteAllByBuildingEntityIdIn(List<Long> ids);
}
