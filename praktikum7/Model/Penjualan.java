package Model;

import java.sql.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Penjualan {
    private int penjualanId;
    private IntegerProperty jumlah;
    private DoubleProperty totalHarga;
    private ObjectProperty<Date> tanggal;
    private Pelanggan pelanggan; 
    private Buku buku;           

    public Penjualan(int jumlah, double totalHarga, Date tanggal, Pelanggan pelanggan, Buku buku) {
        this.penjualanId = 0;
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleDoubleProperty(totalHarga);
        this.tanggal = new SimpleObjectProperty<>(tanggal);
        this.pelanggan = pelanggan;
        this.buku = buku;
    }

    public Penjualan(int id, int jumlah, double totalHarga, Date tanggal, Pelanggan pelanggan, Buku buku) {
        this.penjualanId = id;
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleDoubleProperty(totalHarga);
        this.tanggal = new SimpleObjectProperty<>(tanggal);
        this.pelanggan = pelanggan;
        this.buku = buku;
    }

    public int getPenjualanId() { return penjualanId; }
    public void setPenjualanId(int id) { this.penjualanId = id; }

    public IntegerProperty jumlahProperty() { return jumlah; }
    public int getJumlah() { return jumlah.get(); }
    public void setJumlah(int jumlah) { this.jumlah.set(jumlah); }

    public DoubleProperty totalHargaProperty() { return totalHarga; }
    public double getTotalHarga() { return totalHarga.get(); }
    public void setTotalHarga(double totalHarga) { this.totalHarga.set(totalHarga); }

    public ObjectProperty<Date> tanggalProperty() { return tanggal; }
    public Date getTanggal() { return tanggal.get(); }
    public void setTanggal(Date tanggal) { this.tanggal.set(tanggal); }

    public Pelanggan getPelanggan() { return pelanggan; }
    public void setPelanggan(Pelanggan pelanggan) { this.pelanggan = pelanggan; }

    public Buku getBuku() { return buku; }
    public void setBuku(Buku buku) { this.buku = buku; }
}