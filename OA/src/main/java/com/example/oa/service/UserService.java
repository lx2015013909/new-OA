package com.example.oa.service;

import com.example.oa.entity.User;
import com.example.oa.exception.RecordAlreadyExistsException;
import com.example.oa.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectByAll(String username,String password) throws Exception {
      if (userMapper.selectByAll(username,password)==null)
      {
          throw new RecordAlreadyExistsException("用户名或密码错误", "/");
      }

        return  userMapper.selectByAll(username,password);
    }
    public Integer insert(User user) throws RecordAlreadyExistsException {
        if(userMapper.selectByUsername(user.getUsername())!=null){
            throw new RecordAlreadyExistsException("用户名已存在!", "/");
        }
        Integer i=userMapper.insert(user);
        return i;
    }

    public Integer update(User user) throws RecordAlreadyExistsException {
        if(userMapper.selectByUsername(user.getUsername())==null){
            throw new RecordAlreadyExistsException("用户名不存在!", "/");
        }
        Integer i=userMapper.updateByUsername(user.getUsername(),user.getPassword());
        return  i;
    }
    public List<User> findAll(){
       return userMapper.selectAll();
    }
}
