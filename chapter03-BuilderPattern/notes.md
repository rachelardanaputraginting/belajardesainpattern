# Chapter 03 - Builder Pattern

Builder merupakan design pattern yang dapat mempermudah pembuatan berbagai macam variasi class meski dengan model yang berbeda.

![Masalah Building!](https://refactoring.guru/images/patterns/diagrams/builder/problem2.png#center)

Berbeda dengan Constructor yang mengharuskan Client untuk memasukkan beberapa parameter untuk mendeklarasikan object (dimana dalam beberapa kasus tertentu, beberapa parameter tidak pernah digunakan alias useless), Builder class dapat memberikan fleksibilitas Client dalam menentukan/mendeklarasikan object yang mereka inginkan tanpa harus bergantung pada setiap attribute yang mereka inginkan.
![Solusi Building!](https://refactoring.guru/images/patterns/diagrams/builder/solution1.png#center)

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Essences of Builder
1. Sets of class objects as an object
Agar Builder dapat mendeklarasikan sebuah class object, sebuah class yang dijadikan model harus mempunyai beberapa attribute (termasuk Setter dan Getter) untuk mempermudah deklarasi object dan meningkatkan fleksibilitas yang diberikan kepada pengguna/Client.

Salah satu contoh class yang dapat dipergunakan dalam builder adalah class Computer, dimana class tersebut mencakup 5 attribute yang dapat ditentukan oleh user yaitu Processor, Storage, RAM, GPU, dan Cooling.

2. Attribute Setter
Dibanding menggunakan Constructor, Builder memungkinkan Client untuk menentukan attribute-attribute yang mereka inginkan untuk dideklarasikan sebagai object dengan bantuan Setter dan lebih fleksibel karena tidak harus mencantumkan semua attribute yang perlu dibuat dibanding Constructor.

3. Returner 
Setelah object tersebut dibuat dengan bantuan Setter, Client dapat mengembalikan object yang mereka buat dengan object method.

4. Ketika Client ingin menggunakan kembali Builder object, class dapat direset dengan bantuan method reset() untuk mendeklarasikan object dalam builder sebagai object kosong agar dapat digunakan sesuai kebutuhan Client untuk object berikutnya.


## Director
> Ketika Client tidak mempunyai banyak waktu untuk berpikir untuk membangun rumah, merakit komputer, maupun merancang hunian impian, Director alias juru mandor adalah solusi bagi anda yang malas mengurus berbagai urusan yang menyulitkan hidup anda.

Dalam beberapa kasus tertentu, pembuatan object tidak melalu dilakukan oleh Client. Sebaliknya, Client dapat menggunakan beberapa pilihan object yang sudah ada untuk dipergunakan langsung oleh Client. Penggunaan Director dapat dilakukan untuk mendelegasikan deklarasi class sesuai keinginan Client/user melalui beberapa Object method yang ditujukan kepada Builder untuk memenuhi kebutuhan Client.
