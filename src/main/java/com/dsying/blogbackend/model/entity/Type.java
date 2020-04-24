package com.dsying.blogbackend.model.entity;

public class Type {
  private Integer id;
  private String name;
  private String description;
  private Integer parentId;

  public Type() {}

  public Type(Integer id, String name, String description, Integer parentId) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.parentId = parentId;
  }

  @Override
  public String toString() {
    return "Type{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", parentId=" + parentId +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }
}
