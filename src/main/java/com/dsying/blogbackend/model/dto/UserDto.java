package com.dsying.blogbackend.model.dto;

import com.dsying.blogbackend.model.entity.Blog;

import java.util.Date;
import java.util.List;

/**
 * 用户
 */
public class UserDto {
  // ID
  private Integer id;
  // 昵称
  private String nickName;
  // 用户名
  private String userName;
  // 密码
  private String password;
  // 邮箱
  private String email;
  // 手机号
  private String phone;
  // 头像
  private String avatar;
  // 用户类型
  private Integer type;
  // 创建时间
  private Date createTime;
  // 更新时间
  private Date updateTime;
  // 用户所有博客
  private List<Blog> blogs;

  public UserDto() {}
}
