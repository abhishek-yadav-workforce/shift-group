package com.workforce.springbootshiftbelonger.exception;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class AppManagerServiceException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The status code. */
    private int statusCode;

    /**
     * Instantiates a new app manager service exception.
     *
     * @param errorCode
     *            the error code
     * @param message
     *            the message
     */
    public AppManagerServiceException(int errorCode, String message) {
        super(message);
        this.statusCode = errorCode;
    }

    /**
     * Instantiates a new app manager service exception.
     *
     * @param message
     *            the message
     */
    public AppManagerServiceException(String message) {
        super(message);

    }
}
