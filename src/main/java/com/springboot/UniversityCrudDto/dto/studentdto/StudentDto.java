package com.springboot.UniversityCrudDto.dto.studentdto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {


    private String studentName;
    private String studenSurname;
    private int age;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudenSurname() {
        return studenSurname;
    }

    public void setStudenSurname(String studenSurname) {
        this.studenSurname = studenSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
