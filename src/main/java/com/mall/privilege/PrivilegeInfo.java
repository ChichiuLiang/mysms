package com.mall.privilege;

import java.lang.annotation.*;

/**
 * @author Chichiu
 * @date 2020/7/4 10:07
 */
//RetentionPolicy.RUNTIME:这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用
//@Target(ElementType.METHOD)——方法
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface PrivilegeInfo {
    String value(); //权限名称
}
