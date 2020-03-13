package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    UserChoice
 * Description:  用户类型选择 菜单处理类
 * Datetime:     2020/3/13   4:11 下午
 * Author:       子文i
 */
public class UserChoice extends MenuClass {
    @Override
    public String getMenuName() {
        return "用户类型选择";
    }

    @Override
    public Boolean Handle() {
        this.Out("请输入你的用户类型：");
        String type = this.Put();
        this.Outln("你的用户类型是 " + type);
        this.Put();
        return false;
    }
}
