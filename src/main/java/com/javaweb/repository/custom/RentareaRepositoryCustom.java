package com.javaweb.repository.custom;

import com.javaweb.entity.RentAreaEntity;

import java.util.List;

public interface RentareaRepositoryCustom {
    public List<RentAreaEntity> findnamebybuildingid(long id);
}
