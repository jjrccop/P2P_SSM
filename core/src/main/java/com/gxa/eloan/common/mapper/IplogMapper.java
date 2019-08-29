package com.gxa.eloan.common.mapper;

import com.gxa.eloan.common.domain.Iplog;
import java.util.List;

public interface IplogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Iplog record);

    Iplog selectByPrimaryKey(Long id);

    Iplog selectByUsername(String username);

    List<Iplog> selectAll();

    int updateByPrimaryKey(Iplog record);
}