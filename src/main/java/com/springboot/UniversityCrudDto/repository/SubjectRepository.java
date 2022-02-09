package com.springboot.UniversityCrudDto.repository;

import com.springboot.UniversityCrudDto.entity.Department;
import com.springboot.UniversityCrudDto.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Long> {
    List<Subject> findBySubjectName(String subjectName);
}
