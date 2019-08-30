package com.gxa.eloan.business.mapper;

import com.gxa.eloan.business.domain.Bidrequestaudithistory;
import java.util.List;

public interface BidrequestaudithistoryMapper {
    /**
     * 新增对借款的申请审核记录
     *
     * @param record
     * @return
     */
    int insert(Bidrequestaudithistory record);

    /**
     * 列出一个借款申请 相关的所有审核记录
     *
     * @param id
     * @return
     */
    List<Bidrequestaudithistory> listAuditHistorayByBidRequest(Long id);
}