package com.workforce.springbootshiftbelonger.service;

import java.util.List;

import com.workforce.springbootshiftbelonger.dto.GroupCode;
import com.workforce.springbootshiftbelonger.dto.ShiftCheckDto;
import com.workforce.springbootshiftbelonger.dto.ShiftCode;

public interface ShiftService {

    /**
     * 
     * @return
     */
    List<GroupCode> getGroups();

    /**
     * @return
     */
    List<ShiftCode> getShifts();

    void saveGroup(String groupCode);

    void saveShift(String shiftCode);

    void associateShiftGroup(String shiftCode, String shiftGroup);

    ShiftCheckDto doesShiftBelongsToGroup(String shiftCode, String groupCode);

}
