package praktikum2.PRAK203_2410817210017_OrlandoSugian;

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai();

     // Pada baris ini terjadi error karena tidak ada titik koma (;) di akhir baris
     // p1.nama = "Roi"
        p1.nama = "Roi"; 
        p1.asal = "Kingdom of Orvel"; 
        p1.setJabatan("Assasin");

     // Pada baris ini 'umur' belum diinisialisasi nilainya, sehingga akan menghasilkan nilai default 0, sedangkan yang diminta pada Output adalah 17.
        p1.umur = 17; 
        
     // Pada baris ini sebenarnya tidak terjadi error, namun disesuaikan dengan Output yang diminta yaitu Nama:, bukan Nama Pegawai:.
     // System.out.println("Nama Pegawai: " + p1.getNama());
        System.out.println("Nama: " + p1.getNama());         
        System.out.println("Asal: " + p1.getAsal()); 
        System.out.println("Jabatan: " + p1.jabatan);

     // Pada baris ini juga sebenarnya tidak terjadi error, namun disesuaikan dengan Output yang diminta yaitu menggunakan tahun di belakangnya.
     // System.out.println("Umur: " + p1.umur);
        System.out.println("Umur: " + p1.umur + " tahun"); 
       }
	 } 