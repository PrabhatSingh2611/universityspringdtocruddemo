package com.springboot.UniversityCrudDto.dto.groupdto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collector;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupDepartmentByIdDto {

    private String groupName;
    private long departmentId;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public Object collect(Collector<Object, ?, List<Object>> toList) {
        return toList;
    }
}
