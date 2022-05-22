package com.hyh.pojo;

import java.util.Date;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/13 23:25
 */
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String telephone;
    private String sex;
    private Date birthday;

    public User() {
    }

    public User(String id,String username, String password, String email, String name, String telephone, String sex, Date birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.telephone = telephone;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
