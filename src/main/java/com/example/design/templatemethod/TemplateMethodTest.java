package com.example.design.templatemethod;

/**
 * 模板方法模式
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass subClass = new SubClass();
        subClass.operation();
        AbstractClass subClass2 = new SubClass2();
        subClass2.operation();
    }
}

abstract class AbstractClass {
    public void operation() {
        //Open
        System.out.println("pre ...");
        System.out.println("step1 ...");
        System.out.println("step2 ...");
        templateMethod();
        //sql ...
        //close
    }

    abstract protected void templateMethod();
}

class SubClass extends AbstractClass {
    @Override
    protected void templateMethod() {
        System.out.println("SubClass.templateMethod");
    }
}

class SubClass2 extends AbstractClass {
    @Override
    protected void templateMethod() {
        System.out.println("SubClass2.templateMethod");
    }
}
