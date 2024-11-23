/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum12.tugas;

/**
 *
 * @author hp
 */
import java.io.Serializable;

public class Buku implements Serializable {
    private String judul;
    private String pengarang;
    private int tahunTerbit;

    // Konstruktor untuk menginisialisasi atribut Buku
    public Buku(String judul, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    // Getter untuk judul
    public String getJudul() {
        return judul;
    }

    // Getter untuk pengarang
    public String getPengarang() {
        return pengarang;
    }

    // Getter untuk tahun terbit
    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Mengoverride metode toString untuk menampilkan buku
    @Override
    public String toString() {
        return "Judul: " + judul + ", Pengarang: " + pengarang + ", Tahun Terbit: " + tahunTerbit;
    }
}
