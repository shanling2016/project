package com.oursli.demo.menu;

import com.oursli.demo.DataUtil;
import com.oursli.demo.MenuClass;

import java.sql.ResultSet;
import java.util.Scanner;

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
        System.out.println("*** 我要点赞 ***");
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
        while (true) {
            try {
                System.out.print("请输入要点赞菜品序号(id)：");
                Integer id = new Scanner(System.in).nextInt();
                if (!DataUtil.dishExis(id))
                {
                    System.out.println("抱歉，您输入的序号不存在！");
                    continue;
                }
                System.out.print("请输入您的姓名：");
                String name = new Scanner(System.in).nextLine();
                if (DataUtil.isLike(id, name))
                {
                    System.out.println("抱歉，您已经为此菜品点赞过了！！");
                    if (this.Tips())
                        return false;
                }
                if (DataUtil.likeDish(id, name))
                    System.out.println("点赞成功!");
                else
                    System.out.println("抱歉，点赞失败!");
                if (this.Tips())
                    return false;
                break;
            } catch (Exception e) {
                System.out.println("您输入的序号格式不正确！");
                continue;
            }
        }
        return true;
    }
}
