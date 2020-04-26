package com.dsying.blogbackend.dao;

import com.dsying.blogbackend.model.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
  User findUserByUserNameAndPassword(String username, String password);
}
