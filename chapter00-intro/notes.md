### Chapter00-Pendahuluan
## Kelas
- Sebuah kelas adalah cetak biru atau template untuk membuat objek dalam bahasa pemrograman.
- Kelas mendefinisikan sekumpulan atribut (field atau properti) dan metode (fungsi atau prosedur) yang mencirikan perilaku objek.
- Kelas berfungsi sebagai cetak biru untuk membuat instance objek dengan karakteristik dan perilaku yang sama.
- Kelas mengenkapsulasi properti dan perilaku yang akan dimiliki oleh objek dari kelas tersebut.

## Objek
- Sebuah objek adalah instance dari kelas, yang dibuat berdasarkan cetak biru yang didefinisikan oleh kelas.
- Objek mewakili entitas dunia nyata dengan properti (atribut) dan perilaku (metode).
- Objek adalah entitas runtime yang berinteraksi satu sama lain dalam sistem berorientasi objek.
- Setiap objek memiliki status uniknya sendiri, tetapi berbagi struktur dan perilaku yang didefinisikan oleh kelasnya.

## Pewarisan
Pewarisan adalah konsep fundamental dalam pemrograman berorientasi objek (OOP) yang memungkinkan sebuah kelas baru mewarisi karakteristik dan perilaku (field dan metode) dari kelas yang sudah ada. Dalam Java, pewarisan memungkinkan pembuatan kelas baru, yang dikenal sebagai subkelas atau kelas anak, berdasarkan kelas yang sudah ada, yang disebut superkelas atau kelas induk.

## Kelas Abstrak
- Kelas abstrak adalah kelas yang tidak dapat diinstansiasi sendiri.
- Kelas abstrak dapat memiliki metode abstrak (belum diimplementasikan) dan metode konkret (sudah diimplementasikan).
- Kelas abstrak dapat memiliki variabel instance (field).
- Kelas abstrak dapat memperluas kelas lain (abstrak atau konkret) dan mengimplementasikan antarmuka.

## Antarmuka
- Antarmuka adalah kumpulan metode abstrak (metode tanpa tubuh) dan deklarasi konstanta.
- Semua metode dalam antarmuka secara implisit bersifat publik dan abstrak (sebelum Java 8), atau dapat secara eksplisit dinyatakan demikian (Java 8 dan seterusnya).
- Antarmuka hanya dapat berisi field konstan (static final), bukan variabel instance.
- Kapan Menggunakan Kelas Abstrak vs. Antarmuka:

## Gunakan Kelas Abstrak Ketika:
- Ada kode yang dibagikan/umum di antara kelas-kelas yang terkait.
- Anda ingin menyediakan implementasi default untuk beberapa metode.
- Anda perlu mendeklarasikan anggota non-publik (field atau metode).
- Gunakan Antarmuka Ketika:
> - Tidak ada kode yang dibagikan/umum di antara kelas-kelas, dan mereka hanya perlu sesuai dengan kontrak.
> - Anda ingin mencapai pewarisan ganda.
> - Anda ingin membuat kontrak yang ringan dan menyatukan untuk kelas yang tidak terkait.
> - Dalam praktiknya, Anda mungkin juga menggunakan kombinasi kelas abstrak dan antarmuka berdasarkan kebutuhan spesifik desain Anda.