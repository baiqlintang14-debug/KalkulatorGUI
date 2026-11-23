# Latihan GUI Java - Kalkulator

Kalkulator sederhana yang dibuat dengan Java Swing untuk latihan materi Graphical User Interface.

## 5 Komponen Utama GUI

1. Top-level Container Class: JFrame
   Jendela utama aplikasi yang menampung semua komponen.

2. Intermediate Container Class: JPanel
   Dipakai untuk mengelompokkan komponen. Ada dua panel, yaitu panel tombol untuk angka dan operator, dan panel bawah untuk tombol C.

3. Atomic Component Class: JTextField dan JButton
   JTextField untuk layar hasil, JButton untuk semua tombol.

4. Layout Classes: BorderLayout, GridLayout, dan FlowLayout
   BorderLayout mengatur susunan utama frame. GridLayout menyusun 16 tombol dalam grid 4 x 4. FlowLayout mengatur tombol C di bagian bawah.

5. Event Listener: ActionListener
   Method actionPerformed di-override untuk menangani klik semua tombol.

## Screenshot

![Tampilan Aplikasi](screenshot.png)

## Cara Menjalankan

Compile dengan perintah `javac KalkulatorGUI.java`, lalu jalankan dengan `java KalkulatorGUI`.
