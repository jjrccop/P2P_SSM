package com.gxa.eloan.common.query;

import com.gxa.eloan.common.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;


/**
 *  登陆日志查询条件 model
 *
 * @author novo
 */

public class IplogQueryObject extends QueryObject {

    private Date beginDate;
    private Date endDate;
    private int state = -1;
    private String username;
    private int userType = -1;


    /**
     * 因为IpLogQueryObject里面的参数都是直接让SpringMVC注入进来的 如果没有配置日期的格式,SpringMVC没法注入日期;
     * 所以,最简单的办法,通过添加@DateTimeFormat标签来告诉SpringMVC日期的注入格式
     *
     * @param beginDate
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate == null ? null : DateUtil.endOfDay(endDate);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return StringUtils.hasLength(username) ? username : null;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

}

