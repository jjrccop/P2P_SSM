package com.gxa.eloan.common.domain;

import com.gxa.eloan.common.util.BitStatesUtils;

public class UserInfo {

    private static Long INCOME_GRADES = 1L;
    private static Long EDUCATION_BACKGROUND = 2L;
    private static Long MARRIAGES = 3L;
    private static Long KID_COUNTS = 4L;
    private static Long HOUSE_CONDITIONS = 5L;

    private Long id;
    private Integer version;
    private Long bitstate;
    private String realname;
    private String idnumber;
    private String phonenumber;
    private Integer authscore;
    private Long realauthid;
    private String email;

    private Systemdictionaryitem educationbackgroundItem;
    private Systemdictionaryitem incomegradeItem;
    private Systemdictionaryitem marriageItem;
    private Systemdictionaryitem kidcountItem;
    private Systemdictionaryitem houseconditionItem;

    private int usertype = 0;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Long getBitstate() {
        return bitstate;
    }
    public void setBitstate(Long bitstate) {
        this.bitstate = bitstate;
    }


    public String getRealname() {
        return realname;
    }
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }
    public String getIdnumber() {
        return idnumber;
    }
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }


    public Systemdictionaryitem getEducationbackgroundItem() {
        return educationbackgroundItem;
    }
    public void setEducationbackgroundItem(Systemdictionaryitem educationbackgroundItem) {
        this.educationbackgroundItem = educationbackgroundItem;
    }
    public Systemdictionaryitem getIncomegradeItem() {
        return incomegradeItem;
    }
    public void setIncomegradeItem(Systemdictionaryitem incomegradeItem) {
        this.incomegradeItem = incomegradeItem;
    }
    public Systemdictionaryitem getMarriageItem() {
        return marriageItem;
    }
    public void setMarriageItem(Systemdictionaryitem marriageItem) {
        this.marriageItem = marriageItem;
    }
    public Systemdictionaryitem getKidcountItem() {
        return kidcountItem;
    }
    public void setKidcountItem(Systemdictionaryitem kidcountItem) {
        this.kidcountItem = kidcountItem;
    }
    public Systemdictionaryitem getHouseconditionItem() {
        return houseconditionItem;
    }
    public void setHouseconditionItem(Systemdictionaryitem houseconditionItem) {
        this.houseconditionItem = houseconditionItem;
    }


    public Integer getAuthscore() {
        return authscore;
    }
    public void setAuthscore(Integer authscore) {
        this.authscore = authscore;
    }
    public Long getRealauthid() {
        return realauthid;
    }
    public void setRealauthid(Long realauthid) {
        this.realauthid = realauthid;
    }

    public void addState(Long state) {
        bitstate = BitStatesUtils.addState(bitstate, state);
    }

    // 移除状态码
    public void  removeState(Long state) {
        bitstate = BitStatesUtils.removeState(bitstate, state);
    }

    // 判断用户是否已经填写了基本资料
    public boolean getIsBasicInfo() {
        return BitStatesUtils.hasState(bitstate, BitStatesUtils.OP_USER_INFO);
    }

    // 判断是否已经绑定了手机
    public boolean getIsBindPhone() {
        return BitStatesUtils.hasState(this.bitstate,
                BitStatesUtils.OP_BIND_PHONE);
    }

    public boolean getIsBindEmail() {
        return BitStatesUtils.hasState(this.bitstate,
                BitStatesUtils.OP_BIND_EMAIL);
    }
    public boolean getHasBidRequestInProcess() {
        return BitStatesUtils.hasState(bitstate,
                BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
    }
}