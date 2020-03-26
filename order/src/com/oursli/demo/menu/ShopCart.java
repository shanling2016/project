package com.oursli.demo.menu;

import com.oursli.demo.DataUtil;
import com.oursli.demo.MenuClass;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    ShopCart
 * Description:  查看餐袋 菜单处理类
 * Datetime:     2020/3/12   6:09 下午
 * Author:       子文i
 */
public class ShopCart extends MenuClass {

    @Override
    public String getMenuName() {
        return "查看餐袋";
    }

    @Override
    public Boolean Handle() {
        System.out.println("*** 查看餐袋 ***");
        // 获取订单
        ResultSet res = DataUtil.getOrder();
        // 异常判断
        if (res == null)
        {
            System.out.println("error: 获取餐袋失败！");
            System.out.print("(按下回车返回主菜单)");
            Scanner stream = new Scanner(System.in);
            stream.nextLine();
            return false;
        }
        // 读取数据以表的形式生成
        try {
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("| 序号(id) |   订餐人   |     餐品信息     |  送餐时间  |     送餐地点      |   总金额  ｜ 订单状态 |");
            System.out.println("---------------------------------------------------------------------------------------------");
            // 数据处理工具类
            Formatter fmt = new Formatter();
            while (res.next())
            {
                ResultSet rs = DataUtil.getDishInfo(res.getInt("cid"));
                if (rs == null || !rs.next())
                    continue;
                System.out.printf(
                        "| %-7d | %8s | %11s | %-7d点 | %-13s | %-8.2f | %6s |\n",
                        res.getInt("id"),
                        res.getString("name"),
                        fmt.format(
                                "%s %d份",
                                rs.getString("name"),
                                res.getInt("number")
                        ),
                        res.getInt("del_time"),
                        res.getString("del_address"),
                        res.getDouble("price"),
                        res.getBoolean("status") ? "已完成" : "已预定"

                );
                //res.getDouble("price")
            }
            System.out.println("---------------------------------------------------------------------------------------------");
        }
        catch (Exception e)
        {
            System.out.println("error: 获取餐袋失败！");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.print("(按下回车返回主菜单)");
            new Scanner(System.in).nextLine();
        }
        if (this.Tips())
            return false;
        return true;
    }
}
