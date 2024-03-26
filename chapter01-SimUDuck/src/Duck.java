interface QuackBehavior {
    void quack();
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
