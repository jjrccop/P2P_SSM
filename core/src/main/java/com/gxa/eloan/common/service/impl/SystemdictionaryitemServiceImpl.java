package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.Systemdictionaryitem;
import com.gxa.eloan.common.mapper.SystemdictionaryitemMapper;
import com.gxa.eloan.common.service.ISystemdictionaryitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemdictionaryitemServiceImpl implements ISystemdictionaryitemService {
    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;

    public List<Systemdictionaryitem> getItemList(Long parentId){
        return systemdictionaryitemMapper.selectByParentId(parentId);
    }
}
