package com.dsying.blogbackend.global;

import com.dsying.blogbackend.global.exception.AbstractBlogException;
import com.dsying.blogbackend.model.enums.HttpResultEnum;
import org.springframework.http.HttpStatus;

/**
 * 全局统一Response
 * @param <T>
 */
public class BaseResponse<T> {
  /**
   * 响应状态码
   */
  private Integer status;
  /**
   * 响应信息
   */
  private String message;
  /**
   * 响应数据
   */
  private T data;

  @Override
  public String toString() {
    return "BaseResponse{" +
            "status=" + status +
            ", message='" + message + '\'' +
            ", data=" + data +
            '}';
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public BaseResponse() {
  }

  public BaseResponse(Integer status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  /**
   * create an result with HttpResultEnum and data
   * @param httpResultEnum
   * @param data
   * @param <T>
   * @return
   */
  public static <T> BaseResponse<T> result(HttpResultEnum httpResultEnum, T data) {
    return new BaseResponse<>(httpResultEnum.getCode(), httpResultEnum.getMessage(), data);
  }

  public static <T> BaseResponse<T> result(AbstractBlogException e) {
    return new BaseResponse<T>(e.getStatus().value(), e.getMessage(), (T) e.getErrorData());
  }

  /**
   * create an ok result with message and data
   * @param message
   * @param data
   * @param <T>
   * @return
   */
  public static <T> BaseResponse<T> ok(String message, T data) {
    return new BaseResponse<>(HttpStatus.OK.value(), message, data);
  }

  /**
   * create an ok result with message only
   * @param message
   * @param <T>
   * @return
   */
  public static <T> BaseResponse<T> ok(String message) {
    return ok(message, null);
  }

  /**
   * create an ok result with data only
   * @param data
   * @param <T>
   * @return
   */
  public static <T> BaseResponse<T> ok(T data) {
    return ok(HttpStatus.OK.getReasonPhrase(), data);
  }
}
