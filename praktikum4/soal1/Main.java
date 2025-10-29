package praktikum4.soal1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Hewan Peliharaan: ");
        String nama = scanner.nextLine();
        System.out.print("Ras: ");
        String ras = scanner.nextLine();
        
        HewanPeliharaan hewan = new HewanPeliharaan(ras, nama);
        hewan.display();
        scanner.close();
    }
}