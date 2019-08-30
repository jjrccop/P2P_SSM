package com.gxa.eloan.business.service;

import com.gxa.eloan.business.domain.Bidrequest;
import com.gxa.eloan.business.domain.Bidrequestaudithistory;
import com.gxa.eloan.business.query.BidRequestQueryObject;
import com.gxa.eloan.common.domain.UserInfo;
import com.gxa.eloan.common.query.PageResultSet;

import java.util.List;

public interface IBidrequestService {
    boolean canApply(UserInfo userInfo);
    void apply(Bidrequest bidRequestVo);
    PageResultSet queryForPage(BidRequestQueryObject bidRequestQueryObject);
    void publishAudit(Long id, String remark, Byte state);
    void update(Bidrequest bidRequest);
    Bidrequest getBidRequest(Long id);
    List<Bidrequestaudithistory> listAuditHistorayByBidRequest(Long id);
    List<Bidrequest> queryForList(BidRequestQueryObject bidRequestQueryObject);
}
