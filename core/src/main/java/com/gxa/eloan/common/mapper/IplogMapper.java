package com.gxa.eloan.common.mapper;

import com.gxa.eloan.common.domain.Iplog;
import com.gxa.eloan.common.query.IplogQueryObject;

import java.util.List;

public interface IplogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Iplog record);

    Iplog selectByPrimaryKey(Long id);

    Iplog selectByUsername(String username);

    List<Iplog> selectAll();

    int updateByPrimaryKey(Iplog record);

    /**
     * 查询符合条件数据的数量
     *
     * @param iplogQueryObject
     * @return
     */
    int queryForCount(IplogQueryObject iplogQueryObject);


    /**
     * 查询当前页数据（分页查询）
     *
     * @param iplogQueryObject
     * @return
     */
    List<Iplog> query(IplogQueryObject iplogQueryObject);

}