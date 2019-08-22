package com.gxa.eloan.common.service;

import com.gxa.eloan.common.domain.Systemdictionaryitem;

import java.util.List;

public interface ISystemdictionaryitemService {
    List<Systemdictionaryitem> getItemList(Long parentId);
}
