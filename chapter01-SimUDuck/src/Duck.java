interface QuackBehavior {
    void quack();
}

interface FlyBehavior {
    void fly();
}

class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Qwek - Qwek");
    }
}

class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}

class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("Tidak Bisa bersuara");
    }
}

class FlyWithWIngs implements FlyBehavior {
    public void fly() {
        System.out.println("Terbang");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("Tidak bisa terbang");
    }
}

class FlyWithRockerPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Cool, terbang menggunakan rocket");
    }
}

abstract class Duck {
    void swim() {
        System.out.println("Berenang");
    }

    abstract void display();
}

class MallardDuck extends Duck {
    @Override
    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedHeadDuck extends Duck {

    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

class RubberDuck extends Duck {
    @Override
    void display() {
        System.out.println("Tampilan RubberDuck");
    }
}

class WoodenDuck extends Duck {
    @Override
    void display() {
        System.out.println("Tampilan WoodenDuck");
    }
}

class ToyDuck extends Duck {
    @Override
    void display() {
        System.out.println("Tampilan ToyDuck");
    }
}
