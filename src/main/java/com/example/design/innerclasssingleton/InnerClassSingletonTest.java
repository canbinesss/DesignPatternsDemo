package com.example.design.innerclasssingleton;

import java.io.*;

/**
 * 静态内部类单例
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        new Thread(() -> {
//            InnerClassSingleton instance = InnerClassSingleton.getInstance();
//            System.out.println(instance);
//        }).start();
//        new Thread(() -> {
//            InnerClassSingleton instance = InnerClassSingleton.getInstance();
//            System.out.println(instance);
//        }).start();


//        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        InnerClassSingleton instance = declaredConstructor.newInstance();
//        InnerClassSingleton innerClassSingleton = InnerClassSingleton.getInstance();
//        System.out.println(innerClassSingleton);

        InnerClassSingleton instance = InnerClassSingleton.getInstance();
//        ObjectOutputStream singletonFile = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        singletonFile.writeObject(instance);
//        singletonFile.close();

        ObjectInputStream singletonFile1 = new ObjectInputStream(new FileInputStream("singleton_file"));
        InnerClassSingleton o = (InnerClassSingleton)singletonFile1.readObject();
        System.out.println( o == instance);
        singletonFile1.close();
    }
}


/**
 * 静态内部类单例  推荐使用
 * 实际上是饿汉式，但是不会立即加载，只有调用getInstance()方法时才会加载
 * 线程安全，效率高，可以延时加载
 * 饿汉模式可以，防止反射破坏单例 防止反序列化破坏单例
 * 不能被克隆 不能被反序列化
 */
class InnerClassSingleton implements Serializable {
    static final long serialVersionUID = 42L;
    private InnerClassSingleton() {
        throw new RuntimeException("不允许创建多个实例");
    }
    private static class InnerClassHolder {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }
    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

    @Serial
    Object readResolve() throws ObjectStreamException{
        return InnerClassHolder.instance;
    }

    float ss = 1.0f;
}
