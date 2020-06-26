package com.sms.test;

/**
 * @author Chichiu
 * @date 2020/6/24 12:59
 */
public class StudentsBean {
    private String firstName = null;
    private String lastName = null;
    private int age = 0;

    public StudentsBean() {
    }

    public StudentsBean(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
