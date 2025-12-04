package Service; 

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import DAO.PenjualanDAO;       
import DAO.impl.PenjualanDAOimpl; 
import Model.Buku;
import Model.Pelanggan;
import Model.Penjualan;

public class PenjualanService {
    
    private final PenjualanDAO penjualanDao = new PenjualanDAOimpl();

    public List<Penjualan> getAllPenjualan() throws Exception {
        return penjualanDao.findAllPenjualan();
    }

    public void addPenjualan(Pelanggan pelanggan, Buku buku, String jumlahStr) throws Exception {
        if (pelanggan == null) {
            throw new Exception("Harap pilih Pelanggan terlebih dahulu!");
        }
        if (buku == null) {
            throw new Exception("Harap pilih Buku yang ingin dibeli!");
        }
        if (jumlahStr == null || jumlahStr.trim().isEmpty()) {
             throw new Exception("Kolom jumlah beli wajib diisi!");
        }

        int jumlah;
        try {
            jumlah = Integer.parseInt(jumlahStr);
        } catch (NumberFormatException e) {
            throw new Exception("Jumlah beli harus berupa angka! (Input salah: " + jumlahStr + ") Contoh input : 10 ");
        }
        if (jumlah <= 0) {
            throw new Exception("Jumlah beli minimal 1 pcs!");
        }
        if (jumlah > buku.getStok()) {
            throw new Exception("Stok buku tidak cukup! (Sisa stok: " + buku.getStok() + ")");
        }
        
        double totalHarga = jumlah * buku.getHarga();
        Date tanggal = Date.valueOf(LocalDate.now());

        Penjualan p = new Penjualan(jumlah, totalHarga, tanggal, pelanggan, buku);
        penjualanDao.addPenjualan(p);
    }
}