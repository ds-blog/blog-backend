package com.dsying.blogbackend.model.entity;

import com.dsying.blogbackend.model.enums.BlogStatus;

import java.util.Date;

/**
 * 博客实体类
 */
public class Blog {
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


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getBanner() {
    return banner;
  }

  public void setBanner(String banner) {
    this.banner = banner;
  }

  public BlogStatus getStatus() {
    return status;
  }

  public void setStatus(BlogStatus status) {
    this.status = status;
  }

  public Integer getViews() {
    return views;
  }

  public void setViews(Integer views) {
    this.views = views;
  }

  public Integer getLikeNum() {
    return likeNum;
  }

  public void setLikeNum(Integer likeNum) {
    this.likeNum = likeNum;
  }

  public boolean isAppreciation() {
    return appreciation;
  }

  public void setAppreciation(boolean appreciation) {
    this.appreciation = appreciation;
  }

  public boolean isCommentAble() {
    return commentAble;
  }

  public void setCommentAble(boolean commentAble) {
    this.commentAble = commentAble;
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
    return "Blog{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", userId=" + userId +
            ", banner='" + banner + '\'' +
            ", status=" + status +
            ", views=" + views +
            ", likeNum=" + likeNum +
            ", appreciation=" + appreciation +
            ", commentAble=" + commentAble +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }

  /**
   * Blog类的Builder
   */
  public static final class BlogBuilder {
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

    private BlogBuilder() {
    }

    public static BlogBuilder aBlog() {
      return new BlogBuilder();
    }

    public BlogBuilder withId(Integer id) {
      this.id = id;
      return this;
    }

    public BlogBuilder withTitle(String title) {
      this.title = title;
      return this;
    }

    public BlogBuilder withContent(String content) {
      this.content = content;
      return this;
    }

    public BlogBuilder withUserId(Integer userId) {
      this.userId = userId;
      return this;
    }

    public BlogBuilder withBanner(String banner) {
      this.banner = banner;
      return this;
    }

    public BlogBuilder withStatus(BlogStatus status) {
      this.status = status;
      return this;
    }

    public BlogBuilder withViews(Integer views) {
      this.views = views;
      return this;
    }

    public BlogBuilder withLikeNum(Integer likeNum) {
      this.likeNum = likeNum;
      return this;
    }

    public BlogBuilder withAppreciation(boolean appreciation) {
      this.appreciation = appreciation;
      return this;
    }

    public BlogBuilder withCommentAble(boolean commentAble) {
      this.commentAble = commentAble;
      return this;
    }

    public BlogBuilder withCreateTime(Date createTime) {
      this.createTime = createTime;
      return this;
    }

    public BlogBuilder withUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    public Blog build() {
      Blog blog = new Blog();
      blog.setId(id);
      blog.setTitle(title);
      blog.setContent(content);
      blog.setUserId(userId);
      blog.setBanner(banner);
      blog.setStatus(status);
      blog.setViews(views);
      blog.setLikeNum(likeNum);
      blog.setAppreciation(appreciation);
      blog.setCommentAble(commentAble);
      blog.setCreateTime(createTime);
      blog.setUpdateTime(updateTime);
      return blog;
    }
  }
}
