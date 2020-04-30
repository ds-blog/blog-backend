package com.dsying.blogbackend.model.params;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginParam {
  @NotBlank(message = "用户名不能为空")
  @Size(max = 255, message = "用户名的字符长度不能超过 {max}")
  private String userName;

  @NotBlank(message = "登录密码不能为空")
  @Size(max = 100, message = "用户密码的字符长度不能超过 {max}")
  private String password;

  public LoginParam(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
