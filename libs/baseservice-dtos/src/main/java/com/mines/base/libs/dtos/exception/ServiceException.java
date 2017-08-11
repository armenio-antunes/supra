package com.mines.base.libs.dtos.exception;

/**
 * Generic plan status service exception.
 *
 * @author andre.macedo
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = -1122815227208954465L;

    private final String errorCode;

    /**
     * Init exception with provided exception.
     *
     * @param errorCode the error code
     * @param message   the associated message
     */
    public ServiceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
