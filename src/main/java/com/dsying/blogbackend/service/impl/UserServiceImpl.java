package com.dsying.blogbackend.service.impl;

import com.dsying.blogbackend.dao.UserMapper;
import com.dsying.blogbackend.global.BaseResponse;
import com.dsying.blogbackend.global.utils.ShiroUtils;
import com.dsying.blogbackend.model.entity.User;
import com.dsying.blogbackend.model.params.LoginParam;
import com.dsying.blogbackend.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserMapper userMapper;

  public BaseResponse authLogin(LoginParam user) {
    String username = user.getUserName();
    String password = user.getPassword();
    Subject currentUser = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(username, password);
    try {
      currentUser.login(token);
      return BaseResponse.ok("登录成功", ShiroUtils.getSession().getId().toString());
    } catch(AuthenticationException e) {
      return BaseResponse.ok("登录失败");
    }
  }

  @Override
  public User findUserByUserName(String userName) {
    return userMapper.findUserByUserName(userName);
  }
}
