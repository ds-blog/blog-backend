package com.dsying.blogbackend.global.shiro;

import com.alibaba.fastjson.JSONObject;
import com.dsying.blogbackend.global.BaseResponse;
import com.dsying.blogbackend.model.enums.HttpResultEnum;
import com.google.gson.JsonObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *  对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
 */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
    JSONObject result = new JSONObject();
    result.put("status", HttpResultEnum.E_20011.getCode());
    result.put("message", HttpResultEnum.E_20011.getMessage());
    PrintWriter out = null;
    HttpServletResponse res = (HttpServletResponse) response;
    try {
      res.setCharacterEncoding("UTF-8");
      res.setContentType("application/json");
      out = response.getWriter();
      out.println(result);
    } catch (Exception e) {
    } finally {
      if (null != out) {
        out.flush();
        out.close();
      }
    }
    return false;
  }

  @Bean
  public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
    FilterRegistrationBean registration = new FilterRegistrationBean(filter);
    registration.setEnabled(false);
    return registration;
  }

}
