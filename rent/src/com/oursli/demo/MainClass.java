package com.oursli.demo;

import com.oursli.demo.menu.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Package:      com.oursli.demo
 * ClassName:    MainClass
 * Description:  房屋租金计算程序 - mini
 * Datetime:     2020/3/13   4:08 下午
 * Author:       子文i
 */
public class MainClass {
    public static void main(String[] args)
    {
        // 借用HashMap作为路由表
        HashMap<Integer, MenuClass> route = new HashMap<>();

        // 填充菜单
        genMenu(route);

        // 保存菜单
        String menuStr = genMenuString(route);

        // 创建
        Scanner stream = new Scanner(System.in);

        while(true)
        {
            int n = 0;
            // 输出菜单文本
            System.out.println(menuStr);
            // 要求输入
            do {
                // 要求输入
                System.out.printf("%s", "请输入菜单功能选项：");

                // 读取
                String put = stream.nextLine();
                try {
                    // 转换
                    n = Integer.parseInt(put);
                }
                catch (Exception e) {
                    System.out.println("<输入异常，请重新输入>");
                }
            }
            while (n == 0);
            // 路由匹配
            MenuClass em = route.get(n);
            // 匹配异常判断
            try
            {
                if(em.Handle())
                    break;
            }
            catch (Exception e)
            {
                System.out.println("您输入的菜单不存在！(请回车重新输入)");
                stream.nextLine();
            }
            // 清屏
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        }

    }

    /**
     * 填充路由菜单
     * @param menu 初始化后的HashMap; 传引用
     */
    public static void genMenu(HashMap<Integer, MenuClass> menu)
    {
        menu.put(1, new UserChoice());
        menu.put(2, new SingCal());
        menu.put(3, new ManyCal());
        menu.put(4, new ExitSystem());
    }

    public static String genMenuString(HashMap<Integer, MenuClass> menu)
    {
        Integer sized = menu.size();
        // 空菜单判断
        if (sized.equals(0))
            return new String("");
        // 创建字符串
        StringBuffer temp = new StringBuffer();
        // 写入数据
        temp.append("欢迎使用房屋租赁租金计算程序\n");
        temp.append("选择进行的操作类型：");
        // 遍历HashMap
        menu.forEach((k, v) -> {
            temp.append(k);
            temp.append("、");
            temp.append(v.getMenuName());
            temp.append(" ");
        });
        // 返回
        return temp.toString();
    }
}
