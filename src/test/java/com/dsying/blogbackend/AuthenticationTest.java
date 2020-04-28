package com.dsying.blogbackend;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * shiro 认证测试
 */
public class AuthenticationTest {
  SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

  /**
   * 预先创建个账户
   */
  @BeforeEach
  public void addUser() {
    simpleAccountRealm.addAccount("dsying", "123456", "admin", "user");
  }

  @Test
  public void testAuthentication() {
    // 1 构建SecurityManager环境
    DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager(simpleAccountRealm);

    // 2 主题提交认证请求
    SecurityUtils.setSecurityManager(defaultSecurityManager); // 设置SecurityManager环境
    Subject subject = SecurityUtils.getSubject();// 获取当前主题

    UsernamePasswordToken token = new UsernamePasswordToken("dsying", "123456");
    subject.login(token); // 登录

    Assertions.assertTrue(subject.isAuthenticated());

    subject.checkRole("admin");// 断言 当前用户拥有 admin角色
    Assertions.assertThrows(UnauthorizedException.class, () ->  subject.checkRole("test"));// 断言当前用户没有 test角色

    subject.logout(); // 登出
    Assertions.assertFalse(subject.isAuthenticated());

  }
}
