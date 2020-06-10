package com.workforce.springbootshiftbelonger.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workforce.springbootshiftbelonger.dao.entities.ShiftGroupingEntity;

@Repository
public interface ShiftGroupingRepo extends CrudRepository<ShiftGroupingEntity, Integer> {

    ShiftGroupingEntity findOneByShiftCodeAndShiftGroupCode(String shiftCode, String groupCode);
}
