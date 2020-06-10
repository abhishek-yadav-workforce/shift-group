package com.workforce.springbootshiftbelonger.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workforce.springbootshiftbelonger.dao.entities.GroupEntity;

@Repository
public interface GroupRepo extends CrudRepository<GroupEntity, Integer> {
    GroupEntity findOneByCode(String code);
}
