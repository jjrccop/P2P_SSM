package com.gxa.eloan.business.domain;

import com.gxa.eloan.common.domain.LoginInfo;

import java.util.Date;

public class Bidrequestaudithistory {

    public static final Byte PUBLISH_AUDIT = 0; //发标审核
    public static final Byte FULL_AUDIT1 = 1; //满标一审
    public static final Byte FULL_AUDIT2 = 2; //满标二审

    public static final Byte STATE_NORMAL = 0; // 待审核
    public static final Byte STATE_AUDIT = 1; // 审核通过
    public static final Byte STATE_REJECT = 2; // 审核拒绝

    private Long id;

    private Byte state;

    private String remark;

    private Date audittime;

    private Date applytime;

    private LoginInfo applier; // 申请人

    private LoginInfo auditor;// 审核人

    private Long bidrequestid;

    private Byte audittype;

//    public String getAuditTypeDisplay() {
//        switch (this.audittype) {
//            case PUBLISH_AUDIT:
//                return "发标审核";
//            case FULL_AUDIT1:
//                return "满标一审";
//            case FULL_AUDIT2:
//                return "满标二审";
//            default:
//                return "";
//        }
//    }

    public LoginInfo getApplier() {
        return applier;
    }

    public void setApplier(LoginInfo applier) {
        this.applier = applier;
    }

    public LoginInfo getAuditor() {
        return auditor;
    }

    public void setAuditor(LoginInfo auditor) {
        this.auditor = auditor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Long getBidrequestid() {
        return bidrequestid;
    }

    public void setBidrequestid(Long bidrequestid) {
        this.bidrequestid = bidrequestid;
    }

    public Byte getAudittype() {
        return audittype;
    }

    public void setAudittype(Byte audittype) {
        this.audittype = audittype;
    }
}