package com.cjt.domain;

import java.io.Serializable;

/**
 * @author cjt
 */
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String uId;
    private String major;
    private String resume;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", uId='" + uId + '\'' +
                ", major='" + major + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }
}
