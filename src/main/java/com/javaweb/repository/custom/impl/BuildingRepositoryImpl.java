package com.javaweb.repository.custom.impl;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    //join các bảng lại
    public void jointable(BuildingSearchRequest buildingSearchRequest , StringBuilder sql) {
        Long staffID = buildingSearchRequest.getStaffId();
        if (staffID != null) {
            sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");

        }

    }

    // dùng khi là like và =
    public void queryNomal(BuildingSearchRequest buildingSearchRequest , StringBuilder where){
        try{

            Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if (!fieldName.equals("staffId") && !fieldName.startsWith("area")
                        && !fieldName.startsWith("rentPrice")) {
                    Object value = item.get(buildingSearchRequest);
                    if (value!=null && value!="") {

                        if (item.getType().getName().equals("java.lang.Long")) {
                            where.append(" AND b." + fieldName + " = " + value);
                        } else if (item.getType().getName().equals("java.lang.String")){
                            where.append(" AND b." + fieldName + " LIKE '%" + value + "%' ");

                        }

                    }
                }
            }
            // Xử lý riêng cho trường 'type' để tránh NullPointerException
            List<String> type = buildingSearchRequest.getType();
            if (type != null && !type.isEmpty()){
                for(String it : type){
                    where.append(" AND b.type LIKE '%" + it + "%' ");
                }
            }



        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Lỗi trong quá trình tìm kiếm.", e);
        }


    }
    //dùng khi là and , or
    public void querySpecial(BuildingSearchRequest buildingSearchRequest , StringBuilder where){
        Long staffId = buildingSearchRequest.getStaffId();
        if (staffId!=null) {
            where.append(" AND assignmentbuilding.staffid = " + staffId);
        }

        Long rentAreaTo = buildingSearchRequest.getAreaTo();
        Long rentAreaFrom = buildingSearchRequest.getAreaFrom();
        if (rentAreaFrom != null || rentAreaTo != null) {
            where.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid ");

            if (rentAreaFrom != null) {
                where.append(" AND r.value >= " + rentAreaFrom);
            }

            if (rentAreaTo != null) {
                where.append(" AND r.value <= " + rentAreaTo);
            }

            where.append(")");
        }
        Long rentPriceTo = buildingSearchRequest.getRentPriceTo();
        Long rentPriceFrom = buildingSearchRequest.getRentPriceFrom();
        if (rentPriceFrom != null || rentPriceTo != null) {
            if (rentPriceFrom != null) {
                where.append(" AND b.rentprice >=" + rentPriceFrom);
            }
            if (rentPriceTo != null) {
                where.append(" AND b.rentprice <=" + rentPriceTo);
            }
        }

    }






    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<BuildingEntity> searchBuilding(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder(
                "Select b.id , b.name, b.street, b.ward, b.district, b.structure,  b.numberofbasement, b.floorarea , b.direction, b.level, b.rentprice, b.rentpricedescription, b.servicefee, b.carfee, b.motofee, b.overtimefee, b.waterfee, b.electricityfee, b.deposit, b.payment, b.renttime, b.decorationtime, b.brokeragefee, b.type, b.note, b.linkofbuilding, b.map, b.avatar, b.modifiedby, b.createdby, b.modifieddate, b.createddate, b.managername, b.managerphone From building b ");
        jointable(buildingSearchRequest, sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNomal(buildingSearchRequest, where);
        querySpecial(buildingSearchRequest, where);
        sql.append(where);
//        sql.append(" GROUP BY b.id ");
        String SQL = sql.toString();

        Query query = entityManager.createNativeQuery(SQL, BuildingEntity.class);

        return query.getResultList();


    }
}
