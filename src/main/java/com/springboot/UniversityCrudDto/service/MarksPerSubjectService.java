package com.springboot.UniversityCrudDto.service;

import com.springboot.UniversityCrudDto.entity.MarksPerSubject;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;

public interface MarksPerSubjectService {

    public MarksPerSubject getmarksById(Long marksId) throws DataNotFoundException;
    public void updateMarks(Long marskIdToUpdate, MarksPerSubject marksPerSubject );
    public void deleteMarks(Long marksIdToDelete) throws  DataNotFoundException;



}
