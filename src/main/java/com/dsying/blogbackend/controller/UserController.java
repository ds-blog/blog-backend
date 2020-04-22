package com.dsying.blogbackend.controller;

import com.dsying.blogbackend.entity.BaseResponse;
import com.dsying.blogbackend.entity.User;
import com.dsying.blogbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  @ResponseBody
  public List<User> getAll() {
    return userService.getAll();
  }

  @RequestMapping(value = "/all2", method = RequestMethod.GET)
  @ResponseBody
  public BaseResponse<List<User>> getAll2() {
    return BaseResponse.ok(userService.getAll());
  }
}
