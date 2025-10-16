package praktikum3.soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = scanner.nextLine();
                    daftarMahasiswa.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa " + nama + " ditambahkan.");
                    break;
                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    boolean removed = daftarMahasiswa.removeIf(mhs -> mhs.getNim().equals(nimHapus));
                    if (removed) {
                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    String nimCari = scanner.nextLine();
                    boolean found = false;
                    for (Mahasiswa mhs : daftarMahasiswa) {
                        if (mhs.getNim().equals(nimCari)) {
                            System.out.println("Data Mahasiswa Ditemukan:");
                            System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.println("Daftar Mahasiswa:");
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("Tidak ada data mahasiswa.");
                    } else {
                        for (Mahasiswa mhs : daftarMahasiswa) {
                            System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}