package com.dsying.blogbackend.controller;

import com.dsying.blogbackend.global.BaseResponse;
import com.dsying.blogbackend.model.entity.Tag;
import com.dsying.blogbackend.model.params.TagParam;
import com.dsying.blogbackend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/tags")
public class TagController {

  @Autowired
  TagService tagService;

  @GetMapping
  public BaseResponse<List<Tag>> listTags() {
    return BaseResponse.ok(tagService.listTags());
  }

  @PostMapping
  public BaseResponse<String> createTag(@RequestBody @Valid TagParam tagParam) {
    tagService.createTag(tagParam);
    return BaseResponse.ok("标签新增成功");
  }

  @GetMapping(value = "{:id}")
  public BaseResponse<Tag> getTagById(@PathVariable("id") Integer id) {
    return BaseResponse.ok(tagService.getById(id));
  }

  @PutMapping(value = "{:id}")
  public BaseResponse<Tag> updateById(@PathVariable("id") Integer id) {
    return BaseResponse.ok(tagService.updateById(id));
  }

  @DeleteMapping(value = "{:id}")
  public BaseResponse<Tag> deleteById(@PathVariable("id") Integer id) {
    return BaseResponse.ok(tagService.deleteById(id));
  }
}
