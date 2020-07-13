package com.mall.exception;

/**
 * @author Chichiu
 * @date 2020/7/6 7:22
 */
public class RegistException extends Exception {

    public RegistException() {

        super();
    }


    public RegistException(String message, Throwable cause) {

        super(message, cause);
    }

    public RegistException(String message) {

        super(message);
    }

    public RegistException(Throwable cause) {
        super(cause);
    }

}
