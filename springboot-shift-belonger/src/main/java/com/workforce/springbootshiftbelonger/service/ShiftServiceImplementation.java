package com.workforce.springbootshiftbelonger.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workforce.springbootshiftbelonger.dao.ShiftGroupingDao;
import com.workforce.springbootshiftbelonger.dao.entities.GroupEntity;
import com.workforce.springbootshiftbelonger.dao.entities.ShiftEntity;
import com.workforce.springbootshiftbelonger.dao.entities.ShiftGroupingEntity;
import com.workforce.springbootshiftbelonger.dto.GroupCode;
import com.workforce.springbootshiftbelonger.dto.ShiftCheckDto;
import com.workforce.springbootshiftbelonger.dto.ShiftCode;
import com.workforce.springbootshiftbelonger.exception.AppManagerServiceException;
import com.workforce.springbootshiftbelonger.utils.MessagesConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShiftServiceImplementation implements ShiftService {

    @Autowired
    private ShiftGroupingDao shiftGroupingDao;

    @Override
    public List<GroupCode> getGroups() {
	return shiftGroupingDao.getGroups().stream()
		.map(group -> GroupCode.builder().code(group.getCode()).id(group.getId()).build())
		.collect(Collectors.toList());
    }

    @Override
    public List<ShiftCode> getShifts() {
	return shiftGroupingDao.getShifts().stream()
		.map(shift -> ShiftCode.builder().id(shift.getId()).code(shift.getCode()).build())
		.collect(Collectors.toList());
    }

    @Override
    public void associateShiftGroup(String shiftCode, String groupCode) {
	ShiftGroupingEntity shiftGroupEntity = new ShiftGroupingEntity();
	ShiftEntity shiftCodeEntity = shiftGroupingDao.findShiftOneByCode(shiftCode);
	GroupEntity groupCodeEnitity = shiftGroupingDao.findGroupOneByCode(groupCode);
	shiftGroupEntity.setShift(shiftCodeEntity);
	shiftGroupEntity.setShiftGroup(groupCodeEnitity);
	shiftGroupingDao.saveGroupShifting(shiftGroupEntity);
    }

    @Override
    public ShiftCheckDto doesShiftBelongsToGroup(String shiftCode, String groupCode) {
	Optional<String> optionalShiftCode = Optional.ofNullable(shiftCode);
	Optional<String> optionalGroupCode = Optional.ofNullable(groupCode);
	if (optionalShiftCode.isPresent() && optionalGroupCode.isPresent()) {
	    ShiftGroupingEntity shiftGroup = shiftGroupingDao
		    .findOneByShiftCodeAndShiftGroupCode(optionalShiftCode.get(), optionalGroupCode.get());
	    if (shiftGroup != null) {
		return ShiftCheckDto.builder().isShiftBelongsToGroup(true)
			.message("Shift " + shiftCode + " belongs to Group " + groupCode + " ").build();

	    } else {
		log.error("Shift:{} doesnot belongs to group:{}.", shiftCode, groupCode);
		return ShiftCheckDto.builder().isShiftBelongsToGroup(true)
			.message("Shift " + shiftCode + " doesn't belongs to Group " + groupCode + " ").build();
	    }
	} else {
	    log.error("Shift:{} association not found with group:{}.", shiftCode, groupCode);
	    throw new AppManagerServiceException(MessagesConstants.ASSOCIATION_NOT_FOUND);
	}

    }

    @Override
    public void saveGroup(String groupCode) {
	GroupEntity groupEntity = new GroupEntity();
	groupEntity.setCode(groupCode);
	shiftGroupingDao.saveGroup(groupEntity);

    }

    @Override
    public void saveShift(String shiftCode) {
	ShiftEntity shiftEntity = new ShiftEntity();
	shiftEntity.setCode(shiftCode);
	shiftGroupingDao.saveShift(shiftEntity);

    }

}
