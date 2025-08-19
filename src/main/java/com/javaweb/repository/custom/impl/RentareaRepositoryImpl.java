package com.javaweb.repository.custom.impl;

import com.javaweb.entity.RentAreaEntity;
import com.javaweb.repository.custom.RentareaRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RentareaRepositoryImpl implements RentareaRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RentAreaEntity> findnamebybuildingid(long id) {

        String sql = "SELECT * FROM rentarea WHERE rentarea.buildingid = " + id;

        Query query = entityManager.createNativeQuery(sql, RentAreaEntity.class);
        return query.getResultList();
    }

}
