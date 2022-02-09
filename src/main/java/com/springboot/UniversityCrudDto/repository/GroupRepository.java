package com.springboot.UniversityCrudDto.repository;

import com.springboot.UniversityCrudDto.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group,Long> {
    List<Group> findByGroupName(String groupName);

    Long getById(Long groupId);
}
