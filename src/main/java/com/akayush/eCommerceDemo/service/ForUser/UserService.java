package com.akayush.eCommerceDemo.service.ForUser;

import com.akayush.eCommerceDemo.DTO.LoginDto;
import com.akayush.eCommerceDemo.DTO.UserDto;
import com.akayush.eCommerceDemo.Model.User;

public interface UserService {
    User registerUser(UserDto userDto);
    String loginUser(LoginDto loginDto);
}
