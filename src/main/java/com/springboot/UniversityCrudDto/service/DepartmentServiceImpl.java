package com.springboot.UniversityCrudDto.service;

import com.springboot.UniversityCrudDto.dto.departmentdto.DepartmentDto;
import com.springboot.UniversityCrudDto.entity.Department;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.mapper.DepartmentMapper;
import com.springboot.UniversityCrudDto.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Department addDepartment(Department department) {
        departmentRepository.save(department);
        return departmentRepository.getById(department.getDepartmentId());
    }



    @Override
    public List<Department> getAllDepartment() {
        List<Department> deptObj1 = new ArrayList<>();
        departmentRepository.findAll().forEach(deptObj1::add);
        return deptObj1;

        //return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DataNotFoundException {
        Optional<Department> deptObj2 = departmentRepository.findById(departmentId);
        if(deptObj2.isPresent()) {
            return deptObj2.get();
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }

        //    return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void updateDepartment(DepartmentDto departmentIdToUpdate, Department department) {
        Department deptObj4 = new Department(departmentIdToUpdate, department.getDepartmentName());
        if (departmentRepository.findById(departmentIdToUpdate).isPresent()) {
            departmentRepository.save(deptObj4);
        } else {
            throw new IllegalArgumentException("No department Present with Id : " + departmentIdToUpdate);
        }
    }

    @Override
    public void createDepartment(Department department) {
        Department deptObj2= new Department(department.getDepartmentName());
        List<Department> departmentPresent = departmentRepository
                .findByDepartmentName(department.getDepartmentName());
        // .toLowerCase(Locale.ROOT));
        long count = departmentPresent.size();
        if (count == 0) {
            departmentRepository.save(deptObj2);
        }
    }



    @Override
    public Department deleteDepartment(Long departmentIdToDelete) throws DataNotFoundException {
        Optional<Department> deptobj3 = departmentRepository.findById(departmentIdToDelete);
        if(deptobj3.isPresent())
        {
            departmentRepository.deleteById(departmentIdToDelete);
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }


        return null;
    }




}
