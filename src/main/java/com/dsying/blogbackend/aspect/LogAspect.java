package com.dsying.blogbackend.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * AOP定义切面
 */
@Aspect
@Component
public class LogAspect {
  private static Logger logger = LoggerFactory.getLogger(LogAspect.class);
  // 定义切点
  @Pointcut("execution(* com.dsying.blogbackend.controller..*.*(..))")
  public void log() {}

  @Before("log()")
  public void doBefore(JoinPoint joinPoint) {
    // 开始打印请求日志
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    // 打印请求相关参数
    logger.info("==================== Start ======================");
    // 打印请求 url
    logger.info("URL            : {}", request.getRequestURL().toString());
    // 打印 Http method
    logger.info("HTTP Method    : {}", request.getMethod());
    // 打印调用 controller 的全路径以及执行方法
    logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    // 打印请求的 IP
    logger.info("IP             : {}", request.getRemoteAddr());
    // 打印请求入参
    logger.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));

  }

  @After("log()")
  public void doAfter() {
    logger.info("==================== End ======================");
    // 每个请求之间空一行
    logger.info("");
  }

  // 环绕通知 用于记录耗时
  @Around("log()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    Object result = proceedingJoinPoint.proceed();
    // 打印出参
    logger.info("Response Args  : {}", new Gson().toJson(result));
    // 执行耗时
    logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
    return result;
  }
}
