package com.springboot.UniversityCrudDto.service;


import com.springboot.UniversityCrudDto.entity.Subject;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubject() {
        List<Subject> subObj1 = new ArrayList<>();
        subjectRepository.findAll().forEach(subObj1::add);
        return subObj1;

        //return studentRepository.findAll();
    }

    @Override
    public Subject getSubjectById(Long subjectId) throws DataNotFoundException {
        Optional<Subject> subObj2 = subjectRepository.findById(subjectId);
        if (subObj2.isPresent()) {
            return subObj2.get();
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }
        //    return studentRepository.findById(studentId).get();

    }

    @Override
    public void createSubject(Subject subject) {
        Subject subObj3 = new Subject(subject.getSubjectName());
        List<Subject> subjectPresent = subjectRepository
                .findBySubjectName(subject.getSubjectName());
        long count = subjectPresent.size();
        if (count == 0) {
            subjectRepository.save(subObj3);
        }
    }

    @Override
    public void updateSubject(Long subjectIdToUpdate, Subject subject) {
        Subject subObj4 = new Subject(subjectIdToUpdate, subject.getSubjectName());
        if (subjectRepository.findById(subjectIdToUpdate).isPresent()) {
            subjectRepository.save(subObj4);
        } else {
            throw new IllegalArgumentException("No department Present with Id : " + subjectIdToUpdate);
        }
    }

    @Override
    public void deleteSubject(Long subjectIdToDelete) throws DataNotFoundException {
        Optional<Subject> subObj5 = subjectRepository.findById(subjectIdToDelete);
        if (subObj5.isPresent()) {
            subjectRepository.deleteById(subjectIdToDelete);
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }

    }
}



