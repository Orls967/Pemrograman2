package Praktikum1Pemro2;

import java.util.Scanner;
public class PRAK103_2410817210017_OrlandoSugian {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int angkaAwal = scanner.nextInt();
        
        int jumlahCetak = 0; 

        do {
            if (angkaAwal % 2 != 0) {
                System.out.print(angkaAwal);
                jumlahCetak++; 

                if (jumlahCetak < n) {
                    System.out.print(", ");
                }
            }
            angkaAwal++;
        } while (jumlahCetak < n); 
        System.out.println();
        scanner.close();
    }
}