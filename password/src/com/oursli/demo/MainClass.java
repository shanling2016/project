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
}
