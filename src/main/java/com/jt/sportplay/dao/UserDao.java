package com.jt.sportplay.dao;

import com.jt.sportplay.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author BXO
 * @version 1.0
 * @description: TODO
 * @date 2023/3/21 17:21
 */

@Repository
public interface UserDao {

    public User getUserByMassage(@Param("username") String username,@Param("password") String password);
    public List<User> getAllUser(@Param("username")String username,@Param("pageStart")int PageStart,@Param("pageSize")int pageSize);
    public int getUserCounts(@Param("username")String username);
}
