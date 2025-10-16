package praktikum3.soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah dadu: ");
        int jumlahDadu = scanner.nextInt();
        LinkedList<Dadu> semuaDadu = new LinkedList<>();
        for (int i = 0; i < jumlahDadu; i++) {
            semuaDadu.add(new Dadu());
        }

        int totalNilai = 0;
        for (int i = 0; i < semuaDadu.size(); i++) {
            int nilai = semuaDadu.get(i).getNilai();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilai);
            totalNilai += nilai;
        }
        System.out.println("Total nilai dadu keseluruhan " + totalNilai);
        scanner.close();
    }
}