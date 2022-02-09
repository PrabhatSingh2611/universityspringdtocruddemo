package com.springboot.UniversityCrudDto.mapper.mapping;

import com.springboot.UniversityCrudDto.dto.groupdto.GroupDepartmentByIdDto;
import com.springboot.UniversityCrudDto.dto.groupdto.GroupDepartmentDto;
import com.springboot.UniversityCrudDto.entity.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapping {
    public GroupDepartmentDto toUpdateGroupDepartmeDto(Group group) {
        GroupDepartmentDto updateGroupDeparmentDto = new GroupDepartmentDto();
        updateGroupDeparmentDto.setDepartmentId(group.getDepartment().getDepartmentId());
        updateGroupDeparmentDto.getGroupName(group.getGroupName());
        return updateGroupDeparmentDto;
    }

    public GroupDepartmentByIdDto convertGroupEntityToGroupDepartmentByIdDto(Group databaseGroup) {
        GroupDepartmentByIdDto databaseGroupDto = new GroupDepartmentByIdDto();
        databaseGroupDto.setGroupName(databaseGroup.getGroupName());
        databaseGroupDto.setDepartmentId(databaseGroup.getDepartment().getDepartmentId());
        return databaseGroupDto;
    }
}
