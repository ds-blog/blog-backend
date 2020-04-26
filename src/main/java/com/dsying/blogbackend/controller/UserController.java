package com.dsying.blogbackend.controller;

import com.dsying.blogbackend.global.BaseResponse;
import com.dsying.blogbackend.model.entity.User;
import com.dsying.blogbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public BaseResponse<User> login(@RequestBody  User user) {
    User checkedUser = userService.checkUser(user.getUserName(), user.getPassword());
    return checkedUser != null ? BaseResponse.ok(checkedUser) : BaseResponse.ok("查无此用户");
  }

}
