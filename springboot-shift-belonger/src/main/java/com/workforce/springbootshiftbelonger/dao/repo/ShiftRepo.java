package com.workforce.springbootshiftbelonger.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workforce.springbootshiftbelonger.dao.entities.ShiftEntity;

@Repository
public interface ShiftRepo extends CrudRepository<ShiftEntity, Integer> {

    ShiftEntity findOneByCode(String code);
}
