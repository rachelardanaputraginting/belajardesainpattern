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
