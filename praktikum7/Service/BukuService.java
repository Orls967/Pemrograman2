package Service;

import java.util.List;
import DAO.BukuDAO;        
import DAO.impl.BukuDAOimpl; 
import Model.Buku;

public class BukuService {
    
    private final BukuDAO bukuDao = new BukuDAOimpl();

    public List<Buku> getAllBuku() throws Exception {
        return bukuDao.findAllBuku();
    }

    public void addBuku(String judul, String penulis, String hargaStr, String stokStr) throws Exception {
        validasiInput(judul, penulis, hargaStr, stokStr);
        
        double harga = Double.parseDouble(hargaStr);
        int stok = Integer.parseInt(stokStr);

        Buku buku = new Buku(judul, penulis, harga, stok);
        bukuDao.addBuku(buku);
    }

    public void editBuku(int id, String judul, String penulis, String hargaStr, String stokStr) throws Exception {
        validasiInput(judul, penulis, hargaStr, stokStr);
        
        double harga = Double.parseDouble(hargaStr);
        int stok = Integer.parseInt(stokStr);

        Buku buku = new Buku(id, judul, penulis, harga, stok);
        bukuDao.editBuku(buku);
    }

    public void deleteBuku(int id) throws Exception {
        bukuDao.deleteBuku(id);
    }

    private void validasiInput(String judul, String penulis, String hargaStr, String stokStr) throws Exception {
        if (judul.isEmpty() || penulis.isEmpty() || hargaStr.isEmpty() || stokStr.isEmpty()) {
            throw new Exception("Semua kolom wajib diisi!");
        }
        if (judul.matches(".*\\d.*")) {
            throw new Exception("Judul buku tidak boleh mengandung angka!");
        }
        if (penulis.matches(".*\\d.*")) {
            throw new Exception("Nama penulis tidak boleh mengandung angka!");
        }
        try {
            double h = Double.parseDouble(hargaStr); 
            if (h < 0) {
                throw new Exception("Harga tidak boleh minus!");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Harga harus berupa angka valid (Contoh: 50000)!");
        }
        try {
            int s = Integer.parseInt(stokStr); 
            if (s < 0) {
                throw new Exception("Stok tidak boleh minus!");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Stok harus berupa angka bulat (Contoh: 10)!");
        }
    }
}