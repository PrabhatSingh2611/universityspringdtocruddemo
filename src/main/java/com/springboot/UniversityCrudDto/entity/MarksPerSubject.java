package com.springboot.UniversityCrudDto.entity;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "marks_per_subject")
public class MarksPerSubject {


    @Id
    @Column(name = "marks_id")
    private long marksId;

    @Column(name = "Student_marks")
    private double studentMarks;

    @ManyToOne(cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "sub_id_fk", referencedColumnName = "sub_id")
    private Subject subject;

    @ManyToOne(cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "stud_id_fk", referencedColumnName = "stud_id")
    private Student student;

    public MarksPerSubject() {
    }

    public MarksPerSubject(double studentMarks, Subject subject, Student student) {
        this.studentMarks = studentMarks;
        this.subject = subject;
        this.student = student;
    }

    public MarksPerSubject(double studentMarks) {
    }

    public MarksPerSubject(Long marksIdToUpdate, double studentMarks) {


    }

    public long getMarksId() {
        return marksId;
    }

    public void setMarksId(long marksId) {
        this.marksId = marksId;
    }

    public double getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(double studentMarks) {
        this.studentMarks = studentMarks;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "MarksPerSubject{" +
                "marksId=" + marksId +
                ", studentMarks=" + studentMarks +
                ", subject=" + subject +
                ", student=" + student +
                '}';
    }
}
