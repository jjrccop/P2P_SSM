package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.Iplog;
import com.gxa.eloan.common.mapper.IplogMapper;
import com.gxa.eloan.common.service.IIpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpLogServiceImpl implements IIpLogService {
    @Autowired
    private IplogMapper iplogMapper;

    public void add(Iplog iplog){
        iplogMapper.insert(iplog);
    }

    public Iplog getCurrentIplog(String username){
        Iplog iplog = iplogMapper.selectByUsername(username).get(0);
        return iplog;
    }
}
