package com.example.oa.mapper;

import com.example.oa.entity.Diary;
import com.example.oa.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiaryMapper  extends BaseMapper {
    public List<Diary> findAll();
    public Integer updateById(@Param("id")Integer id, @Param("head")String head, @Param("content")String content);
    public Integer deleteById(Integer id);
}

