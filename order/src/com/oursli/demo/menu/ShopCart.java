package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    ShopCart
 * Description:  查看餐袋 菜单处理类
 * Datetime:     2020/3/12   6:09 下午
 * Author:       子文i
 */
public class ShopCart extends MenuClass {
    @Override
    public String getMenuName() {
        return "查看餐袋";
    }

    @Override
    public Boolean Handle() {
        this.Out("您选择了查看餐袋菜单！");
        return true;
    }
}
