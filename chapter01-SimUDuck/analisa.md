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
