package com.jt.sportplay.dao;

import com.jt.sportplay.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author BXO
 * @version 1.0
 * @description: TODO
 * @date 2023/3/21 23:14
 */
@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
