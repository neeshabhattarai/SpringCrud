package com.example.test.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.test.pojo.User;
import com.example.test.repository.userCrud;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class userService {
    @Autowired
    private userCrud userCrud;
    @Autowired
    private PasswordEncoder encoder;

    // private userService(userCrud userCrud) {
    // this.userCrud = userCrud;
    // }

    public int saveUser(User user) {
        user.setRole("ROLE_ADMIN");
        Object userSave = userCrud.save(user);
        if (userSave.getClass().getName().length() > 0) {
            return 1;
        }
        return 0;
    }

    public int updateForm(User user, HttpSession session) {
        User userUpdate = (User) session.getAttribute("user");
        log.info(userUpdate.toString());
        userUpdate.setRole(user.getRole());
        userUpdate.setPassword(encoder.encode(user.getPassword()));
        // userUpdate.setUserName(user.getUserName());

        User userSave = userCrud.save(userUpdate);
        if (userSave.getClass().getName().length() > 1) {
            return 1;
        }
        return 0;
    }

    public List<User> allUser() {
        Iterable<User> userList = userCrud.findAll();
        List<User> users = StreamSupport.stream(userList.spliterator(), false).collect(Collectors.toList());
        return users;
    }

    public void deleteUser(String name) {
        userCrud.deleteById(name);
    }

}
