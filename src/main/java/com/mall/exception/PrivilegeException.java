package com.mall.exception;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Chichiu
 * @date 2020/7/4 10:10
 */
public class PrivilegeException extends InvocationTargetException {

    public PrivilegeException() {
        super();
    }

    public PrivilegeException(Throwable target, String s) {
        super(target, s);
    }

    public PrivilegeException(Throwable target) {
        super(target);
    }

}
