package com.springboot.UniversityCrudDto.repository;

import com.springboot.UniversityCrudDto.entity.Department;
import com.springboot.UniversityCrudDto.entity.MarksPerSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksPerSubjectRepository extends CrudRepository<MarksPerSubject,Long> {
}
