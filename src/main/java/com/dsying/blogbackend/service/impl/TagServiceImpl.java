package com.dsying.blogbackend.service.impl;

import com.dsying.blogbackend.dao.TagMapper;
import com.dsying.blogbackend.global.exception.AlreadyExistsException;
import com.dsying.blogbackend.model.entity.Tag;
import com.dsying.blogbackend.model.params.TagParam;
import com.dsying.blogbackend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TagServiceImpl implements TagService {
  @Autowired
  TagMapper tagMapper;


  @Override
  public List<Tag> listTags() {
    return tagMapper.listTags();
  }

  @Override
  public int createTag(TagParam tagParam) {
    // 检查标签是否存在
    int count  = tagMapper.countByName(tagParam.getName());
    if(count > 0) {
      // 如果标签已存在
      throw new AlreadyExistsException("标签已存在").setErrorData(tagParam);
    }

    return tagMapper.createTag(tagParam);
  }

  @Override
  public Tag getById(Integer id) {
    return tagMapper.getById(id);
  }

  @Override
  public Tag updateById(Integer id) {
    return tagMapper.updateById(id);
  }

  @Override
  public Tag deleteById(Integer id) {
    return tagMapper.deleteById(id);
  }

  @Override
  public int countByName(String name) {
    return tagMapper.countByName(name);
  }
}
