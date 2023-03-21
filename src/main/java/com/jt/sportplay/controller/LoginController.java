package com.jt.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.jt.sportplay.bean.User;
import com.jt.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author BXO
 * @version 1.0
 * @description: TODO
 * @date 2023/3/20 15:40
 */
@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/test")
    public String test()
    {
        return "ok";
    }

    @RequestMapping("/login")
    public String login(@RequestBody  User user){
        String flag = "error";
        System.out.println(user);
        User userByMassage = userDao.getUserByMassage(user.getUsername(), user.getPassword());
        System.out.println(userByMassage);
        HashMap<String, Object> res = new HashMap<>();
        if(userByMassage!=null){
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user",user);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}
