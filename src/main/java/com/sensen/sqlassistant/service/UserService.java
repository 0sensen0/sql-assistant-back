package com.sensen.sqlassistant.service;

import com.sensen.sqlassistant.dao.UserDao;
import com.sensen.sqlassistant.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int login(String userId){
        int exist = userDao.exist(userId);
        if (exist < 1) {
            User user = new User();
            user.setUserId(userId);
            userDao.save(user);
        }
        return exist;
    }
}
