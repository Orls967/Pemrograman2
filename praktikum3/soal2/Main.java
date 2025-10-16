package praktikum3.soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, String> bulanMap = new HashMap<>();
        bulanMap.put(1, "Januari");
        bulanMap.put(2, "Februari");
        bulanMap.put(3, "Maret");
        bulanMap.put(4, "April");
        bulanMap.put(5, "Mei");
        bulanMap.put(6, "Juni");
        bulanMap.put(7, "Juli");
        bulanMap.put(8, "Agustus");
        bulanMap.put(9, "September");
        bulanMap.put(10, "Oktober");
        bulanMap.put(11, "November");
        bulanMap.put(12, "Desember");
        
        int jumlahNegara = Integer.parseInt(scanner.nextLine());
        LinkedList<Negara> daftarNegara = new LinkedList<>();

        for (int i = 0; i < jumlahNegara; i++) {
            String nama = scanner.nextLine();
            String jenisKepemimpinan = scanner.nextLine();
            String namaPemimpin = scanner.nextLine();

            if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
                daftarNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin));
            } else {
                int tanggal = Integer.parseInt(scanner.nextLine());
                int bulan = Integer.parseInt(scanner.nextLine());
                int tahun = Integer.parseInt(scanner.nextLine());
                daftarNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggal, bulan, tahun));
            }
        }
        
        System.out.println(); 
        for (Negara negara : daftarNegara) {
            String kepemimpinanTampilan;
            switch (negara.getJenisKepemimpinan().toLowerCase()) {
                case "presiden":
                    kepemimpinanTampilan = "Presiden";
                    break;
                case "perdana menteri":
                    kepemimpinanTampilan = "Perdana Menteri";
                    break;
                case "monarki":
                    kepemimpinanTampilan = "Raja";
                    break;
                default:
                    kepemimpinanTampilan = negara.getJenisKepemimpinan();
            }

            System.out.println("Negara " + negara.getNama() + " mempunyai " + kepemimpinanTampilan + " bernama " + negara.getNamaPemimpin());
            
            if (!negara.getJenisKepemimpinan().equalsIgnoreCase("monarki")) {
                String namaBulan = bulanMap.get(negara.getBulanKemerdekaan());
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + negara.getTanggalKemerdekaan() + " " + namaBulan + " " + negara.getTahunKemerdekaan());
            }
            System.out.println(); 
        }
        scanner.close();
    }
}