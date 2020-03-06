package com.oursli.demo;

/**
 * Package:      com.oursli.demo
 * ClassName:    CommElement
 * Description:  商品元素类
 * Datetime:     2020/3/6   10:50 上午
 * Author:       子文i
 */
public class CommElement {

    public CommElement(String Names, String Sizes, Float Prices, String Configs, Integer Numbers)
    {
        this.setName(Names);
        this.setSize(Sizes);
        this.setPrice(Prices);
        this.setConfig(Configs);
        this.setNumber(Numbers);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    // 品牌型号
    private String Name;

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    // 尺寸
    private String Size;

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    // 价格
    private Float Price;

    public String getConfig() {
        return Config;
    }

    public void setConfig(String config) {
        Config = config;
    }

    // 配置
    private String Config;

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    // 库存
    private Integer Number;
}
