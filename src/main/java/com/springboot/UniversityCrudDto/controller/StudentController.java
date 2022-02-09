package com.springboot.UniversityCrudDto.controller;

import com.springboot.UniversityCrudDto.dto.studentdto.StudentDto;
import com.springboot.UniversityCrudDto.dto.studentdto.StudentGroupDto;
import com.springboot.UniversityCrudDto.entity.Student;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.mapper.StudentMapper;
import com.springboot.UniversityCrudDto.mapper.mapping.StudentMapping;
import com.springboot.UniversityCrudDto.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/university/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentMapping studentMapping;


    @GetMapping
    public List<StudentDto> getAllStudent() {
        List<Student> getAllStudent = studentService.getAllStudent();
        return getAllStudent.stream()
                .map(stud -> studentMapper.mapStudentEntityToDto(stud))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{studentId}")
    public StudentDto getStudentById(@PathVariable Long studentId) throws DataNotFoundException {
        Student getstudentById = (Student) studentService.getStudentById(studentId);
        return studentMapper.mapStudentEntityToDto(getstudentById);
    }

    @PostMapping
    public StudentGroupDto createStudent(@RequestBody StudentGroupDto student)
            throws DataNotFoundException {
        Student addingStudentToDB = studentService.createStudent(student);
        return studentMapping.convertStudentEntityToStudentGroupByIdDto(addingStudentToDB);
    }

    //updating student in database
    @PutMapping(path = "{idToUpdate}")
    public StudentGroupDto updateStudent(
            @PathVariable Long idToUpdate,
            @RequestBody StudentGroupDto newStudent
    ) throws Throwable {
        Student updatingStudent = studentService.updateStudent(idToUpdate,newStudent);
        return studentMapping.convertStudentEntityToStudentGroupByIdDto(updatingStudent);
    }

    //deleting student
    @DeleteMapping(path = "{idToDeleted}")
    public void deleteStudent(@PathVariable Long idToDeleted) throws DataNotFoundException {
        studentService.deleteStudent(idToDeleted);
    }



}
