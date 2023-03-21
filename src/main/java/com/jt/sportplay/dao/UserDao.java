package com.jt.sportplay.dao;

import com.jt.sportplay.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author BXO
 * @version 1.0
 * @description: TODO
 * @date 2023/3/21 17:21
 */

@Repository
public interface UserDao {

    public User getUserByMassage(@Param("username") String username,@Param("password") String password);
}
