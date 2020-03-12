package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    LikeSystem
 * Description:  我要点赞 菜单处理类
 * Datetime:     2020/3/12   6:10 下午
 * Author:       子文i
 */
public class LikeSystem extends MenuClass {
    @Override
    public String getMenuName() {
        return "我要点赞";
    }

    @Override
    public Boolean Handle() {
        this.Out("您选择了我要点赞菜单！");
        return true;
    }
}
