# Chapter 01 - Strategy Pattern

## Tujuan
- Memahami konsep Strategy Pattern dan manfaatnya dalam desain perangkat lunak
- Mengimplementasikan Strategy Pattern dalam bahasa pemrograman Java.
- Mampu mengidentifikasi situasi yang cocok untuk penggunaan Strategy Pattern

## Deskripsi
Strategy Pattern adalah sebuah pola desain (design pattern) dalam pemrograman yang memungkinkan definisi serangkaian algoritma terpisah, mengenkapsulasi setiap algoritma, dan membuatnya dapat saling bertukar secara dinamis sesuai kebutuhan. Pola ini memisahkan algoritma dari kelas yang menggunakannya, sehingga memungkinkan perubahan algoritma tanpa mengubah kelas klien yang memanfaatkannya.

Dalam Strategy Pattern, algoritma diimplementasikan sebagai objek terpisah yang disebut strategi (strategy). Kelas klien yang menggunakan algoritma memiliki referensi ke salah satu objek strategi tersebut, dan menggunakan strategi tersebut untuk mengeksekusi algoritma tertentu.

Dengan menggunakan Strategy Pattern, kita dapat mencapai beberapa keuntungan, antara lain:
- Fleksibilitas: Kita dapat dengan mudah mengganti algoritma yang digunakan oleh kelas klien tanpa mempengaruhi struktur kelas klien tersebut.
- Pemisahan Kode: Algoritma-algoritma yang berbeda dienkapsulasi secara terpisah, sehingga memisahkan tanggung jawab dan mempermudah pemeliharaan serta pengembangan kode.
- Mudah diuji: Memisahkan algoritma ke dalam objek terpisah memungkinkan pengujian yang lebih mudah, karena setiap algoritma dapat diuji secara terpisah.
Kode yang dapat digunakan kembali(reusable): Objek strategi dapat digunakan kembali dalam berbagai konteks yang berbeda, tanpa perlu mengubah kelas klien.
Dengan demikian, Strategy Pattern sangat berguna ketika kita memiliki serangkaian algoritma yang berbeda dan perlu memilih algoritma yang sesuai secara dinamis, atau ketika kita ingin meningkatkan fleksibilitas dan pemeliharaan kode dalam pengembangan perangkat lunak.

## Langkah Kerja
### Tahap 1. Menggunakan Inheritance
1. Buat kelas Duck sebagai kelas dasar untuk semua jenis bebek
2. Buat kelas-kelas yang mewarisi Duck, seperti MallardDuck, RedheadDuck, dan lain-lain.
3. Implementasikan perilaku bersuara dan terbang secara langsung dalam masing-masing kelas turunan.
```
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

    @Override
    void quack() {
        System.out.println("Bunyinya squeek, bukan qwak");
    }

    @Override
    void fly() {
        // Tidak ada implementasi, karena bebek mainan tidak dapat terbang
    }
}

class WoodenDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan WoodenDuck");
    }

    @Override
    void quack() {
        // Tidak ada implementasi, karena bebek kayu tidak dapat bersuara
    }

    @Override
    void swim() {
        System.out.println("Mengambang");
    }

    @Override
    void fly() {
        // Tidak ada impementasi karena bebek kayu tidak dapat terbang
    }
}
```
> Analisis:
> - Pendekatan ini cukup sederhana dan mudah dipahami.
> - Menggunakan pewarisan (inheritance) untuk membagikan perilaku antara kelas induk dan anak.
> - Setiap bebek memiliki perilaku bersuara dan terbang yang sama dengan bebek lainnya.

> Kekurangan:
> - Ketika ada perubahan pada perilaku bersuara atau terbang, perubahan tersebut harus diterapkan di semua kelas turunan, yang dapat merepotkan dan memerlukan perubahan pada banyak bagian kode.
> - Tidak ada fleksibilitas dalam mengubah perilaku bersuara atau terbang secara dinamis pada saat runtime.

