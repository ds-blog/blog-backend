package com.dsying.blogbackend.controller;

import com.dsying.blogbackend.model.entity.User;
import com.dsying.blogbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private UserService userService;

  @Test
  void checkUser() throws Exception {
    String username = "dingsheng";
    String password = "19920115asd";
    User alex = User.UserBuilder.anUser()
            .withUserName(username)
            .withPassword(password)
            .build();
//    given(userService.checkUser(username, password)).willReturn(alex);

    MvcResult mvcResult = mockMvc.perform(get("/admin/login").queryParam("username", username).queryParam("password", password))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn();
    String contentAsString = mvcResult.getResponse().getContentAsString();
    System.out.println(contentAsString);
  }
}
