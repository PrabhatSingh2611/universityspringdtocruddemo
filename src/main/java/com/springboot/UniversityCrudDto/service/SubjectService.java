package com.springboot.UniversityCrudDto.service;

import com.springboot.UniversityCrudDto.entity.Subject;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;

import java.util.List;

public interface SubjectService {


    List<Subject> getAllSubject();
    public Subject getSubjectById(Long subjectId) throws DataNotFoundException;
    public void createSubject(Subject subject);
    public void updateSubject(Long subjectIdToUpdate, Subject subject );
    public void deleteSubject(Long subjectIdToDelete) throws DataNotFoundException;

}
