package com.akayush.eCommerceDemo.service.ForUser;
import com.akayush.eCommerceDemo.DTO.LoginDto;
import com.akayush.eCommerceDemo.DTO.UserDto;
import com.akayush.eCommerceDemo.Model.User;
import com.akayush.eCommerceDemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUser(UserDto userDto){
        User user=new User();
        user.setUsername(userDto.getUsername());
        user.setMobilenumber(userDto.getMobilenumber());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }
    @Override
    public String loginUser(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());

        if (user != null && user.getPassword().equals(loginDto.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials";
        }
    }
}
