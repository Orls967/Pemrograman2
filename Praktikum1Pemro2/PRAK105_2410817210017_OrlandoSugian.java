package Praktikum1Pemro2;

import java.util.Scanner;
import java.util.Locale;
public class PRAK105_2410817210017_OrlandoSugian {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        final double PI = 3.14;

        System.out.print("Masukkan jari-jari: ");
        double jariJari = scanner.nextDouble();
        
        System.out.print("Masukkan tinggi: ");
        
        double tinggi = scanner.nextDouble();
        double volume = PI * jariJari * jariJari * tinggi;	
        
        System.out.printf(Locale.US, "Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3%n",
                jariJari, tinggi, volume);
                
        scanner.close();
    }
}
