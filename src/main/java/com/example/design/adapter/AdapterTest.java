package com.example.design.adapter;

/**
 * 适配器模式
 */
public class AdapterTest {
    public static void main(String[] args) {

    }
}

/**
 * 适配器模式 - 适配器类 - 适配器类继承了被适配类，同时实现标准接口
 */
class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}

/**
 * 适配器模式 - 被适配类 - 被适配类是一个已经存在并已经实现了的类，被适配类一般是一个接口，但是也可能是抽象类或者具体类
 */
class Adaptee {
    public void specificRequest() {
        System.out.println("被适配类具有 特殊功能...");
    }
}


/**
 * 适配器模式 - 标准接口 - 标准接口是客户端所期待的接口
 */

interface Target {
    void request();
}
