package com.jt.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.jt.sportplay.bean.MainMenu;
import com.jt.sportplay.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author BXO
 * @version 1.0
 * @description: TODO
 * @date 2023/3/22 0:08
 */
@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @RequestMapping("menus")
    public String getAllMenu()
    {
        System.out.println("访问成功");
        HashMap<String, Object> data = new HashMap<>();
        int status = 404;//错误404，成功200
        List<MainMenu> menus = menuDao.getMenus();
        if(menus != null){
            data.put("menus",menus);
            data.put("flag",200);
        }else {
            data.put("flag",404);
        }
        String s = JSON.toJSONString(data);
        return s;

    }
}
