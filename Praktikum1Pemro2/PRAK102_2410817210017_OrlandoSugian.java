package Praktikum1Pemro2;

import java.util.Scanner;
public class PRAK102_2410817210017_OrlandoSugian {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int angkaAwal = scanner.nextInt();

        int i = 0;
        
        while (i < 11) {
        	if (angkaAwal % 5 == 0) {
                int hasil = (angkaAwal / 5) - 1;
                System.out.print(hasil);
            } else {
            	System.out.print(angkaAwal);
            }
            
        	if (i < 10) {
                System.out.print(", ");
            }

        	angkaAwal++;
        	i++;
        }
        System.out.println();			
        scanner.close();
    }
}