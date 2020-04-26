package com.dsying.blogbackend.service.impl;

import com.dsying.blogbackend.dao.UserMapper;
import com.dsying.blogbackend.model.entity.User;
import com.dsying.blogbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserMapper userMapper;

  public User checkUser(String username, String password) {
    return userMapper.findUserByUserNameAndPassword(username, password);
  }
}
