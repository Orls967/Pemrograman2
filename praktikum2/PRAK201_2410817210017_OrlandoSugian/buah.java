package praktikum2.PRAK201_2410817210017_OrlandoSugian;

import java.text.NumberFormat;
import java.util.Locale;

public class buah {
    
    private String namaBuah;
    private double berat;
    private double harga;
    private double jumlahBeli;

    public buah(String nama, double berat, double harga) {
        this.namaBuah = nama;
        this.berat = berat;
        this.harga = harga;
    }
    
    public void tampilkanInfo(double jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
        
        double hargaPerKg = this.harga / this.berat;
        double hargaSebelumDiskon = this.jumlahBeli * hargaPerKg;
        double kelipatanDiskon = Math.floor(this.jumlahBeli / 4);
        double totalDiskon = kelipatanDiskon * (this.harga * 0.08);
        double hargaSetelahDiskon = hargaSebelumDiskon - totalDiskon;

        NumberFormat numberFormatter = NumberFormat.getNumberInstance(Locale.US);        
        numberFormatter.setGroupingUsed(false);
        numberFormatter.setMaximumFractionDigits(2);
        numberFormatter.setMinimumFractionDigits(2);

        System.out.println("Nama Buah: " + this.namaBuah);
        System.out.println("Berat: " + this.berat);
        System.out.println("Harga: " + this.harga);
        System.out.println("Jumlah Beli: " + this.jumlahBeli + "kg");
        System.out.println("Harga Sebelum Diskon: " + numberFormatter.format(hargaSebelumDiskon).replace("Rp", "Rp"));
        System.out.println("Total Diskon: " + numberFormatter.format(totalDiskon).replace("Rp", "Rp"));
        System.out.println("Harga Setelah Diskon: " + numberFormatter.format(hargaSetelahDiskon).replace("Rp", "Rp"));
        System.out.println(); 
    }
}