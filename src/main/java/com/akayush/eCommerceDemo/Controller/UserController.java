package com.akayush.eCommerceDemo.Controller;
import com.akayush.eCommerceDemo.DTO.LoginDto;
import com.akayush.eCommerceDemo.DTO.UserDto;
import com.akayush.eCommerceDemo.Model.User;
import com.akayush.eCommerceDemo.service.ForUser.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User registerUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return userService.loginUser(loginDto);
    }
}
