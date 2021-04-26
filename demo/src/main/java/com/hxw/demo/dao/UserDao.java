package com.hxw.demo.dao;

import com.hxw.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
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
     * 根据电话账号查询
     * @param phoneNum
     * @return
     */
    User getByPhoneNum(String phoneNum);


}
