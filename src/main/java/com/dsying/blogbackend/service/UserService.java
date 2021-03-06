package com.dsying.blogbackend.service;

import com.dsying.blogbackend.global.BaseResponse;
import com.dsying.blogbackend.model.entity.User;
import com.dsying.blogbackend.model.params.LoginParam;
import org.apache.shiro.authc.UsernamePasswordToken;

public interface UserService {
  // 检查用户是否存在
  BaseResponse authLogin(LoginParam user);

  User findUserByUserName(String userName);
}
