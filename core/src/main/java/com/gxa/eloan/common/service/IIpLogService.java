package com.gxa.eloan.common.service;

import com.gxa.eloan.common.domain.Iplog;
import com.gxa.eloan.common.query.IplogQueryObject;
import com.gxa.eloan.common.query.PageResultSet;

public interface IIpLogService {
    void add(Iplog iplog);
    Iplog getCurrentIplog(String username);

    /**
     * 分页查询
     *
     * @param iplogQueryObject
     * @return
     */
    PageResultSet query(IplogQueryObject iplogQueryObject);

}
