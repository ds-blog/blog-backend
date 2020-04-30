package com.dsying.blogbackend.global.shiro;

import com.dsying.blogbackend.model.entity.User;
import com.dsying.blogbackend.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
  @Autowired
  private UserService userService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    return null;
  }

  /**
   * 认证
   * UserController.login()方法中执行Subject.login()时 执行此方法
   * @param authenticationToken 主体subject传过来的认证信息
   * @return
   * @throws AuthenticationException
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    // 1 从主题闯过来的认证信息中，获得用户名
    String userName = (String) authenticationToken.getPrincipal();
    // 2 通过用户名到数据库中获取用户信息
    User user = userService.findUserByUserName(userName);

    if(user == null) {
      // 没找到账号
      throw new UnknownAccountException();
    }
    // 获取盐值，即用户名
    ByteSource salt = ByteSource.Util.bytes(userName);
    return new SimpleAuthenticationInfo(
            user,
            user.getPassword(),
            salt,
            getName()
    );
  }

  public static void main(String[] args) {
    String password = "19920115asd";
    String salt = "dingsheng";
    String encodePassword = new SimpleHash("md5", password, salt, 2).toString();
    System.out.println(encodePassword);
  }
}
