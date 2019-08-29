package com.gxa.eloan.common.domain;

import java.util.Date;

public class Iplog {
    private Long id;
    private String ip;
    private String username;
    private Date logintime;
    private Byte usertype;
    private Byte state;
    private Long logininfoid;

    public static final Byte LOGIN_SUCCESS=1;
    public static final Byte LOGIN_FAILED=0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getLogininfoid() {
        return logininfoid;
    }

    public void setLogininfoid(Long logininfoid) {
        this.logininfoid = logininfoid;
    }
}