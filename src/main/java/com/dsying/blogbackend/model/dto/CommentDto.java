package com.dsying.blogbackend.model.dto;

import com.dsying.blogbackend.model.entity.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客评论
 */
public class CommentDto {
  // ID
  private Integer id;
  // 所属博客ID
  private Integer blogId;
  // 评论者ID
  private Integer userId;
  // 头像
  private String avatar;
  // 评论内容
  private String content;
  // 点赞数
  private Integer likeNum;
  // 父评论ID
  private Integer parentId;
  // 评论时间
  private Date createTime;
  // 更新时间
  private Date updateTime;
  // 所属博客
  private BlogDto blog;
  // 评论下属评论(自关联)
  private List<Comment> replyComments = new ArrayList<>();
  // 父节点评论
  private CommentDto parentComment;

  public CommentDto() {}

}
