package com.jt.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.jt.sportplay.bean.QueryInfo;
import com.jt.sportplay.bean.User;
import com.jt.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
//        System.out.println(res_string);
        return res_string;
    }

    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id")Integer id,@RequestParam("state")Boolean state){
        int i = userDao.updateState(id, state);
        return i>0?"success":"error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);

        return i>0?"success":"error";
    }
}
