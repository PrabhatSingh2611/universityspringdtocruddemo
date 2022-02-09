package com.springboot.UniversityCrudDto.repository;

import com.springboot.UniversityCrudDto.dto.departmentdto.DepartmentDto;
import com.springboot.UniversityCrudDto.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

    @Query("select d from Department d where d.departmentName like concat('%', ?1, '%')")
    List<Department> findByDepartmentName(String departmentName);


    Department getById(long departmentId);

    Optional<Object> findById(DepartmentDto departmentIdToUpdate);
}

