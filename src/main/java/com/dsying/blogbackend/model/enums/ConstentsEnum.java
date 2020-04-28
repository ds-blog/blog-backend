package com.dsying.blogbackend.model.enums;

/**
 * 通用常量类
 */
public enum ConstentsEnum {
  SESSION_USER_INFO("userInfo"),
  SESSION_USER_PERMISSION("userPermission");

  private String key;

  ConstentsEnum(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
