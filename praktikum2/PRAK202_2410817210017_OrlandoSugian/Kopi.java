package praktikum2.PRAK202_2410817210017_OrlandoSugian;

public class Kopi {
    
	public String namaKopi;
    public String ukuran;
    public double harga;
    private String pembeli;
    
    public void info() {
        System.out.println("Nama Kopi: " + this.namaKopi);
        System.out.println("Ukuran: " + this.ukuran);
        System.out.println("Harga: Rp. " + this.harga);
    }
    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }
    public String getPembeli() {
        return this.pembeli;
    }
    public double getPajak() {
        // Pajak adalah 11% dari harga
        return this.harga * 0.11;
    }
}