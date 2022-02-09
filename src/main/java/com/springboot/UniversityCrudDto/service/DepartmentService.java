package com.springboot.UniversityCrudDto.service;

import com.springboot.UniversityCrudDto.dto.departmentdto.DepartmentDto;
import com.springboot.UniversityCrudDto.entity.Department;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;

import java.util.List;

public interface DepartmentService {

    Department addDepartment(Department department) throws DataNotFoundException;
    public  List<Department> getAllDepartment();
    public Department getDepartmentById(Long departmentId) throws DataNotFoundException;
    public void createDepartment(Department department);
    public void updateDepartment(DepartmentDto departmentIdToUpdate, Department department );
    public Department deleteDepartment(Long departmentIdToDelete) throws DataNotFoundException;
  }
