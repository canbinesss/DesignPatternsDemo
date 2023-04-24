package com.example.design.hungrySingleton;

/**
 * 饿汉式单例
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).start();

    }
}

/**
 * 饿汉
 */
class HungrySingleton{
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){

    }
    public static HungrySingleton getInstance() {
        return instance;
    }
}
