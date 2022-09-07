package com.alper.couponear.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private  UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(){
        return  userRepository.findAll();
    }
}
