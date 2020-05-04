package com.dsying.blogbackend.service;

import com.dsying.blogbackend.model.entity.Tag;
import com.dsying.blogbackend.model.params.TagParam;

import java.util.List;

public interface TagService {
  List<Tag> listTags();

  int createTag(TagParam tagParam);

  Tag getById(Integer id);

  Tag updateById(Integer id);

  Tag deleteById(Integer id);

  int countByName(String name);
}
