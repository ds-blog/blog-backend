package com.dsying.blogbackend.service;

import com.dsying.blogbackend.dao.UserMapper;
import com.dsying.blogbackend.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  UserMapper userMapper;

  public List<User> getAll() {
    return userMapper.getAll();
  }
}
