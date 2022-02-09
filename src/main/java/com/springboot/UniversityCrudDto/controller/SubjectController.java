package com.springboot.UniversityCrudDto.controller;


import com.springboot.UniversityCrudDto.entity.Subject;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.service.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/university/subject")
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectService;

    public SubjectController(SubjectServiceImpl subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAllSubject(){
       return subjectService.getAllSubject();
    }

    @PostMapping
    public void createSubject(@RequestBody Subject subject){
        subjectService.createSubject(subject);
    }

    @PutMapping
    public void updateSubject(@PathVariable Long subjectIdToUpdate, Subject subject){
        subjectService.updateSubject(subjectIdToUpdate,new Subject());
    }

    @DeleteMapping
    public void deleteSubject(Long subjectIdToDelete) throws DataNotFoundException {
        subjectService.deleteSubject(subjectIdToDelete);
    }

}
