package com.example.design.strategy.v1;

/**
 * 策略模式
 */
public class StrategyTest {
    public static void main(String[] args) {
        AbstractZombie normalZombie = new NormalZombie();
        AbstractZombie flagZombie = new FlagZombie();
        AbstractZombie bigHeadZombie = new bigHeadZombie();
        AbstractZombie xxxZombie = new XXXZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();
        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
        bigHeadZombie.display();
        bigHeadZombie.move();
        bigHeadZombie.attack();
        xxxZombie.display();
        xxxZombie.move();
        xxxZombie.attack();

    }
}

abstract class AbstractZombie {
    public abstract void display();

    public void move() {
        System.out.println("移动");
    }

    public void attack() {
        System.out.println("攻击");
    }
}

class NormalZombie extends AbstractZombie {
    @Override
    public void display() {
        System.out.println("普通僵尸");
    }
}

class FlagZombie extends AbstractZombie {
    @Override
    public void display() {
        System.out.println("旗手僵尸");
    }
}

class bigHeadZombie extends AbstractZombie {
    @Override
    public void display() {
        System.out.println("大头僵尸");
    }

    @Override
    public void attack() {
        System.out.println("大头僵尸攻击");
    }
}

class XXXZombie extends bigHeadZombie {
    @Override
    public void display() {
        System.out.println("XXX僵尸");
    }

    @Override
    public void move() {
        System.out.println("XXX僵尸移动");
    }
}

