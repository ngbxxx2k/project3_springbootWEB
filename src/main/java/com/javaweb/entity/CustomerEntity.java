package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fullname", nullable = false)
    private String fullName;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "companyname", nullable = true)
    private String companyName;
    @Column(name = "demand", nullable = true)
    private String demand;
    @Column(name = "status", nullable = true)
    private String status;
    @Column(name = "is_active", nullable = true)
    private int is_active;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<AssignmentCustomerEntity> assignmentCustomers = new ArrayList<>();

    public List<AssignmentCustomerEntity> getAssignmentCustomers() {
        return assignmentCustomers;
    }

    public void setAssignmentCustomers(List<AssignmentCustomerEntity> assignmentCustomers) {
        this.assignmentCustomers = assignmentCustomers;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

}
