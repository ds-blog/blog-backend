package com.dsying.blogbackend.model.dto;

import com.dsying.blogbackend.model.entity.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客分类
 */
public class TypeDto {
  private Integer id;
  private String name;
  private String description;
  private Integer parentId;
  private List<Blog> blogs = new ArrayList<>();

  public TypeDto() {}

}
