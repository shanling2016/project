package com.oursli.demo.menu;

import com.oursli.demo.MenuClass;

import java.util.Scanner;

/**
 * Package:      com.oursli.demo.menu
 * ClassName:    SingCal
 * Description:  单用户计算 菜单处理类
 * Datetime:     2020/3/13   5:53 下午
 * Author:       子文i
 */
public class SingCal extends MenuClass {
    @Override
    public String getMenuName() {
        return "单个用户租金计算";
    }

    @Override
    public Boolean Handle() {
        while (true)
        {
            // 永远不要相信用户输入的数据是否安全
            // 数据输入异常检测
            try {
                Scanner stream = new Scanner(System.in);
                this.Out("请输入用户姓名：");
                String name = stream.nextLine();
                this.Out("请输入求租用户性别(true or false，true表示男，false表示女)：");
                boolean gender = stream.nextBoolean();
                this.Out("请输入房屋出租费用：");
                Double price1 = stream.nextDouble();
                this.Out("请输入物业费用：");
                Float price2 = stream.nextFloat();
                this.Out("请输入其他费用：");
                Integer price3 = stream.nextInt();

                this.Outln("-----------------------");
                this.Outln("用户姓名：" + name);
                this.Outln("用户性别：" + (gender ? "男" : "女"));
                this.Out("租金：");
                this.Outln(price1 + price2 + price3);
                this.Outln("-----------------------");
                break;
            }
            catch (Exception e)
            {
                this.Outln("输入有误，请重新输入！\n");
            }
        }
        this.Put();
        return false;
    }
}
