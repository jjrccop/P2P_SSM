package com.gxa.eloan.common.service;

import com.gxa.eloan.common.domain.Iplog;

public interface IIpLogService {
    void add(Iplog iplog);
    Iplog getCurrentIplog(String username);
}
