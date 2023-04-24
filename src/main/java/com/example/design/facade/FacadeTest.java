package com.example.design.facade;

/**
 * 外观模式
 */
public class FacadeTest {
    public static void main(String[] args) {

    }
}

/**
 * 门面模式
 */
class client1 {
    Facade facade = new Facade();
    public void doSomething() {
        facade.doABC();
    }
}

/**
 * 门面模式
 */
class client2 {
    Facade facade = new Facade();
    public void doSomething() {
        facade.doABC();
    }
}

/**
 * 门面模式 - 外观模式 - 门面类 - 门面类知道哪些子系统类负责处理请求，将客户的请求代理给适当的子系统对象
 */
class Facade {
    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();
    private SubSystemC subSystemC = new SubSystemC();

    public void doABC() {
        subSystemA.doA();
        subSystemB.doB();
        subSystemC.doC();
    }
}

class SubSystemA {
    public void doA() {
        System.out.println("doing A stuff");
    }
}

class SubSystemB {
    public void doB() {
        System.out.println("doing B stuff");
    }
}

class SubSystemC {
    public void doC() {
        System.out.println("doing C stuff");
    }
}

