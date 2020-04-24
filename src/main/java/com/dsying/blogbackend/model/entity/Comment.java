package com.dsying.blogbackend.model.entity;

import java.util.Date;

public class Comment {
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getBlogId() {
    return blogId;
  }

  public void setBlogId(Integer blogId) {
    this.blogId = blogId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getLikeNum() {
    return likeNum;
  }

  public void setLikeNum(Integer likeNum) {
    this.likeNum = likeNum;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "Comment{" +
            "id=" + id +
            ", blogId=" + blogId +
            ", userId=" + userId +
            ", avatar='" + avatar + '\'' +
            ", content='" + content + '\'' +
            ", likeNum=" + likeNum +
            ", parentId=" + parentId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }

  public static final class CommentBuilder {
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

    private CommentBuilder() {
    }

    public static CommentBuilder aComment() {
      return new CommentBuilder();
    }

    public CommentBuilder withId(Integer id) {
      this.id = id;
      return this;
    }

    public CommentBuilder withBlogId(Integer blogId) {
      this.blogId = blogId;
      return this;
    }

    public CommentBuilder withUserId(Integer userId) {
      this.userId = userId;
      return this;
    }

    public CommentBuilder withAvatar(String avatar) {
      this.avatar = avatar;
      return this;
    }

    public CommentBuilder withContent(String content) {
      this.content = content;
      return this;
    }

    public CommentBuilder withLikeNum(Integer likeNum) {
      this.likeNum = likeNum;
      return this;
    }

    public CommentBuilder withParentId(Integer parentId) {
      this.parentId = parentId;
      return this;
    }

    public CommentBuilder withCreateTime(Date createTime) {
      this.createTime = createTime;
      return this;
    }

    public CommentBuilder withUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    public CommentBuilder but() {
      return aComment().withId(id).withBlogId(blogId).withUserId(userId).withAvatar(avatar).withContent(content).withLikeNum(likeNum).withParentId(parentId).withCreateTime(createTime).withUpdateTime(updateTime);
    }

    public Comment build() {
      Comment comment = new Comment();
      comment.setId(id);
      comment.setBlogId(blogId);
      comment.setUserId(userId);
      comment.setAvatar(avatar);
      comment.setContent(content);
      comment.setLikeNum(likeNum);
      comment.setParentId(parentId);
      comment.setCreateTime(createTime);
      comment.setUpdateTime(updateTime);
      return comment;
    }
  }
}
