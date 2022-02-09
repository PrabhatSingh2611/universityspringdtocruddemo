package com.springboot.UniversityCrudDto.service;

import com.springboot.UniversityCrudDto.dto.groupdto.GroupDepartmentByIdDto;
import com.springboot.UniversityCrudDto.entity.Group;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;

import java.util.List;
import java.util.function.Supplier;

public interface GroupService {


    List<Group> getAllGroup();
    List<Group> getAllGroupDto();

    Long createGroup(GroupDepartmentByIdDto groupDepartmentByIdDto, Supplier<? extends Throwable> DataNotFoundException) throws Throwable;

    Long updateGroup(GroupDepartmentByIdDto updateGroupByIdDto, Long idTobeUpdated, Supplier<? extends Throwable> DataNotFoundException) throws Throwable;
    Long deleteGroup(Long idToBeDelete, Supplier<? extends Throwable> DataNotFoundException) throws Throwable;
    public Group getGroupById(Long groupId) throws DataNotFoundException;


}
