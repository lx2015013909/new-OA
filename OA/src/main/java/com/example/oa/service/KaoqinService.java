package com.example.oa.service;

import com.example.oa.entity.Kaoqin;
import com.example.oa.exception.RecordAlreadyExistsException;
import com.example.oa.mapper.KaoqinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaoqinService {

    @Autowired
    private KaoqinMapper kaoqinMapper;

    public List<Kaoqin> findAll(){
        return  kaoqinMapper.findAll();
    }
    public  int insert(Kaoqin kaoqin)  {
        if (kaoqinMapper.selectByUsername(kaoqin.getUsername())!=null)
        {
            return 1;
        }
        return kaoqinMapper.insert(kaoqin);
    }
}
