package com.oursli.demo;

import java.util.Scanner;

/**
 * Package:      com.oursli.demo
 * ClassName:    MenuClass
 * Description:  菜单抽象类
 * Datetime:     2020/3/12   4:15 下午
 * Author:       子文i
 */
public abstract class MenuClass {

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

    /**
     * 向屏幕打印数据
     * @param s 要打印的数据
     */
    public <T> void Out(T s) {
        System.out.println(s);
    }

    public String Put() {
        // 创建
        Scanner stream = new Scanner(System.in);
        // 返回
        return stream.nextLine();
    }

    /**
     * 向控制台输出提示
     * @return 若用户输入y则返回true,如果输入n则返回false
     */
    public Boolean Tips()
    {
        String action = null;
        while (true)
        {
            System.out.print("是否返回主菜单? (y/n)：");
            action = new Scanner(System.in).nextLine();
            if (action.equals("y") || action.equals("n"))
                break;
        }
        if (action.equals("y"))
            return true;
        return false;
    }
}
