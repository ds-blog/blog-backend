package com.dsying.blogbackend.model.dto;

import com.dsying.blogbackend.model.entity.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客标签
 */
public class TagDto {
  private Integer id;
  private String name;
  private String description;
  private List<Blog> blogs = new ArrayList<>();

  public TagDto() {}

}
