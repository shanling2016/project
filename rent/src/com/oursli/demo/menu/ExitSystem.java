package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    ExitSystem
 * Description:  描述
 * Datetime:     2020/3/13   5:55 下午
 * Author:       子文i
 */
public class ExitSystem extends MenuClass {
    @Override
    public String getMenuName() {
        return "退出";
    }

    @Override
    public Boolean Handle() {
        return true;
    }
}
