package com.dailycodebuffer.user.controller;

import VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

   @PostMapping("/")
   public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
   }

   @GetMapping("/{id}")
   public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long id){
       return userService.getUserWithDepartment(id);
   }

}
