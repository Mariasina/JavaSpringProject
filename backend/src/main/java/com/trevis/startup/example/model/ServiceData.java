package com.trevis.startup.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ServiceData")
public class ServiceData {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="Label")
    private String label;

    @Column(name="Description")
    private String description;

    @Column(name="IsIntern")
    private Boolean isIntern;

    @Column(name="ManagerName")
    private String managerName;

    @OneToOne
    @JoinColumn(name="ManagerDepartment", referencedColumnName = "Id")
    private DepartmentData managerDepartment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsIntern() {
        return isIntern;
    }

    public void setIsIntern(Boolean isIntern) {
        this.isIntern = isIntern;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public DepartmentData getManagerDepartment() {
        return managerDepartment;
    }

    public void setManagerDepartment(DepartmentData managerDepartment) {
        this.managerDepartment = managerDepartment;
    }
}
