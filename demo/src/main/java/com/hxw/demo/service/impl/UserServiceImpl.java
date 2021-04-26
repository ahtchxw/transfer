package com.hxw.demo.service.impl;

import com.hxw.demo.bean.User;
import com.hxw.demo.dao.UserDao;
import com.hxw.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(User user) {
        String md5Str = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Str);
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(String id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public String login(User user) {
        try {
            User loginUser = userDao.getByPhoneNum(user.getPhoneNum());
            String md5Str = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            if (md5Str.equals(loginUser.getPassword())) {
                return "登录成功";
            } else {
                return "密码不正确";
            }
        } catch (Exception e) {
            System.out.println("账号不存在");
        }
        return "账号不存在";
    }

}
