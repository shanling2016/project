package com.oursli.demo.menu;

import com.oursli.demo.DataUtil;
import com.oursli.demo.MenuClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    OrderFood
 * Description:  订餐菜单类
 * Datetime:     2020/3/12   4:24 下午
 * Author:       子文i
 */
public class OrderFood extends MenuClass {

    @Override
    public String getMenuName() {
        return "我要订餐";
    }

    @Override
    public Boolean Handle() {
        System.out.println("*** 我要订餐 ***");
        // 获取菜单
        ResultSet res = DataUtil.getDish();
        // 异常判断
        if (res == null)
        {
            System.out.println("error: 获取菜单失败！");
            System.out.print("(按下回车返回主菜单)");
            Scanner stream = new Scanner(System.in);
            stream.nextLine();
            return false;
        }
        // 获取姓名
        // 此处存在待改进待坑，对用户输入对数据进行Sql过滤
        System.out.print("请输入订餐人姓名：");
        String name = new Scanner(System.in).nextLine();
        // 读取数据以表的形式生成
        try {
            System.out.println("----------------------------------------------");
            System.out.println("| 序号(id) |     菜名     |   单价  ｜  点赞数  |");
            System.out.println("----------------------------------------------");

            while (res.next())
            {
                System.out.printf(
                        "| %7d | %-9s | %7.2f | %7d |\n",
                        res.getInt("id"),
                        res.getString("name"),
                        res.getDouble("price"),
                        res.getInt("like")
                );
            }
            System.out.println("----------------------------------------------");
        }
        catch (Exception e)
        {
            System.out.println("error: 获取菜单失败！");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.print("(按下回车返回主菜单)");
            new Scanner(System.in).nextLine();
            return false;
        }
        // 订餐变量
        int id, number, date;
        String address;

        // 防输入异常循环检测
        while (true)
        {
            try
            {
                System.out.print("请选择您要点的菜品序号(id)：");
                id = new Scanner(System.in).nextInt();
                if (!DataUtil.dishExis(id))
                {
                    System.out.println("菜单编号对应的菜品不存在!");
                    throw new RuntimeException();
                }
                System.out.print("请选择您需要的份数：");
                number = new Scanner(System.in).nextInt();
                System.out.print("请输入送餐时间(10 - 20 整点送餐)：");
                date = new Scanner(System.in).nextInt();
                if (date > 20 || date < 10)
                    throw new RuntimeException("时间不在规定范围!");
                System.out.print("请输入送餐地址：");
                address = new Scanner(System.in).nextLine();
                break;
            }
            catch (Exception e)
            {
                System.out.println("抱歉，您的输入有误，请重新输入！");
                System.out.print("(按下回车开始重新输入)");
                new Scanner(System.in).nextLine();
                continue;
            }
        }
        // 创建订单
        if (DataUtil.createOrder(id, number, name, date, address))
        {
            System.out.println("订餐成功！");
            if (this.Tips())
                return false;
        }
        else
        {
            System.out.println("抱歉，订餐失败，请返回主菜单重试！");
            System.out.print("(按下回车返回主菜单)");
            new Scanner(System.in).nextLine();
            return false;
        }
        return true;
    }
}
