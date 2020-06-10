package com.workforce.springbootshiftbelonger.dao;

import java.util.List;

import com.workforce.springbootshiftbelonger.dao.entities.GroupEntity;
import com.workforce.springbootshiftbelonger.dao.entities.ShiftEntity;
import com.workforce.springbootshiftbelonger.dao.entities.ShiftGroupingEntity;

public interface ShiftGroupingDao {

    List<ShiftEntity> getShifts();

    List<GroupEntity> getGroups();

    ShiftGroupingEntity findOneByShiftCodeAndShiftGroupCode(String shiftCode, String groupCode);

    void saveShift(ShiftEntity shiftEntity);

    void saveGroup(GroupEntity groupEntity);

    void saveGroupShifting(ShiftGroupingEntity shiftGroupingEntity);

    ShiftEntity findShiftOneByCode(String code);

    GroupEntity findGroupOneByCode(String code);

}
