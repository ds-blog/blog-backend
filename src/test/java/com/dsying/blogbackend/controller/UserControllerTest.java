package com.dsying.blogbackend.controller;

import com.dsying.blogbackend.dao.UserMapper;
import com.dsying.blogbackend.entity.User;
import com.dsying.blogbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
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
  void getAll() throws Exception {
    User alex = new User(2, "dsying", 27);
    List<User> allUsers = Arrays.asList(alex);
    given(userService.getAll()).willReturn(allUsers);

    MvcResult mvcResult = mockMvc.perform(get("/user/all"))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn();
    String contentAsString = mvcResult.getResponse().getContentAsString();
    System.out.println(contentAsString);
  }
}
