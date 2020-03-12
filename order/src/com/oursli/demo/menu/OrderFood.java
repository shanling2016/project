package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    OrderFood
 * Description:  订餐菜单类
 * Datetime:     2020/3/12   4:24 下午
 * Author:       子文i
 */
public class OrderFood extends MenuClass {

    @Override
    public String getMenuName() {
        return "我要点餐";
    }

    @Override
    public Boolean Handle() {
        this.Out("您选择了点餐菜单！");
        return true;
    }
}
