package com.example.oa.service;

import com.example.oa.entity.Diary;
import com.example.oa.mapper.DiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    public  List<Diary> findAll(){
        return  diaryMapper.findAll();
    }
    public Diary selectByPrimaryKey(Long id){
        return (Diary) diaryMapper.selectByPrimaryKey(id);
    }
    public Integer updateById(Integer id,String head,String content){
        return diaryMapper.updateById(id,head,content);
    }
    public Integer deleteById(Integer id){
        return  diaryMapper.deleteById(id);
    }
    public  Integer insert(Diary notice){
        return diaryMapper.insert(notice);
    }
}
