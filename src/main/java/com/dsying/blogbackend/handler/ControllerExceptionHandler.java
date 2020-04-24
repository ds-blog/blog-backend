package com.dsying.blogbackend.handler;

import com.dsying.blogbackend.entity.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(value = {"com.dsying.blogbackend.controller"})
public class ControllerExceptionHandler {
  private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse handleGlobalException(Exception e) {
    BaseResponse baseResponse = handleBaseException(e);
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    baseResponse.setStatus(status.value());
    baseResponse.setMessage(status.getReasonPhrase());
    return baseResponse;
  }

  private static <T> BaseResponse<T> handleBaseException(Throwable e) {
    logger.error("捕获异常: ", e);
    BaseResponse<T> baseResponse = new BaseResponse<T>();
    baseResponse.setMessage(e.getMessage());
    return baseResponse;
  }
}
