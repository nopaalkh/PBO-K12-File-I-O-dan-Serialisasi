/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum12.tugas;

/**
 *
 * @author hp
 */
import java.io.*;
import java.util.Scanner;

public class SistemManajemenBuku {
    private static final String FILE_TEKSTUAL = "buku.txt";  // Nama file untuk menyimpan buku
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\nMenu Sistem Manajemen Buku:");
                System.out.println("1. Tambah Buku Baru");
                System.out.println("2. Simpan Buku");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu): ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();  // Konsumsi newline

                switch (pilihan) {
                    case 1:
                        tambahBuku(scanner);
                        break;
                    case 2:
                        simpanKeFileTeks();
                        break;
                    case 3:
                        System.out.println("Keluar dari sistem.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid, coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang benar.");
                scanner.nextLine();  // Konsumsi input yang salah
            }
        }
    }

    // Menambahkan buku baru ke dalam daftar
    private static void tambahBuku(Scanner scanner) {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan pengarang buku: ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();  // Konsumsi newline yang tersisa

        Buku bukuBaru = new Buku(judul, pengarang, tahunTerbit);
        // Menyimpan buku ke dalam file teks setelah ditambahkan
        simpanKeFileTeks(bukuBaru);
        System.out.println("Buku berhasil ditambahkan.");
    }

    // Fungsi untuk menyimpan buku ke file teks
    private static void simpanKeFileTeks(Buku buku) {
        try (FileWriter writer = new FileWriter(FILE_TEKSTUAL, true)) {
            // Menulis buku ke file, menambahkan setiap buku pada baris baru
            writer.write(buku.toString() + "\n");
            System.out.println("Buku berhasil disimpan ke file teks.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file teks.");
            e.printStackTrace();
        }
    }

    // Menampilkan daftar buku yang ada di file teks
    private static void simpanKeFileTeks() {
        System.out.println("Menampilkan semua buku yang ada dalam file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_TEKSTUAL))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file teks.");
            e.printStackTrace();
        }
    }
}
