package com.example.oa.util;

import java.util.List;

public interface BaseMapper<T, PK> {
    int deleteByPrimaryKey(PK id);

    int insert(T record);

    T selectByPrimaryKey(PK id);

    List<T> selectAll();

    int updateByPrimaryKey(T record);
}
