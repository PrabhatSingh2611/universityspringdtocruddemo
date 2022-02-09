package com.springboot.UniversityCrudDto.dto.departmentdto;


import com.springboot.UniversityCrudDto.entity.Group;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.asm.Advice;

import java.util.List;
import java.util.stream.Collector;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDto {

    private String departmentName;


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Object collect(Collector<Object,?, List<Object>> toList) {
        return null;
    }
}
