package com.oursli.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Package:      com.oursli.demo
 * ClassName:    MainClass
 * Description:  商品库存清单 - mini
 * Datetime:     2020/3/6   10:28 上午
 * Author:       子文i
 */
public class MainClass {

    public static void main(String[] args)
    {
        // 初始化变量内存空间
        List<CommElement> list = new ArrayList<>();
        // 填充数据
        FillTable(list);
        // 打印数据
        OutTable(list);
    }

    /**
     * 填充数据到变量
     * @param f
     */
    public static void FillTable(List<CommElement> f)
    {
        f.add(new CommElement(
                "Macbook Air",
                "13.3",
                8899.00f,
                "双核八代i5-8G Ram-128Gb SSD",
                6));
        f.add(new CommElement(
                "Macbook Pro",
                "13.3",
                999.00f,
                "四核八代i5-8G Ram-128Gb SSD",
                3));
        f.add(new CommElement(
                "iMac",
                "21.5",
                8390.00f,
                "双核七代i5-8G Ram-1Tb HHD",
                8));
        f.add(new CommElement(
                "MateBook",
                "14",
                5888.00f,
                "四核十代i5-16G Ram-512Gb SSD",
                11));
    }

    /**
     * 打印表格内的数据
     * @param d 要打印的数据
     */
    public static void OutTable(List<CommElement> d)
    {
        Integer i = 0;
        Float p = 0.00f;
        System.out.println("------------------------------------------库存清单------------------------------------------");
        System.out.printf("| %-15s | %4s | %8s | %-38s |%s|\n", "品牌型号", "尺寸", "价格", "配置", "库存数");
        for (CommElement demo : d)
        {
            Integer t = demo.getNumber();
            Float tp = demo.getPrice();
            i += t;
            p += (tp * t);
            System.out.printf("| %-18s | %5s | %10.2f | %-36s | %3d |\n", demo.getName(), demo.getSize(), tp, demo.getConfig(), t);
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("总库存数：%d\n", i);
        System.out.printf("总金额数：%.2f\n", p);
    }
}

