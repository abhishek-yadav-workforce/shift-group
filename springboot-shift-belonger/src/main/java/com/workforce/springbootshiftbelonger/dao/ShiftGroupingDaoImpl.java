package com.workforce.springbootshiftbelonger.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workforce.springbootshiftbelonger.dao.entities.GroupEntity;
import com.workforce.springbootshiftbelonger.dao.entities.ShiftEntity;
import com.workforce.springbootshiftbelonger.dao.entities.ShiftGroupingEntity;
import com.workforce.springbootshiftbelonger.dao.repo.GroupRepo;
import com.workforce.springbootshiftbelonger.dao.repo.ShiftGroupingRepo;
import com.workforce.springbootshiftbelonger.dao.repo.ShiftRepo;

@Component
public class ShiftGroupingDaoImpl implements ShiftGroupingDao {

    @Autowired
    private ShiftRepo shiftRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private ShiftGroupingRepo shiftGroupingRepo;

    @Override
    public ShiftGroupingEntity findOneByShiftCodeAndShiftGroupCode(String shiftCode, String groupCode) {
	return shiftGroupingRepo.findOneByShiftCodeAndShiftGroupCode(shiftCode, groupCode);
    }

    @Override
    public void saveShift(ShiftEntity shiftEntity) {
	shiftRepo.save(shiftEntity);

    }

    @Override
    public void saveGroup(GroupEntity groupEntity) {
	groupRepo.save(groupEntity);

    }

    @Override
    public List<ShiftEntity> getShifts() {
	List<ShiftEntity> shifts = new ArrayList<>();
	shiftRepo.findAll().forEach(shifts::add);
	return shifts;
    }

    @Override
    public List<GroupEntity> getGroups() {
	List<GroupEntity> shifts = new ArrayList<>();
	groupRepo.findAll().forEach(shifts::add);
	return shifts;
    }

    @Override
    public void saveGroupShifting(ShiftGroupingEntity shiftGroupingEntity) {
	shiftGroupingRepo.save(shiftGroupingEntity);
    }

    @Override
    public ShiftEntity findShiftOneByCode(String code) {
	return shiftRepo.findOneByCode(code);
    }

    @Override
    public GroupEntity findGroupOneByCode(String code) {
	return groupRepo.findOneByCode(code);
    }
}
