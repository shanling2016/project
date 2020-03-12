package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    SignOrder
 * Description:  签收订单 菜单处理类
 * Datetime:     2020/3/12   6:09 下午
 * Author:       子文i
 */
public class SignOrder extends MenuClass {
    @Override
    public String getMenuName() {
        return "签收订单";
    }

    @Override
    public Boolean Handle() {
        this.Out("您选择了签收订单菜单！");
        return true;
    }
}
