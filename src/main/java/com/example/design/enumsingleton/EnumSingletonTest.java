package com.example.design.enumsingleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举单例
 */
public class EnumSingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        EnumSingleton instance = EnumSingleton.INSTANCE;
//        EnumSingleton instance1 = EnumSingleton.INSTANCE;
//        System.out.println(instance == instance1);

//        EnumSingleton enumSingleton = EnumSingleton.class.getDeclaredConstructor(EnumSingleton.class).newInstance("INSTANCE", 0);
//        System.out.println(enumSingleton);

        EnumSingleton instance = EnumSingleton.INSTANCE;
//        ObjectOutputStream enumSingletonFile = new ObjectOutputStream(new FileOutputStream("enum_singleton_file"));
//        enumSingletonFile.writeObject(instance);
//        enumSingletonFile.close();

        FileInputStream enumSingletonFile1 = new FileInputStream("enum_singleton_file");
        ObjectInputStream inputStream = new ObjectInputStream(enumSingletonFile1);
        EnumSingleton o = (EnumSingleton)inputStream.readObject();
        System.out.println(o == instance);
    }
}

/**
 * 枚举单例 推荐使用 线程安全  防止反射破坏单例 防止反序列化破坏单例
 * 不能延时加载
 * 不能有其他实例变量
 * 不能有其他方法
 * 不能被继承
 * 不能被克隆
 * 不能被反序列化
 */
enum EnumSingleton {
    INSTANCE;
    public void print() {
        System.out.println(this.hashCode());
    }
}
