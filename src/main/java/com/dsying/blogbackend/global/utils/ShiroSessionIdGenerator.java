package com.dsying.blogbackend.global.utils;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

public class ShiroSessionIdGenerator implements SessionIdGenerator {

  /**
   * 实现SessionId生成
   * @param session
   * @return
   */
  @Override
  public Serializable generateId(Session session) {
    Serializable sessionId = new JavaUuidSessionIdGenerator().generateId(session);
    return String.format("token_%s", sessionId);
  }
}
