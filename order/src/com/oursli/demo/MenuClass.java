package com.oursli.demo;

/**
 * Package:      com.oursli.demo
 * ClassName:    MenuClass
 * Description:  菜单抽象类
 * Datetime:     2020/3/12   4:15 下午
 * Author:       子文i
 */
public abstract class MenuClass {

    /**
     * 获取菜单的Id
     * @return int 菜单的Id
     */
    public abstract Integer getId();

    /**
     * 获取菜单名称
     * @return String 菜单名称
     */
    public abstract String getMenuName();

    /**
     * 当触发路由时，调用的方法
     * @return Boolean 是否拦截,如果返回 true 则停止运行,反之回显让用户重新选择菜单
     */
    public abstract Boolean Handle();
}
