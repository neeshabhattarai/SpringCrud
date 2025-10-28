package com.example.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.test.pojo.User;

@Repository
public interface userCrud extends CrudRepository<User, String> {
    public List<User> findByUserName(String userName);
}
