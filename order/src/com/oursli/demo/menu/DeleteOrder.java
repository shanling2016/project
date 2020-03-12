package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    DeleteOrder
 * Description:  删除订单 菜单处理类
 * Datetime:     2020/3/12   6:10 下午
 * Author:       子文i
 */
public class DeleteOrder extends MenuClass {
    @Override
    public String getMenuName() {
        return "删除订单";
    }

    @Override
    public Boolean Handle() {
        this.Out("您选择了删除订单菜单！");
        return true;
    }
}
