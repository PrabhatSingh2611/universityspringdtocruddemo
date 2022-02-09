package com.springboot.UniversityCrudDto.service;


import com.springboot.UniversityCrudDto.entity.MarksPerSubject;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.repository.MarksPerSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarksPerSubjectServiceImpl implements MarksPerSubjectService{

    @Autowired
    private MarksPerSubjectRepository marksPerSubjectRepository;


    public MarksPerSubjectServiceImpl(MarksPerSubjectRepository marksPerSubjectRepository) {
        this.marksPerSubjectRepository = marksPerSubjectRepository;
    }



    @Override
    public MarksPerSubject getmarksById(Long marksId) throws DataNotFoundException {
        Optional<MarksPerSubject> marksObj2 = marksPerSubjectRepository.findById(marksId);
        if (marksObj2.isPresent()) {
            return marksObj2.get();
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }
    }


    @Override
    public void updateMarks(Long marksIdToUpdate, MarksPerSubject marksPerSubject) {
        MarksPerSubject marksObj3 = new MarksPerSubject(marksIdToUpdate, marksPerSubject.getStudentMarks());
        if (marksPerSubjectRepository.findById(marksIdToUpdate).isPresent()) {
            marksPerSubjectRepository.save(marksObj3);
        } else {
            throw new IllegalArgumentException("No department Present with Id : " + marksIdToUpdate);
        }

    }

    @Override
    public void deleteMarks(Long marksIdToDelete) throws DataNotFoundException {
        Optional<MarksPerSubject> marksObj4 = marksPerSubjectRepository.findById(marksIdToDelete);
        if (marksObj4.isPresent()) {
            marksPerSubjectRepository.deleteById(marksIdToDelete);
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }

    }
}















