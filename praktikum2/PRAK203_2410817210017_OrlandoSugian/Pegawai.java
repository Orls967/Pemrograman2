package praktikum2.PRAK203_2410817210017_OrlandoSugian;

 // Pada baris ini terjadi error karena nama class tidak sesuai dengan yang dipanggil di Soal3Main.java (new Pegawai())
 // public class Employee {
	public class Pegawai { 
    public String nama;

 // Pada baris ini terjadi error karena tipe data 'char' tidak dapat menampung nilai String "Kingdom of Orvel" 
 // public char asal;
    public String asal; 
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }

 // Pada baris ini terjadi error karena tipe data kembalian (return type) tidak sesuai dengan tipe data atribut 'asal' yang tadinya char, namun diperbaiki menjadi String
 // public String getAsal() {
 //    return asal;
 // }
    public String getAsal() { 
    	return asal;
    }

 // Pada baris ini terjadi error karena method 'setJabatan' tidak memiliki parameter untuk menerima nilai jabatan
 // public void setJabatan() {
 //    this.jabatan = j;
 // }
    public void setJabatan(String j) { 
    	this.jabatan = j;
    }
}