package com.springboot.UniversityCrudDto.repository;

import com.springboot.UniversityCrudDto.entity.Department;
import com.springboot.UniversityCrudDto.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findByStudentName(String studentName);

    void getById(long studentId);
}
