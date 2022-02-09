package com.springboot.UniversityCrudDto.service;


import com.springboot.UniversityCrudDto.dto.studentdto.StudentGroupDto;
import com.springboot.UniversityCrudDto.entity.Group;
import com.springboot.UniversityCrudDto.entity.Student;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.mapper.StudentMapper;
import com.springboot.UniversityCrudDto.repository.GroupRepository;
import com.springboot.UniversityCrudDto.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studObj1 = new ArrayList<>();
        studentRepository.findAll().forEach(studObj1::add);
        return studObj1;

        //return studentRepository.findAll();

    }

    @Override
    public List<Student> getStudentById(Long studentId) throws DataNotFoundException {
        Optional<Student> studObj2 = studentRepository.findById(studentId);
        if (studObj2.isPresent()) {
            return (List<Student>) studObj2.get();
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }

        //    return departmentRepository.findById(departmentId).get();

    }


    @Override
    public Student createStudent(StudentGroupDto student, Supplier<? extends Throwable> DataNotFoundException) throws Throwable {
        Group group = groupRepository.findById(student.getGroupId())
                .orElseThrow(DataNotFoundException);

        Student addingOfStudent = new Student();
        addingOfStudent.setStudentName(student.getStudentName());
        addingOfStudent.setStudentName(student.getStudentSurname());
        addingOfStudent.setGender(student.isGender());
        //     addingOfStudent.setAge(student.getAge());
        addingOfStudent.setGroup(group);

        studentRepository.save(addingOfStudent);
        return addingOfStudent;

    }


    @Override
    public Student updateStudent(Long idToUpdate, StudentGroupDto newStudent) throws Throwable {
        Supplier<? extends Throwable> DataNotFoundException = null;
        Group group = groupRepository.findById(newStudent.getGroupId())
                .orElseThrow(DataNotFoundException);

        Student updateStudent = studentRepository.findById(idToUpdate)
                .orElseThrow(DataNotFoundException);

        updateStudent.setStudentName(newStudent.getStudentName());
        updateStudent.setStudentSurname(newStudent.getStudentSurname());
        updateStudent.setGender(newStudent.isGender());
        updateStudent.setGroup(group);

        studentRepository.save(updateStudent);
        studentRepository.getById(updateStudent.getStudentId());

        return updateStudent;
    }

    @Override
    public void deleteStudent(Long studentIdToDelete) throws DataNotFoundException {
        Optional<Student> grpObj4 = studentRepository.findById(studentIdToDelete);
        if (grpObj4.isPresent()) {
            studentRepository.deleteById(studentIdToDelete);
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }

    }

    public Student createStudent(StudentGroupDto student) {
        return (Student) student;
    }
}
