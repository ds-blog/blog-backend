package com.dsying.blogbackend.model.params;

import com.dsying.blogbackend.model.entity.Tag;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TagParam {
  @NotBlank(message = "标签名称不能为空")
  @Size(max = 255, message = "标签名称长度不能超过 {max}")
  private String name;

  @Size(max = 255, message = "标签描述的长度不能超过 {max}")
  private String description;

  public TagParam() {}

  public TagParam(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public static Tag convertTo(Integer id, TagParam tagParam) {
    return new Tag(id, tagParam.getName(), tagParam.getDescription());
  }

  public static Tag convertTo(TagParam tagParam) {
    return new Tag(tagParam.getName(), tagParam.getDescription());
  }
}
