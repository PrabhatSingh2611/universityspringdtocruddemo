package com.springboot.UniversityCrudDto.entity;


import com.springboot.UniversityCrudDto.dto.departmentdto.DepartmentDto;
import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "department")
@AllArgsConstructor
public class Department {

    @Id
    @Column(name = "dept_id")
    private long departmentId;

    @Column(name = "dept_name", nullable = false)
    private String departmentName;



    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(DepartmentDto departmentIdToUpdate, String departmentName) {
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
