package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    ExitSystem
 * Description:  退出系统 菜单处理类
 * Datetime:     2020/3/12   6:10 下午
 * Author:       子文i
 */
public class ExitSystem extends MenuClass {
    @Override
    public String getMenuName() {
        return "退出系统";
    }

    @Override
    public Boolean Handle() {
        return true;
    }
}
