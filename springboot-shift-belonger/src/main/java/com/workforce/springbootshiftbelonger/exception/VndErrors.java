package com.workforce.springbootshiftbelonger.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VndErrors {

    /** The logref. */
    private String logref;

    /** The message. */
    private List<String> message;

}
