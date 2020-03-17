package com.oursli.game;

import java.util.Random;
import java.util.Scanner;

/**
 * Package:      com.oursli.game
 * ClassName:    MainClass
 * Description:  游戏启动类
 * Datetime:     2020/3/13   9:39 下午
 * Author:       子文i
 */
public class MainClass {
    public static void main(String[] args) {
        // 创建随机数种子
        Random rand = new Random();
        // 生成随机数
        int n = rand.nextInt(100) + 1;
        int m = 0;
        // 输出信息
        System.out.println("《猜数小游戏》");

        do {
            if (m != 0)
            {
                if (m > n)
                {
                    System.out.println("您猜大了！");
                }
                else if (n > m)
                {
                    System.out.println("您猜小了！");
                }
                else {
                    System.out.println("您猜对了！");
                }
            }
            System.out.print("请输入一个 1-100 的数字: ");
            // 创建输入流
            Scanner stream = new Scanner(System.in);
            // 读取
            String put = stream.nextLine();
            try {
                // 转换
                m = Integer.parseInt(put);
            }
            catch (Exception e)
            {
                System.out.println("<输入异常，请重新输入>");
            }
        }
        while(m == 0 || n != m);
        System.out.println(n);
    }
}
