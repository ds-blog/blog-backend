package com.dsying.blogbackend.controller;

import com.dsying.blogbackend.global.BaseResponse;
import com.dsying.blogbackend.global.jwt.JwtTokenUtil;
import com.dsying.blogbackend.model.entity.User;
import com.dsying.blogbackend.model.params.LoginParam;
import com.dsying.blogbackend.service.UserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/admin")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping(value = "/login")
  public BaseResponse login(@RequestBody @Valid LoginParam user) {
    return userService.authLogin(user);
  }
}
