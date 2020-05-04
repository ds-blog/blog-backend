package com.dsying.blogbackend.dao;

import com.dsying.blogbackend.model.entity.Tag;
import com.dsying.blogbackend.model.params.TagParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
  List<Tag> listTags();

  int createTag(TagParam tagParam);

  Tag getById(Integer id);

  Tag updateById(Integer id);

  Tag deleteById(Integer id);

  int countByName(String name);
}
