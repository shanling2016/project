package com.oursli.demo.menu;

import com.oursli.demo.DataUtil;
import com.oursli.demo.MenuClass;

import java.util.Scanner;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    DeleteOrder
 * Description:  删除订单 菜单处理类
 * Datetime:     2020/3/12   6:10 下午
 * Author:       子文i
 */
public class DeleteOrder extends MenuClass {

    @Override
    public String getMenuName() {
        return "删除订单";
    }

    @Override
    public Boolean Handle() {
        System.out.println("*** 删除订单 ***");
        // 获取姓名
        // 此处存在待改进待坑，对用户输入对数据进行Sql过滤
        while (true)
        {
            try
            {
                System.out.print("请输入要删除的订单序号(id)：");
                Integer id = new Scanner(System.in).nextInt();
                if (!DataUtil.orderExis(id))
                {
                    System.out.println("抱歉，您输入的订单序号不存在！");
                    if (this.Tips())
                        return false;
                }
                if (!DataUtil.getOrderStatus(id))
                {
                    System.out.println("抱歉，您输入的订单没有签收，不能删除！");
                    if (this.Tips())
                        return false;
                }
                if (DataUtil.deleteOrder(id))
                {
                    System.out.println("订单删除成功!");
                    if (this.Tips())
                        return false;
                }
                else
                {
                    System.out.println("抱歉，订单删除失败!");
                    if (this.Tips())
                        return false;
                }
                break;
            }
            catch (Exception e)
            {
                System.out.println("您输入的序号格式不正确！");
                continue;
            }
        }
        return true;
    }
}
