package com.dsying.blogbackend.global;

import com.dsying.blogbackend.model.enums.HttpResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(value = {"com.dsying.blogbackend.controller"})
public class ControllerExceptionHandler {
  private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

  /**
  * 处理参数校验异常
  * */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public BaseResponse<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
    ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
    return BaseResponse.result(HttpResultEnum.V_1001, objectError.getDefaultMessage());
  }

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
