package com.dsying.blogbackend.model.entity;

import java.util.Date;

public class User {
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

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", nickName='" + nickName + '\'' +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", avatar='" + avatar + '\'' +
            ", type=" + type +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public static final class UserBuilder {
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

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
      return new UserBuilder();
    }

    public UserBuilder withId(Integer id) {
      this.id = id;
      return this;
    }

    public UserBuilder withNickName(String nickName) {
      this.nickName = nickName;
      return this;
    }

    public UserBuilder withUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public UserBuilder withPassword(String password) {
      this.password = password;
      return this;
    }

    public UserBuilder withEmail(String email) {
      this.email = email;
      return this;
    }

    public UserBuilder withPhone(String phone) {
      this.phone = phone;
      return this;
    }

    public UserBuilder withAvatar(String avatar) {
      this.avatar = avatar;
      return this;
    }

    public UserBuilder withType(Integer type) {
      this.type = type;
      return this;
    }

    public UserBuilder withCreateTime(Date createTime) {
      this.createTime = createTime;
      return this;
    }

    public UserBuilder withUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    public UserBuilder but() {
      return anUser().withId(id).withNickName(nickName).withUserName(userName).withPassword(password).withEmail(email).withPhone(phone).withAvatar(avatar).withType(type).withCreateTime(createTime).withUpdateTime(updateTime);
    }

    public User build() {
      User user = new User();
      user.setId(id);
      user.setNickName(nickName);
      user.setUserName(userName);
      user.setPassword(password);
      user.setEmail(email);
      user.setPhone(phone);
      user.setAvatar(avatar);
      user.setType(type);
      user.setCreateTime(createTime);
      user.setUpdateTime(updateTime);
      return user;
    }
  }
}
