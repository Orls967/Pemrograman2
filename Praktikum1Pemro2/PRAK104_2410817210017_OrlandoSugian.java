package Praktikum1Pemro2;

import java.util.Scanner;
public class PRAK104_2410817210017_OrlandoSugian {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int skorAbu = 0;
        int skorBagas = 0;

        char[] tanganAbu = new char[3];
        char[] tanganBagas = new char[3];

        System.out.print("Tangan Abu: ");
        tanganAbu[0] = scanner.next().charAt(0);
        tanganAbu[1] = scanner.next().charAt(0);
        tanganAbu[2] = scanner.next().charAt(0);

        System.out.print("Tangan Bagas: ");
        tanganBagas[0] = scanner.next().charAt(0);
        tanganBagas[1] = scanner.next().charAt(0);
        tanganBagas[2] = scanner.next().charAt(0);

        for (int i = 0; i < 3; i++) {
        	char abu = tanganAbu[i];
            char bagas = tanganBagas[i];

            if ((abu == 'B' && bagas == 'G') || (abu == 'G' && bagas == 'K') || (abu == 'K' && bagas == 'B')) {
                skorAbu++; 
            } else if ((bagas == 'B' && abu == 'G') || (bagas == 'G' && abu == 'K') || (bagas == 'K' && abu == 'B')) {
                skorBagas++; 
            }
           
        } if (skorAbu > skorBagas) {
            System.out.println("Abu");
        } else if (skorBagas > skorAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }
        
        scanner.close();
	}
}