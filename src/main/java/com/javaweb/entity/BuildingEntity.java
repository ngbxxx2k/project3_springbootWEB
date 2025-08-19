package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "ward",nullable = true)
    private String ward;
    @Column(name = "street",nullable = true)
    private String street;
    @Column(name = "district",nullable = true)
    private String district;
    @Column(name = "structure",nullable = true)
    private String structure;
    @Column(name = "numberofbasement",nullable = true)
    private Long numberOfBasement;
    @Column(name = "floorarea",nullable = true)
    private Long floorArea;
    @Column(name = "direction",nullable = true)
    private String direction;
    @Column(name = "level",nullable = true)
    private String level;
    @Column(name = "rentprice",nullable = true)
    private Long rentPrice;
    @Column(name = "rentpricedescription",nullable = true)
    private String rentPriceDescription;
    @Column(name = "servicefee",nullable = true)
    private String serviceFee;
    @Column(name = "carfee",nullable = true)
    private String carFee;
    @Column(name = "motofee",nullable = true)
    private String motoFee;
    @Column(name = "overtimefee",nullable = true)
    private String overtimeFee;
    @Column(name = "waterfee",nullable = true)
    private String waterFee;
    @Column(name = "electricityfee",nullable = true)
    private String electricityFee;
    @Column(name = "deposit",nullable = true)
    private String deposit;
    @Column(name = "payment",nullable = true)
    private String payment;
    @Column(name = "renttime",nullable = true)
    private String rentTime;
    @Column(name = "decorationtime",nullable = true)
    private String decorationTime;
    @Column(name = "brokeragefee",nullable = true)
    private Double brokerageFee;
    @Column(name = "type",nullable = true)
    private String type;
    @Column(name = "note",nullable = true)
    private String note;
    @Column(name = "linkofbuilding",nullable = true)
    private String linkOfBuilding;
    @Column(name = "map",nullable = true)
    private String map;
    @Column(name = "avatar",nullable = true)
    private String avatar;
    @Column(name = "managername",nullable = true)
    private String managerName;
    @Column(name = "managerphone",nullable = true)
    private String managerPhoneNumber;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid",nullable = false))
    private List<UserEntity> staffs = new ArrayList<>();


    @OneToMany(mappedBy = "buildingEntity",fetch = FetchType.LAZY)
    private List<RentAreaEntity> rentAreaEntities = new ArrayList<>();

    public List<UserEntity> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<UserEntity> staffs) {
        this.staffs = staffs;
    }

    public List<RentAreaEntity> getRentAreaEntities() {
        return rentAreaEntities;
    }

    public void setRentAreaEntities(List<RentAreaEntity> rentAreaEntities) {
        this.rentAreaEntities = rentAreaEntities;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Long getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Long numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getRentPriceDescription() {
        return rentPriceDescription;
    }

    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotoFee() {
        return motoFee;
    }

    public void setMotoFee(String motoFee) {
        this.motoFee = motoFee;
    }

    public String getOvertimeFee() {
        return overtimeFee;
    }

    public void setOvertimeFee(String overtimeFee) {
        this.overtimeFee = overtimeFee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }

    public Double getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(Double brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkOfBuilding() {
        return linkOfBuilding;
    }

    public void setLinkOfBuilding(String linkOfBuilding) {
        this.linkOfBuilding = linkOfBuilding;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }


}
