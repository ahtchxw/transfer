package com.hxw.demo.service;

import com.hxw.demo.bean.Record;
import com.hxw.demo.bean.User;

import java.util.List;

public interface UserService {

    /**
     * 插入
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteUser(String id);

    /**
     * 查询
     * @return
     */
    List<User> getUsers();

    /**
     * 更新
     * @param user
     * @return
     */
    int updateUser(User user);


    /**
     * 登录
     * @param user
     * @return
     */
    String login(User user);

}
