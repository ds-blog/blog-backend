package com.dsying.blogbackend.dao;

import com.dsying.blogbackend.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
  List<User> getAll();
}