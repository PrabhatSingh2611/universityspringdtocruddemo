package com.springboot.UniversityCrudDto.entity;


import com.springboot.UniversityCrudDto.dto.studentdto.StudentGroupDto;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student extends StudentGroupDto {

    @Id
    @Column(name = "stud_id")
    private long studentId;

    @Column(name = "stud_name")
    private String studentName;

    @Column(name = "stud_surname")
    private String studentSurname;

    @Column(name = "stud_gender")
    private boolean gender;

    @Column(name = "stud_age")
    private int age;

    @ManyToOne(cascade = CascadeType.ALL,
    optional = false)
    @JoinColumn(name = "grp_id_fk", referencedColumnName = "grp_id")
    private Group group;

    public Student() {
    }

    public Student(String studentName, String studentSurname, boolean gender, int age, Group group) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.gender = gender;
        this.age = age;
        this.group = group;
    }

    public Student(String studentName) {
    }

    public Student(Long studentIdToUpdate, String studentName) {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName(String studentName) {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", group=" + group +
                '}';
    }
}
