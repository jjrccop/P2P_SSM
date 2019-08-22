package com.gxa.eloan.common.mapper;

import com.gxa.eloan.common.domain.Systemdictionary;
import java.util.List;

public interface SystemdictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemdictionary record);

    Systemdictionary selectByPrimaryKey(Long id);

    List<Systemdictionary> selectAll();

    int updateByPrimaryKey(Systemdictionary record);
}