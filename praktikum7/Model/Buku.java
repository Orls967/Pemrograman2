package Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Buku {
    private int bukuId;
    private StringProperty judul;
    private StringProperty penulis;
    private DoubleProperty harga;
    private IntegerProperty stok;

    public Buku(String judul, String penulis, double harga, int stok) {
        this.bukuId = 0;
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleDoubleProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public Buku(int id, String judul, String penulis, double harga, int stok) {
        this.bukuId = id;
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleDoubleProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public int getBukuId() { return bukuId; }
    public void setBukuId(int id) { this.bukuId = id; }

    public StringProperty judulProperty() { return judul; }
    public String getJudul() { return judul.get(); }
    public void setJudul(String judul) { this.judul.set(judul); }

    public StringProperty penulisProperty() { return penulis; }
    public String getPenulis() { return penulis.get(); }
    public void setPenulis(String penulis) { this.penulis.set(penulis); }

    public DoubleProperty hargaProperty() { return harga; }
    public double getHarga() { return harga.get(); }
    public void setHarga(double harga) { this.harga.set(harga); }

    public IntegerProperty stokProperty() { return stok; }
    public int getStok() { return stok.get(); }
    public void setStok(int stok) { this.stok.set(stok); }
    
    @Override
    public String toString() {
        return getJudul();
    }
}