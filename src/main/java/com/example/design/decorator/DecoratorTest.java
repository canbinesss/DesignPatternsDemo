package com.example.design.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator(new ConcreteComponent());
        new ConcreteDecorator2(component).operation();

        new ConcreteDecorator2(new ConcreteComponent()).operation();

    }
}

interface Component{
    void operation();
}

class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("具体构件角色的方法");
    }

}

abstract class Decorator implements Component{
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

}

class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println("具体装饰角色的方法");
    }

}

class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println("具体装饰角色的方法2");
    }

}
