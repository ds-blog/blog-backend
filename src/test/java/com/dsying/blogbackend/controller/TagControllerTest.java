package com.dsying.blogbackend.controller;

import com.dsying.blogbackend.model.params.TagParam;
import com.dsying.blogbackend.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.ResultMatcher.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 标签接口测试
 */
@WebMvcTest(TagController.class)
class TagControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TagService tagService;

  @Test
  void listTags() {

  }

  @Test
  void createTag() throws Exception {
    TagParam tagParam = new TagParam("java", "springboot");
    String requestBody = "{\"name\":\"java\", \"description\":\"springboot\"}";
    mockMvc.perform(post("/admin/tags")
            .with(user("dingsheng"))
            .contentType(MediaType.APPLICATION_JSON).content(requestBody))
            .andExpect(matchAll(
            status().isOk()
    ));
  }

  @Test
  void getTagById() {
  }

  @Test
  void updateById() {
  }

  @Test
  void deleteById() {
  }
}
