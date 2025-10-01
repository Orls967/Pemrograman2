package Praktikum1Pemro2;

import java.util.Scanner;
import java.util.Locale;
public class PRAK101_2410817210017_OrlandoSugian {
	
	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	        String namaLengkap, tempatLahir, namaBulan;
	        int tanggalLahir, bulanLahir, tahunLahir, tinggiBadan;
	        double beratBadan;

	        System.out.print("Masukkan Nama Lengkap: ");
	        namaLengkap = scanner.nextLine();

	        System.out.print("Masukkan Tempat Lahir: ");
	        tempatLahir = scanner.nextLine();

	        System.out.print("Masukkan Tanggal Lahir: ");
	        tanggalLahir = scanner.nextInt();

	        System.out.print("Masukkan Bulan Lahir: ");
	        bulanLahir = scanner.nextInt();

	        System.out.print("Masukkan Tahun Lahir: ");
	        tahunLahir = scanner.nextInt();

	        System.out.print("Masukkan Tinggi Badan: ");
	        tinggiBadan = scanner.nextInt();

	        System.out.print("Masukkan Berat Badan: ");
	        beratBadan = scanner.nextDouble();
	        
	        if (bulanLahir == 1) {
	            namaBulan = "Januari";
	        } else if (bulanLahir == 2) {
	            namaBulan = "Februari";
	        } else if (bulanLahir == 3) {
	            namaBulan = "Maret";
	        } else if (bulanLahir == 4) {
	            namaBulan = "April";
	        } else if (bulanLahir == 5) {
	            namaBulan = "Mei";
	        } else if (bulanLahir == 6) {
	            namaBulan = "Juni";
	        } else if (bulanLahir == 7) {
	            namaBulan = "Juli";
	        } else if (bulanLahir == 8) {
	            namaBulan = "Agustus";
	        } else if (bulanLahir == 9) {
	            namaBulan = "September";
	        } else if (bulanLahir == 10) {
	            namaBulan = "Oktober";
	        } else if (bulanLahir == 11) {
	            namaBulan = "November";
	        } else if (bulanLahir == 12) {
	            namaBulan = "Desember";
	        } else {
	            namaBulan = "[Bulan tidak valid]"; 	
	        }

	        System.out.printf("Nama Lengkap %s, Lahir di %s pada Tanggal %d %s %d%n",
	                namaLengkap, tempatLahir, tanggalLahir, namaBulan, tahunLahir);
	        System.out.printf(Locale.US, "Tinggi Badan %d cm dan Berat Badan %.2f kilogram%n",
	                tinggiBadan, beratBadan);
	        scanner.close();
	    }
	}