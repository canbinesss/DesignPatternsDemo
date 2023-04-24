package com.example.design.factorymethod;

/**
 * 工厂方法模式
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        Application factory = new ConcreteProductA();
        Product product = factory.getObject();
        product.print();
    }


}

interface Product {
    void print();
}

class ProductA implements Product {
    @Override
    public void print() {
        System.out.println("productA.method excuted.");
    }
}

class ProductB implements Product {
    @Override
    public void print() {
        System.out.println("ProductB.method excuted.");
    }
}

abstract class Application {
    abstract Product createProduct( );

    Product getObject() {
        //...
        Product product = createProduct();
        return product;
    }
}

class ConcreteProductA extends Application {
    @Override
    Product createProduct() {
        //...
        return new ProductA();
    }
}

class ConcreteProductB extends Application {
    @Override
    Product createProduct() {
        //...
        return new ProductB();
    }
}