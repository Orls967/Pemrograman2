package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pelanggan {
    private int pelangganId;
    private StringProperty nama;
    private StringProperty email;
    private StringProperty telepon;

    public Pelanggan(String nama, String email, String telepon) {
        this.pelangganId = 0;
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public Pelanggan(int id, String nama, String email, String telepon) {
        this.pelangganId = id;
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public int getPelangganId() { return pelangganId; }
    public void setPelangganId(int id) { this.pelangganId = id; }

    public StringProperty namaProperty() { return nama; }
    public String getNama() { return nama.get(); }
    public void setNama(String nama) { this.nama.set(nama); }

    public StringProperty emailProperty() { return email; }
    public String getEmail() { return email.get(); }
    public void setEmail(String email) { this.email.set(email); }

    public StringProperty teleponProperty() { return telepon; }
    public String getTelepon() { return telepon.get(); }
    public void setTelepon(String telepon) { this.telepon.set(telepon); }
    
    @Override
    public String toString() {
        return getNama(); 
    }
}