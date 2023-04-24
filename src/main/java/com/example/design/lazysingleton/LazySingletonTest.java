package com.example.design.lazysingleton;

/**
 * 懒汉式单例
 */
public class LazySingletonTest {
    public static void main(String[] args) {
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

//懒汉式单例
//线程安全问题
//double check 加锁优化
//编译器优化防止指令重排
class LazySingleton {
    private volatile static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class){
                if (instance == null) {
                    instance = new LazySingleton();
                    //字节码层
                    // JIT编译器
                    // CPU指令
                    // 1.分配内存空间
                    // 2.初始化对象
                    // 3.引用赋值
                    // volatile 防止指令重排
                }
            }
        }
        return instance;
    }
}
