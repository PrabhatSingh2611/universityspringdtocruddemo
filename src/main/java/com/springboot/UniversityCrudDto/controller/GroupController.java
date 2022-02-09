package com.springboot.UniversityCrudDto.controller;


import com.springboot.UniversityCrudDto.dto.groupdto.GroupDepartmentByIdDto;
import com.springboot.UniversityCrudDto.dto.groupdto.GroupDto;
import com.springboot.UniversityCrudDto.entity.Group;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.mapper.GroupMapper;
import com.springboot.UniversityCrudDto.mapper.mapping.GroupMapping;
import com.springboot.UniversityCrudDto.service.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/university/group")
public class GroupController {

    @Autowired
    private GroupServiceImpl groupService;

    @Autowired
    private GroupMapping groupMapping;

    @Autowired
    private GroupMapper groupMapper;


    @GetMapping
    public List<GroupDto> getAllGroup(){
        List<Group> getAllGroup = groupService.getAllGroupDto();
        return (List<GroupDto>) getAllGroup.stream()
                .map(grp -> groupMapper.mapGroupEntityToDto(grp)
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public GroupDepartmentByIdDto createGroup(@RequestBody GroupDepartmentByIdDto groupDto, Supplier<? extends Throwable> DataNotFoundException) throws Throwable {
        Long creategroupInDB = groupService.createGroup(groupDto, DataNotFoundException);
        return groupMapper.mapGroupEntityToDto(creategroupInDB);
    }

    @PutMapping()
    public GroupDepartmentByIdDto udateGroupById(
            @RequestBody GroupDepartmentByIdDto groupDepartmentByIdDto,
            @RequestParam Long idTobeUpdated
    ) throws DataNotFoundException {
        Long updateGroup = groupService.updateGroup(groupDepartmentByIdDto, idTobeUpdated);
        return groupMapper.mapGroupEntityToDto(updateGroup);
    }

    @DeleteMapping("{idToBeDelete}")
    public GroupDepartmentByIdDto deleteGroupById(@PathVariable Long idToBeDelete, Supplier<? extends Throwable> DataNotFoundException)
            throws Throwable {
        Long deleteGroup = groupService.deleteGroup(idToBeDelete, DataNotFoundException);
        return groupMapper.mapGroupEntityToDto(deleteGroup);
    }

}
