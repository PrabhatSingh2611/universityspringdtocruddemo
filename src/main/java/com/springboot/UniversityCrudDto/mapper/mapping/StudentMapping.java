package com.springboot.UniversityCrudDto.mapper.mapping;


import com.springboot.UniversityCrudDto.dto.studentdto.StudentGroupDto;
import com.springboot.UniversityCrudDto.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapping {

    public StudentGroupDto convertStudentEntityToStudentGroupByIdDto(Student databaseStudentAdded) {
        StudentGroupDto addingstudent = new StudentGroupDto();
        addingstudent.setStudentName(databaseStudentAdded.getStudentName(student.getStudentName()));
        addingstudent.setStudentSurname(databaseStudentAdded.getStudentSurname());
        addingstudent.setGender(databaseStudentAdded.isGender());
        addingstudent.setGroupId(databaseStudentAdded.getGroup().getGroupId());
        return addingstudent;
    }




}
