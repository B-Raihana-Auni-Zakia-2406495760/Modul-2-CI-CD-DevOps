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
Selama pengerjaan Modul 2 ini, berikut beberapa perbaikan yang dilakukan:
1. Memperbaiki Case-Sensitivity pada Naming Convention
2. Menghapus Unused Imports & Variables

Menurut saya implementasi pada repositori ini sudah memenuhi CI CD nya.
CI terimplementasikan melalui file workflow gitHub actions (ci.yml) yang tereksekusi setiap kali ada push atau pull request. Workflow ini menyiapkan environment java, melakukan build, menjalankan unit test dan functional test.
CD terimplementasikan melalui auto deploy dengan platform PaaS Render. Saat kode berhasil di push ke branch main, Render akan otomatis mendeteksi perubahan tersebut dan langsung deploy ke server.