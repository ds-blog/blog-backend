package com.dsying.blogbackend.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

public abstract class AbstractBlogException extends RuntimeException {
  private Object errorData;

  public AbstractBlogException(String message) {
    super(message);
  }

  public AbstractBlogException(String message, Throwable cause) {
    super(message, cause);
  }

  public Object getErrorData() {
    return errorData;
  }

  public AbstractBlogException setErrorData(Object errorData) {
    this.errorData = errorData;
    return this;
  }

  @NonNull
  public abstract HttpStatus getStatus();
}
