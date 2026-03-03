Halo Kak, mohon maaf sebelumnya kak. Tugas modul 1 ini sudah saya kerjakan tepat waktu, tapi saya salah push ke repository akun pribadi bukan ke github organization.
Repo ini hasil migrasi dari hasil pekerjaan saya yang di push ke akun pribadi dan sudah saya perbaiki. Terima kasih kak.

MODULE 1

Reflection 1

Sejauh ini, dalam mengerjakan modul saya sudah menerapkan clean code,
seperti sudah menggunakan nama variabel dan fungsi yang jelas dan deskriptif,
memisahkan kode-kode ke dalam pakcage-pakcage yang berbeda,
dan fungsi-fungsi yang dibuaat sudah kecil dan melakukan 1 hal saja.


Reflection 2
1. Setelah melakukan unit test, saya merasa lebih yakin dengan kode yang saya buat sudah sesuai.
   Untuk jumlah unit test biasanya setiap class memiliki minimal 1 unit test.
   Jika code coverage menunjukan angka 100%, itu belum bisa memastikan bahwa code sudah bebas dari bug/error
2. Terdapat masalah yang melanggar clean code yaitu adanya code yg berulang di karenakan kode functional test yang baru dibuat.
   Salah satu solusinya kita bisa membuat parent, agar class test yang ada duplikasi kode bisa extend parent tersebut saja.

MODULE 2

link deploy: https://eshop-raihana-auni.onrender.com

Selama pengerjaan Modul 2 ini, berikut beberapa perbaikan yang dilakukan:
1. Memperbaiki Case-Sensitivity pada Naming Convention
2. Menghapus Unused Imports & Variables

Menurut saya implementasi pada repositori ini sudah memenuhi CI CD nya.
CI terimplementasikan melalui file workflow gitHub actions (ci.yml) yang tereksekusi setiap kali ada push atau pull request. Workflow ini menyiapkan environment java, melakukan build, menjalankan unit test dan functional test.
CD terimplementasikan melalui auto deploy dengan platform PaaS Render. Saat kode berhasil di push ke branch main, Render akan otomatis mendeteksi perubahan tersebut dan langsung deploy ke server.

MODULE 3
1) Explain what principles you apply to your project!
- SRP: memisahkan CarController yang sebelumnya berada di dalam file ProductController.java. Cntroller dipisahkan agar hanya memiliki satu tanggung jawab: ProductController mengurus routing produk, dan CarController mengurus routing mobil
- LSP: menghapus 'extends ProductController' pada CarController. CarController bukanlah pengganti dari ProductController, sehingga inheritance tersebut tidak tepat
- ISP: menghapus interface CarService.java dan memisahkan operasi create, update, dan delete dengan find. jadi, yang memanggil service tidak dipaksa untuk bergantung pada metode-metode yang tidak digunakan
- DIP: mengubah agar bergantung pada interface, bukan pada implementasi konkret
- OCP: mengekstrak interface CarRepository

2) Explain the advantages of applying SOLID principles to your project with examples.
- Meningkatkan maintainability: dengan menerapkan SRP pada controller, jika ada bug pada fitur edit mobil hanya perlu mengecek CarController
- Kode menjadi fleksibel: dengan menerapkan OCP dan DIP pada repository, jika nanti harus menyimpan data menggunakan PostgreSQL, hanya perlu membuat class baru yang mengimplementasikan interface CarRepository
- Mempermudah unit testing: Karena controller dan service sekarang bergantung pada interface, sangat mudah untuk melakukan mocking saat menulis test

3) Explain the disadvantages of not applying SOLID principles to your project with examples.
- Fragility: jika CarController dan ProductController digabung dalam satu file, mengubah logika produk berpotensi merusak fungsionalitas mobil dengan tidak sengaja
- Rigidity: jika CarServiceImpl bergantung langsung pada CarRepositoryImpl, migrasi ke database SQL akan harus merombak baris kode di service
- Coupling Tinggi: satu interface besar yang menangani segalanya, jika ada satu perubahan kecil pada satu metode, seluruh kelas yang mengimplementasikan interface tersebut ikut berpengaruh