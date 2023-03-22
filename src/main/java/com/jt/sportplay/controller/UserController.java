package com.jt.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.jt.sportplay.bean.QueryInfo;
import com.jt.sportplay.bean.User;
import com.jt.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author BXO
 * @version 1.0
 * @description: 用户管理
 * @date 2023/3/22 17:19
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        int numbers = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("unumbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);

        return res_string;
    }
}
