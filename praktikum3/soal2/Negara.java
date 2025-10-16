package praktikum3.soal2;

public class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggalKemerdekaan;
    private int bulanKemerdekaan;
    private int tahunKemerdekaan;

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggal, int bulan, int tahun) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggal;
        this.bulanKemerdekaan = bulan;
        this.tahunKemerdekaan = tahun;
    }

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = 0; 
        this.bulanKemerdekaan = 0;   
        this.tahunKemerdekaan = 0;   
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKepemimpinan() {
        return jenisKepemimpinan;
    }

    public String getNamaPemimpin() {
        return namaPemimpin;
    }

    public int getTanggalKemerdekaan() {
        return tanggalKemerdekaan;
    }

    public int getBulanKemerdekaan() {
        return bulanKemerdekaan;
    }

    public int getTahunKemerdekaan() {
        return tahunKemerdekaan;
    }
}