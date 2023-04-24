package com.example.design.strategy.v2;

/**
 * 策略模式
 */
public class StrategyTest {
    public static void main(String[] args) {
        NormalZombie normalZombie = new NormalZombie();
        NormalZombie normalZombie1 = new NormalZombie(new StepByStepMove(), new BiteAttack());
        System.out.println("---------------第一个普通僵尸出场-----------------");
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();
        System.out.println("---------------第二个普通僵尸出场-----------------");
        normalZombie1.display();
        normalZombie1.move();
        normalZombie1.attack();
        System.out.println("---------------旗帜将是出场-----------------");
        FlogZombie flogZombie = new FlogZombie();
        flogZombie.display();
        flogZombie.move();
        flogZombie.attack();
        System.out.println("---------------第二个旗帜僵尸出场-----------------");
        FlogZombie flogZombie1 = new FlogZombie(new StepByStepMove(), new HitAttack());
        flogZombie1.display();
        flogZombie1.move();
        flogZombie1.attack();
    }
}

interface Moveable {
    void move();
}
class StepByStepMove implements Moveable {
    @Override
    public void move() {
        System.out.println("一步一步移动");
    }
}
interface Attackable {
    void attack();
}

class BiteAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("咬");
    }
}

class HitAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("打");
    }
}

abstract class Zombie {
    abstract public void display();
    Moveable moveable;
    Attackable attackable;

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }

    abstract void  attack();

    abstract void move();
}

class NormalZombie extends Zombie {

    public NormalZombie (){
        super(() -> System.out.println("移动"), () -> System.out.println("攻击"));
    }
    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("普通僵尸");
    }

    @Override
    void  attack() {
        attackable.attack();
    }

    @Override
    void move() {
        moveable.move();
    }
}

class FlogZombie extends Zombie {

    public  FlogZombie (){
        super(() -> System.out.println("摇旗移动"), () -> System.out.println("旗帜攻击"));
    }

    public FlogZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }
    @Override
    public void display() {
        System.out.println("旗手僵尸");
    }

    @Override
    void attack() {
        attackable.attack();
    }

    @Override
    void move() {
        moveable.move();
    }

}