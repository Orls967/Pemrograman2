package praktikum2.PRAK202_2410817210017_OrlandoSugian;

public class Soal2Main {
	public static void main(String[]args) {
		Kopi kopi1 = new Kopi();
		kopi1.namaKopi= "Espresso";
		kopi1.ukuran= "Medium";
		kopi1.harga= 25000;
		
		kopi1.info();
		kopi1.setPembeli("Alice");
		System.out.println("Pembeli kopi: " + kopi1.getPembeli());
		System.out.println("Pajak kopi: Rp. " + kopi1.getPajak());
	}
}