### Tahap 2. Menggunakan Interface. (Rubah kode pada tahap 1 menjadi seperti berikut)
1. Buat sebuah interface Quackable untuk perilaku bersuara.
2. Buat sebuah interface Flyable untuk perilaku terbang.
3. Implementasikan kedua interface tersebut dalam kelas Duck dan kelas-kelas turunannya.
```
interface Quackable {
    void quack();
}

interface Flyable {
    void fly();
}

abstract class Duck {
    abstract void display();

    void swim() {
        System.out.println("Berenang");
    }
}

class MallardDuck extends Duck implements Quackable, Flyable {
    @Override
    public void quack() {
        System.out.println("Qwek Qwek");
    }

    @Override
    public void fly() {
        System.out.println("Terbang");
    }
    @Override
    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedheadDuck extends Duck implements Quackable, Flyable {
    @Override
    public void quack() {
        System.out.println("Qwek Qwek");
    }

    @Override
    public void fly() {
        System.out.println("Terbang");
    }

    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

class RubberDuck extends Duck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
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

class ToyDuck extends Duck implements Flyable {
    @Override
    public void fly() {
        System.out.println("Terbang seperti mainan");
    }

    @Override
    void display() {
        System.out.println("Tampilan ToyDuck");
    }
}
```
Dalam skenarion ini:
- MallardDuck mengimplementasikan kedua antarmuka Quackable dan Flyable, memungkinkannya untuk bersuara quack dan terbang.
- RubberDuck hanya mengimplementasikan Quackable, karena tidak boleh terbang.
- WoodenDuck tidak mengimplementasikan antarmuka ini, mengimplikasikan bahwa ia tidak bersuara quack atau terbang. Sekarang, katakanlah kita memperkenalkan jenis bebek baru, ToyDuck, yang mirip dengan RubberDuck tetapi juga bisa terbang.
```
class ToyDuck extends Duck implements Flyable {
    public void fly() {
        System.out.println("Terbang seperti mainan");
    }
}
```
Dalam kasus ini, kita harus menduplikasi implementasi metode fly() dari Flyable baik di ToyDuck maupun MallardDuck. Ini karena antarmuka Java tidak mengizinkan penggunaan ulang kode, dan setiap kelas yang mengimplementasikan sebuah antarmuka harus memberikan implementasi sendiri. Duplikasi ini melanggar prinsip penggunaan code reuse, karena kita harus mengulang kode yang sama di beberapa tempat, meningkatkan overhead pemeliharaan dan kemungkinan memperkenalkan bug.Selain itu, jika perilaku fly() perlu diubah suatu saat, kita harus memperbarui di beberapa tempat, yang dapat berpotensi menyebabkan kesalahan dan membutuhkan waktu yang lebih lama.
> Analisis:
> - Menggunakan interface untuk mendefinisikan perilaku bersuara dan terbang membuat kode lebih modular.
> - Menerapkan polimorfisme dengan menggunakan interface, yang memungkinkan berbagai implementasi perilaku bersuara dan terbang.
> - Kelas turunan dapat mengimplementasikan lebih dari satu perilaku bersuara atau terbang jika diperlukan.

> Kekurangan:
> - Masih terbatas dalam fleksibilitas saat ingin mengubah perilaku bersuara atau terbang secara dinamis pada saat runtime.
> - Jika ada perubahan pada perilaku bersuara atau terbang, perubahan tersebut masih perlu diterapkan pada semua kelas turunan yang terkait.

### Tahap 3. Menggunakan Strategy Pattern (Rubah kode pada tahap 2 menjadi seperti berikut)
1. Buat sebuah interface QuackBehavior untuk perilaku bersuara.
2. Buat sebuah interface FlyBehavior untuk perilaku terbang.
3. Implementasikan kelas-kelas konkrit yang mengimplementasikan interface-interface tersebut.
```
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

class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("Terbang");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("Tidak bisa terbang");
    }
}

class FlyWithRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Cool, terbang menggunakan rocket");
    }
}

abstract class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    abstract void display();

    void swim() {
        System.out.println("Berenang");
    }

   void performQuack() {
        quackBehavior.quack();
   }

   void performFly() {
    flyBehavior.fly();
   }

   void setFlyBehavior(FlyBehavior fb) {
    flyBehavior = fb;
   }

   void setQuackBehavior(QuackBehavior qb) {
    quackBehavior = qb;
   }
}

class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

class RubberDuck extends Duck {
    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("Tampilan RubberDuck");
    }
}

class WoodenDuck extends Duck {
    public WoodenDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("Tampilan WoodenDuck");
    }
}

class ModelDuck extends Duck {
    ModelDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }
    @Override
    void display() {
        System.out.println("Tampilan ToyDuck");
    }
}
```
> Analisis:
> - Menerapkan Strategy Pattern memungkinkan kita untuk  > > > > - memisahkan perilaku bersuara dan terbang menjadi objek terpisah.
> - Fleksibilitas tinggi dalam mengubah perilaku bersuara atau terbang pada saat runtime dengan mudah.
> - Memungkinkan penggunaan berbagai macam perilaku bersuara dan terbang tanpa perubahan pada kelas bebek.
> Kekurangan:
> - Memperkenalkan kompleksitas tambahan ke dalam kode karena memerlukan lebih banyak kelas dan objek untuk mengelola strategi-strategi perilaku.
> - Dapat menjadi terlalu abstrak untuk aplikasi sederhana, yang dapat menyulitkan pemahaman bagi pengembang yang kurang berpengalaman.
### Pada file Main.java, isikan kode berikut
```
public class Main {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck modelduck = new ModelDuck();
        modelduck.performFly(); // Akan memanggil constructor modelduck(FlyNoWay())
        modelduck.setFlyBehavior(new FlyWithRocketPower());
        modelduck.performFly();
    }
}
```