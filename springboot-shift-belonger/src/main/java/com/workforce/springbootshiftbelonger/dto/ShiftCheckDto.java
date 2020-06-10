package com.workforce.springbootshiftbelonger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class ShiftCheckDto {

    private boolean isShiftBelongsToGroup;
    private String message;
}
