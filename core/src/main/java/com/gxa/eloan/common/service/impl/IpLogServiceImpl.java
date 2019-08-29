package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.Iplog;
import com.gxa.eloan.common.mapper.IplogMapper;
import com.gxa.eloan.common.query.IplogQueryObject;
import com.gxa.eloan.common.query.PageResultSet;
import com.gxa.eloan.common.service.IIpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpLogServiceImpl implements IIpLogService {
    @Autowired
    private IplogMapper iplogMapper;

    public void add(Iplog iplog){
        iplogMapper.insert(iplog);
    }

    public Iplog getCurrentIplog(String username){
        Iplog iplog = iplogMapper.selectByUsername(username);
        return iplog;
    }

    @Override
    public PageResultSet query(IplogQueryObject iplogQueryObject) {

        int count = iplogMapper.queryForCount(iplogQueryObject);

        PageResultSet pageResultSet;
        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据;没有则返回空的数据集
        if (count > 0) {
            List<Iplog> list = iplogMapper.query(iplogQueryObject);
            pageResultSet = new PageResultSet(
                    list,
                    count,
                    iplogQueryObject.getCurrentPage(),
                    iplogQueryObject.getPageSize());
        }else{
            pageResultSet = PageResultSet.empty(iplogQueryObject.getPageSize());
        }

        return pageResultSet;
    }

}
