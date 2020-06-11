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

    /**
     * @param groupCode
     */
    void saveGroup(String groupCode);

    /**
     * @param shiftCode
     */
    void saveShift(String shiftCode);

    /**
     * @param shiftCode
     * @param shiftGroup
     */
    void associateShiftGroup(String shiftCode, String shiftGroup);

    /**
     * @param shiftCode
     * @param groupCode
     * @return
     */
    ShiftCheckDto doesShiftBelongsToGroup(String shiftCode, String groupCode);

}
