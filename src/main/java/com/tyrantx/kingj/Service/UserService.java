package com.tyrantx.kingj.Service;


import com.tyrantx.kingj.Pojo.User;

import java.util.List;

public interface UserService {

    public List<User> queryAllUers();

    public User queryUserByName(String username);

    public void createUser(String username, String password);
}
