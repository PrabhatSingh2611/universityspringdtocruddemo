package com.springboot.UniversityCrudDto.controller;


import com.springboot.UniversityCrudDto.entity.MarksPerSubject;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.service.MarksPerSubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/university/marks")
public class MarksPerSubjectController {

    @Autowired
    private MarksPerSubjectServiceImpl marksPerSubjectService;

    public MarksPerSubjectController(MarksPerSubjectServiceImpl marksPerSubjectService) {
        this.marksPerSubjectService = marksPerSubjectService;
    }

    /*
    @GetMapping(path = "{id}")
    public void getMarksById(Long marksId){
        public  getStudentById(@PathVariable Long id) throws DataNotFoundException {
            return studentService.getStudentById(id);
        }
*/

    @PutMapping
    public void updateMarks(@PathVariable Long marksIdToUpdate, MarksPerSubject marksPerSubject) {
        marksPerSubjectService.updateMarks(marksIdToUpdate,new MarksPerSubject());
    }

    @DeleteMapping
    public void deleteMarks(Long marksIdToDelete) throws DataNotFoundException {
        marksPerSubjectService.deleteMarks(marksIdToDelete);
    }






}
