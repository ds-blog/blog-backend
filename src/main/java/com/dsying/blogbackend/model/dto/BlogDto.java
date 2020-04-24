package com.dsying.blogbackend.model.dto;

import com.dsying.blogbackend.model.entity.Comment;
import com.dsying.blogbackend.model.entity.Tag;
import com.dsying.blogbackend.model.entity.Type;
import com.dsying.blogbackend.model.entity.User;
import com.dsying.blogbackend.model.enums.BlogStatus;

import java.util.Date;
import java.util.List;

/**
 * 博客对象
 */
public class BlogDto {
  // ID
  private Integer id;
  // 标题
  private String title;
  // 内容
  private String content;
  // 发表者ID
  private Integer userId;
  // 横幅图片
  private String banner;
  // 状态
  private BlogStatus status;
  // 浏览次数
  private Integer views;
  // 点赞量
  private Integer likeNum;
  // 是否开启赞赏
  private boolean appreciation;
  // 是否开启评论
  private boolean commentAble;
  // 创建时间
  private Date createTime;
  // 更新时间
  private Date updateTime;
  // 所属类型
  private Type type;
  // 所属标签
  private List<Tag> tags;
  // 所属用户
  private User user;
  // 下属评论
  private List<Comment> comments;
}
