package com.example.oa.service;

import com.example.oa.entity.Notice;
import com.example.oa.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public List<Notice> FindAll(){
       return noticeMapper.findAll();
    }

    public Notice selectByPrimaryKey(Long id){
        return noticeMapper.selectByPrimaryKey(id);
    }
    public Integer updateById(Integer id,String head,String content){
        return noticeMapper.updateById(id,head,content);
    }
    public Integer deleteById(Integer id){
        return  noticeMapper.deleteById(id);
    }
    public  Integer insert(Notice notice){
        return noticeMapper.insert(notice);
    }

}
