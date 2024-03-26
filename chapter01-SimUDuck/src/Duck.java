abstract class Duck {
    void quack() {
        System.out.println("Qwek Qwek");
    }

    void swim() {
        System.out.println("Berenang");
    }

    abstract void display();

    void fly(){
        System.out.println("Terbang");
    }
}

class MallardDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedHeadDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

class RubberDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan RubberDuck");
    }
}

class WoodenDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan WoodenDuck");
    }
}
