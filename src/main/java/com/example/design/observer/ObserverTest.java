package com.example.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer task1 = new Tesk1();
        subject.addObserver(task1);
        Observer task2 = new Tesk2();
        subject.addObserver(task2);

        subject.notifyObservers("hello");
        subject.remove(task1);
        subject.notifyObservers("world");
        subject.addObserver(task1);
        subject.addObserver(task2);
        subject.notifyObservers("java");
    }
}

class  Subject{
    // 容器
    private List<Observer> container = new ArrayList<>();
    //add
    public void addObserver(Observer observer){
        container.add(observer);
    }
    //remove
    public void remove(Observer observer){
        container.remove(observer);
    }

    public void notifyObservers(Object object){
        for (Observer observer : container) {
            observer.update(object);
        }
    }
}

interface Observer{
    void update(Object object);
}

class Tesk1 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("task1 received: "+object);
    }
}

class Tesk2 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("task2 received: "+object);
    }
}