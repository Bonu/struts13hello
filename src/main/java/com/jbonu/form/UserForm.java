package com.jbonu.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {
    private Integer id;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;

    public UserForm() {
    }

    public UserForm(Integer id, String firstName, String lastName, String age,
                    String gender) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
    public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}