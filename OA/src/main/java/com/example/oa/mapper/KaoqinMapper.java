package com.example.oa.mapper;

import com.example.oa.entity.Kaoqin;
import com.example.oa.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KaoqinMapper extends BaseMapper {

    public List<Kaoqin> findAll();
    public Kaoqin selectByUsername(String username);
}
