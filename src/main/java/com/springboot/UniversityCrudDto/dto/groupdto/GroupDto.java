package com.springboot.UniversityCrudDto.dto.groupdto;

import com.springboot.UniversityCrudDto.entity.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;

@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Object collect(Collector<Object,?, List<Object>> toList) {
        return null;
    }
}
