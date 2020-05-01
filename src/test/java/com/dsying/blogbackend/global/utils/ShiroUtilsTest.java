package com.dsying.blogbackend.global.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;


class ShiroUtilsTest {
  SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
  String userName = "admin";
  String password = "123456";

  /**
   * 预先创建个账户
   */
  @BeforeEach
  public void addUser() {
    System.out.println("beforeEach addUser -->");
    simpleAccountRealm.addAccount(userName, password, "admin", "user");
  }

  @Test
  void testShiroUtils() {
    // 1 构建SecurityManager环境
    DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager(simpleAccountRealm);

    // 2 主题提交认证请求
    SecurityUtils.setSecurityManager(defaultSecurityManager); // 设置SecurityManager环境
    Subject subject = SecurityUtils.getSubject();// 获取当前主题

    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
    subject.login(token); // 登录


    System.out.println("getSession -->");
    Session session = ShiroUtils.getSession();
    System.out.println(session.getId());

    Serializable sessionId = new ShiroSessionIdGenerator().generateId(session);
    System.out.println(sessionId);

  }
}
