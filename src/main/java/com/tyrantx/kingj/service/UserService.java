package com.tyrantx.kingj.service;


import com.tyrantx.kingj.domain.User;

import java.util.List;

public interface UserService {

    public List<User> queryAllUers();

    public User queryUserByName(String username);

    public void createUser(String username, String password);
}
