package com.dsying.blogbackend.service;

import com.dsying.blogbackend.model.entity.Tag;
import com.dsying.blogbackend.model.params.TagParam;

import java.util.List;

public interface TagService {
  List<Tag> listTags();

  int createTag(TagParam tagParam);

  Tag getById(Integer id);

  int updateById(Integer id, TagParam tagParam);

  int deleteById(Integer id);

}
