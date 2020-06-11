package com.workforce.springbootshiftbelonger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workforce.springbootshiftbelonger.dto.GroupCode;
import com.workforce.springbootshiftbelonger.dto.ShiftCheckDto;
import com.workforce.springbootshiftbelonger.dto.ShiftCode;
import com.workforce.springbootshiftbelonger.service.ShiftService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping(value = "/shiftgrouping")
@Slf4j
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    @GetMapping(value = "/shifts")
    public ResponseEntity<List<ShiftCode>> getShifts() {
	return ResponseEntity.status(HttpStatus.OK).body(shiftService.getShifts());
    }

    @GetMapping(value = "/groups")
    public ResponseEntity<List<GroupCode>> getGroups() {
	return ResponseEntity.status(HttpStatus.OK).body(shiftService.getGroups());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/shifts/{shiftCode}")
    public void shifts(@PathVariable String shiftCode) {
	shiftService.saveShift(shiftCode);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/groups/{groupCode}")
    public void groups(@PathVariable String groupCode) {
	shiftService.saveGroup(groupCode);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{shiftCode}/{groupCode}")
    public void associateShiftGroups(@PathVariable String shiftCode, @PathVariable String groupCode) {
	log.info("associating shift code: {} with group code: {}", shiftCode, groupCode);
	shiftService.associateShiftGroup(shiftCode, groupCode);
    }

    @DeleteMapping("/{shiftCode}/{groupCode}")
    public ResponseEntity<String> deAssociateShiftGroups(@PathVariable String shiftCode,
	    @PathVariable String groupCode) {
	log.info("associating shift code: {} with group code: {}", shiftCode, groupCode);
	return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @GetMapping(value = "/checkshiftgroups/{shiftCode}/{groupCode}")
    public ResponseEntity<ShiftCheckDto> checkshiftBelongsToGroup(@PathVariable String shiftCode,
	    @PathVariable String groupCode) {
	log.info("checkshiftBelongsToGroup shift code: {} with group code: {}", shiftCode, groupCode);
	return ResponseEntity.status(HttpStatus.OK).body(shiftService.doesShiftBelongsToGroup(shiftCode, groupCode));
    }
}
