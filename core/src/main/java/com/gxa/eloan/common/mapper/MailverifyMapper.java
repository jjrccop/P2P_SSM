package com.gxa.eloan.common.mapper;

import com.gxa.eloan.common.domain.Mailverify;
import java.util.List;

public interface MailverifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Mailverify record);

    Mailverify selectByPrimaryKey(Long id);

    Mailverify selectByUUID(String uuid);

    List<Mailverify> selectAll();

    int updateByPrimaryKey(Mailverify record);
}