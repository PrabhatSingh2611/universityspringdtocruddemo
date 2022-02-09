package com.springboot.UniversityCrudDto.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @Column(name = "sub_id")
    private long subjectId;

    @Column(name = "sub_name")
    private String subjectName;

    public Subject() {
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(Long subjectIdToUpdate, String subjectName) {
    }

    public long getSubId() {
        return subjectId;
    }

    public void setSubId(long subId) {
        this.subjectId = subId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
