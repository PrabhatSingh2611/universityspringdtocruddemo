package com.springboot.UniversityCrudDto.dto.groupdto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupDepartmentDto {

    private  String title;
    private long departmentId;

    public String getGroupName(String groupName) {
        return this.title;
    }

    public void setGroupName(String groupName) {
        this.title = groupName;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
}
