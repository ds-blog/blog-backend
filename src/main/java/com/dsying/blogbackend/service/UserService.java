package com.dsying.blogbackend.service;

import com.dsying.blogbackend.model.entity.User;

public interface UserService {
  // 检查用户是否存在
  User checkUser(String username, String password);
}
