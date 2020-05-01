package com.dsying.blogbackend.global.utils;

import com.dsying.blogbackend.model.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;

public class ShiroUtils {
  // 加密方式
  private static final String ALGORITHM_MD5 = "md5";
  // 加密循环次数
  private static final int  HASH_ITERATIONS = 2;

  private ShiroUtils() {
  }

  /**
   * 获取当前用户Session
   * @return
   */
  public static Session getSession() {
    return SecurityUtils.getSubject().getSession();
  }

  /**
   * 用户登出
   */
  public static void logout() {
    SecurityUtils.getSubject().logout();
  }

  /**
   * 获取用户信息
   * @return
   */
  public static User getUserInfo() {
    return (User)SecurityUtils.getSubject().getPrincipal();
  }

  /**
   * MD5加密
   * @param input
   * @param salt
   * @return
   */
  public static String md5Encryption(String input, String salt) {
    return new SimpleHash(ALGORITHM_MD5, input, salt, HASH_ITERATIONS).toString();
  }
}
