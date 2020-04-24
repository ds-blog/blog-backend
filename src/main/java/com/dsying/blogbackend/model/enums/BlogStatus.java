package com.dsying.blogbackend.model.enums;

/**
 * 博客状态
 */
public enum BlogStatus {
  /**
   * 发布
   */
  PUBLISHED(0),
  /**
   * 草稿
   */
  DRAFT(1),
  /**
   * 回收
   */
  RECYCLE(2);

  private int value;

  BlogStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
