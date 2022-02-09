package com.springboot.UniversityCrudDto.service;

import com.springboot.UniversityCrudDto.dto.studentdto.StudentGroupDto;
import com.springboot.UniversityCrudDto.entity.Student;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;

import java.util.List;
import java.util.function.Supplier;

public interface StudentService {


    List<Student> getAllStudent();
    public List<Student> getStudentById(Long studentId) throws DataNotFoundException;
    Student createStudent(StudentGroupDto student, Supplier<? extends Throwable> DataNotFoundException) throws Throwable;
    public Student updateStudent(Long idToUpdate, StudentGroupDto newStudent) throws Throwable;
    public void deleteStudent(Long studentIdToDelete) throws DataNotFoundException;

}
