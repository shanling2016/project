package com.oursli.demo;

import java.util.Scanner;

/**
 * Package:      com.oursli.demo
 * ClassName:    MainClass
 * Description:  描述
 * Datetime:     2020/3/17   11:43 下午
 * Author:       子文i
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.print("请输入你要示例的题目编号(1-3): ");
        Scanner stream = new Scanner(System.in);
        switch (stream.nextLine())
        {
            case "1":
                sub1();
                break;
            case "2":
                sub2();
                break;
            case "3":
                sub3();
                break;
            default:
                System.out.println("你输入的编号有误或不存在，程序自动结束！");
                break;
        }
    }

    /**
     * 题目一
     */
    public static void sub1() {
        // 重试次数变量
        int n = 0;
        // 循环判断
        while (n < 3) {
            // 提示输入
            System.out.print("请输入密码(123)：");
            Scanner stream = new Scanner(System.in);
            // 判断密码是否错误
            if (!"123".equals(stream.nextLine()))
            {
                n++;
                if (n == 3)
                {
                    System.out.println("登陆失败！");
                }
                else
                {
                    System.out.printf("您输入的密码不正确， 您还有 %d 次重试机会!\n", 3 - n);
                    continue;
                }
            }
            else
            {
                System.out.println("密码正确，登陆成功！");
                break;
            }

        }
    }

    /**
     * 题目二
     */
    public static void sub2() {
        for (int x = 0; x <= 100; x++)
        {
            // 判断是否满足条件
            if (x % 3 == 2 && x % 5 == 3 && x % 7 == 2) {
                System.out.printf("这个数为 %d", x);
                break;
            }
        }
    }

    /**
     * 题目三
     */
    public static void sub3() {
        // 提示输入
        System.out.print("请输入要颠倒的数字：");
        Scanner stream = new Scanner(System.in);
        try {
            // 要颠倒的数字
            int n = stream.nextInt();
            // 判断是否是十以内数
            if (n >= 10) {
                // 各位数数组
                StringBuffer res = new StringBuffer();
                // 求余法
                while (n >= 1) {
                    int d = n % 10;
                    res.append(d);
                    n /= 10;
                }
                System.out.printf("颠倒后的结果为 %s", res);
            }
            else
            {
                // 直接返回， 避免计算
                System.out.printf("颠倒后的结果为 %d", n);
            }
        }
        catch (Exception e)
        {
            System.out.println("您的输入有误，程序自动退出!");
        }
    }
}
