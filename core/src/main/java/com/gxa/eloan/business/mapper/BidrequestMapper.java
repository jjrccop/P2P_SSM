package com.gxa.eloan.business.mapper;

import com.gxa.eloan.business.domain.Bidrequest;
import com.gxa.eloan.business.query.BidRequestQueryObject;

import java.util.List;

public interface BidrequestMapper {
    int insert(Bidrequest record);

    int queryForCount(BidRequestQueryObject bidRequestQueryObject);

    List<Bidrequest> queryForList(BidRequestQueryObject bidRequestQueryObject);

    Bidrequest selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Bidrequest record);
}