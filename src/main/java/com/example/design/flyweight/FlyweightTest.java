package com.example.design.flyweight;

import java.util.HashMap;

/**
 * 享元模式
 */
public class FlyweightTest {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("aa");
        Flyweight flyweight2 = factory.getFlyweight("aa");
        System.out.println(flyweight1 == flyweight2);
        Flyweight flyweight3 = factory.getFlyweight("bb");
        Flyweight flyweight4 = factory.getFlyweight("bb");
        flyweight4.operation(new UnsharedConcreteFlyweight("第一次调用b"));
        System.out.println(flyweight3 == flyweight4);

    }
}

//抽象享元角色
interface Flyweight {
    void operation(UnsharedConcreteFlyweight state);
}

//具体享元角色

class ConcreteFlyweight implements Flyweight {
    private String key;

    ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.println("具体享元" + key + "被调用");
        System.out.println("非享元信息是:" + state.getInfo());
    }
}

//非享元角色

class UnsharedConcreteFlyweight {
    private String info;

    UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info){
        this.info = info;
    }
}

//享元工厂角色

class FlyweightFactory {
    private HashMap<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);
        if (flyweight != null) {
            System.out.println("具体享元" + key + "已经存在，被成功获取");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}