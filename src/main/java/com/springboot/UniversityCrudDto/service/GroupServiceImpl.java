package com.springboot.UniversityCrudDto.service;


import com.springboot.UniversityCrudDto.dto.groupdto.GroupDepartmentByIdDto;
import com.springboot.UniversityCrudDto.entity.Department;
import com.springboot.UniversityCrudDto.entity.Group;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.mapper.GroupMapper;
import com.springboot.UniversityCrudDto.mapper.mapping.GroupMapping;
import com.springboot.UniversityCrudDto.repository.DepartmentRepository;
import com.springboot.UniversityCrudDto.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupMapping groupMapping;

    public GroupServiceImpl(GroupRepository groupRepository, DepartmentRepository departmentRepository, GroupMapper groupMapper, GroupMapping groupMapping) {
        this.groupRepository = groupRepository;
        this.departmentRepository = departmentRepository;
        this.groupMapper = groupMapper;
        this.groupMapping = groupMapping;
    }

    @Override
    public List<Group> getAllGroup() {
        List<Group> grpObj1 = new ArrayList<>();
        groupRepository.findAll().forEach(grpObj1::add);
        return grpObj1;

        //return studentRepository.findAll();
    }

    @Override
    public List<Group> getAllGroupDto() {
    return (List<Group>) groupRepository.findAll();
        }

    @Override
    public Group getGroupById(Long groupId) throws DataNotFoundException {
        Optional<Group> grpObj2 = groupRepository.findById(groupId);
        if (grpObj2.isPresent()) {
            return grpObj2.get();
        } else {
            throw new DataNotFoundException("No employee record exist for given id");
        }

        //    return studentRepository.findById(studentId).get();

    }


    @Override
    public Long createGroup(GroupDepartmentByIdDto groupDepartmentByIdDto, Supplier<? extends Throwable> DataNotFoundException) throws Throwable {
        Department department = departmentRepository
                .findById(groupDepartmentByIdDto.getDepartmentId())
                .orElseThrow(DataNotFoundException);

        Group group = new Group(groupDepartmentByIdDto.getGroupName(), department);
        groupRepository.save(group);

        return groupRepository.getById(group.getGroupId());
    }

    @Override
    public Long updateGroup(GroupDepartmentByIdDto updateGroupByIdDto, Long idTobeUpdated, Supplier<? extends Throwable> DataNotFoundException) throws Throwable {
        groupRepository.findById(idTobeUpdated)
                .orElseThrow(DataNotFoundException);

        Department department = departmentRepository.findById(updateGroupByIdDto.getDepartmentId())
                .orElseThrow(DataNotFoundException);

        Long updateGroup = groupRepository.getById(idTobeUpdated);

        updateGroup.setGroupName(updateGroupByIdDto.getGroupName());
        updateGroup.setDepartment(department);

        groupRepository.save(updateGroup);

        return groupRepository.getById(updateGroup.getGroupId());
    }

    @Override
    public Long deleteGroup(Long idToBeDelete, Supplier<? extends Throwable> DataNotFoundException) throws Throwable {
        Long deleteGroup = groupRepository.findById(idToBeDelete)
                .orElseThrow(DataNotFoundException);
        groupRepository.deleteById(idToBeDelete);
        return deleteGroup;
    }

    public Long updateGroup(GroupDepartmentByIdDto groupDepartmentByIdDto, Long idTobeUpdated) {
        return idTobeUpdated;
    }
}
