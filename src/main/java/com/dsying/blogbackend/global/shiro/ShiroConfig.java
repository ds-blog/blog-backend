package com.dsying.blogbackend.global.shiro;

import com.dsying.blogbackend.global.utils.ShiroSessionIdGenerator;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ShiroConfig {
  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(securityManager);

    Map<String, Filter> filterMap = new LinkedHashMap<>();
    filterMap.put("authc", new AjaxPermissionsAuthorizationFilter());
    shiroFilterFactoryBean.setFilters(filterMap);

    /* 拦截器. 定义shiro过滤链  Map结构
     * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
     * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
     * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
     */
    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
    // 配置不会被拦截的链接 顺序判断
    filterChainDefinitionMap.put("/", "anon");
    filterChainDefinitionMap.put("/static/**", "anon");
    filterChainDefinitionMap.put("/admin/login", "anon");
    // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
    filterChainDefinitionMap.put("/admin/logout", "anon");
    // 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
    // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
    filterChainDefinitionMap.put("/error", "anon");
    filterChainDefinitionMap.put("/**", "authc");

    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return shiroFilterFactoryBean;
  }

  /**
   * 凭证匹配器
   * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
   *
   * @return
   */
  @Bean
  public HashedCredentialsMatcher hashedCredentialsMatcher() {
    HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
    //散列算法:这里使用MD5算法;
    hashedCredentialsMatcher.setHashAlgorithmName("md5");
    // 散列的次数，比如散列两次，相当于 md5(md5(""));
    hashedCredentialsMatcher.setHashIterations(2);
    return hashedCredentialsMatcher;
  }

  @Bean
  public ShiroRealm ShiroRealm() {
    ShiroRealm myShiroRealm = new ShiroRealm();
    myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
    return myShiroRealm;
  }


  @Bean
  public SecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    // 自定义Ssession管理
    securityManager.setSessionManager(new ShiroSessionManager());
    // 自定义Realm验证
    securityManager.setRealm(ShiroRealm());
    return securityManager;
  }

  /**
   * SessionID生成器
   * @return
   */
  @Bean
  public ShiroSessionIdGenerator sessionIdGenerator(){
    return new ShiroSessionIdGenerator();
  }

  /**
   * 开启shiro aop注解支持.
   * 使用代理方式;所以需要开启代码支持;
   *
   * @param securityManager
   * @return
   */
  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }

  @Bean(name = "simpleMappingExceptionResolver")
  public SimpleMappingExceptionResolver
  createSimpleMappingExceptionResolver() {
    SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
    Properties mappings = new Properties();
    mappings.setProperty("DatabaseException", "databaseError"); // 数据库异常处理
    mappings.setProperty("UnauthorizedException", "403");
    r.setExceptionMappings(mappings);  // None by default
    r.setDefaultErrorView("error");    // No default
    r.setExceptionAttribute("ex");     // Default is "exception"
    //r.setWarnLogCategory("example.MvcLogger");     // No default
    return r;
  }
}
