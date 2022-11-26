package com.example.haskellsprinblog.services;


import com.example.haskellsprinblog.models.User;
import com.example.haskellsprinblog.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserService {



    private final UserRepository userDao;

    public UserService( UserRepository userDao) {
        this.userDao = userDao;

    }

    public User findById(long id){
        Optional<User> user = userDao.findById(id);
       return user.orElse(null);
    }

}
