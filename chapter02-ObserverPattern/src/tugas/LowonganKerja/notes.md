# Observer Pattern
## Kasus
Sebuah perusahaan memiliki Sistem Manajemen Lowongan Kerja yang bertanggung jawab untuk mengelola informasi lowongan pekerjaan yang tersedia. Sistem ini harus memberikan notifikasi secara real-time kepada Sistem Perekrutan, Portal Karir, dan Sistem Lamaran ketika ada lowongan baru yang ditambahkan.

### Implementasi
2. SistemLowongan sebagai Observable yang menyediakan informasi lowongan pekerjaan terbaru. 
2. SistemPerekrutan, PortalKarir, dan SistemLamaran sebagai Observer yang menerima informasi lowongan terbaru. 
3. Ketika ada lowongan baru, SistemLowongan akan memberitahu semua Observer yang terdaftar melalui metode notifyObservers. 
4. Setiap Observer akan menerima informasi lowongan terbaru melalui metode updateLowongan dan dapat melakukan tindakan yang sesuai dengan perannya dalam proses rekrutmen.

### Keuntungan
1. Pemisahan tanggung jawab antara sumber informasi (Observable) dan konsumen informasi (Observer).
2. Memudahkan penambahan atau penghapusan Observer di masa depan tanpa mengubah kode pada Observable.
3. Memberikan fleksibilitas dan kemudahan dalam pemeliharaan sistem.

Dengan menggunakan Observer Pattern, sistem ini memungkinkan komunikasi satu-ke-banyak (one-to-many) secara real-time dan efisien antara Sistem Manajemen Lowongan Kerja dengan sistem atau aplikasi terkait dalam proses rekrutmen.

