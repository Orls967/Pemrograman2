package Service; 

import java.util.List;
import DAO.PelangganDAO;
import DAO.impl.PelangganDAOimpl;
import Model.Pelanggan;

public class PelangganService {
    
    private final PelangganDAO pelangganDao = new PelangganDAOimpl();

    public List<Pelanggan> getAllPelanggan() throws Exception {
        return pelangganDao.findAllPelanggan();
    }

    public void addPelanggan(String nama, String email, String telepon) throws Exception {
        cekValidasi(nama, email, telepon); 
        
        Pelanggan p = new Pelanggan(nama, email, telepon);
        pelangganDao.addPelanggan(p);
    }

    public void editPelanggan(int id, String nama, String email, String telepon) throws Exception {
        cekValidasi(nama, email, telepon);
        
        Pelanggan p = new Pelanggan(id, nama, email, telepon);
        pelangganDao.editPelanggan(p);
    }

    public void deletePelanggan(int id) throws Exception {
        pelangganDao.deletePelanggan(id);
    }

    private void cekValidasi(String nama, String email, String telepon) throws Exception {
        if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
            throw new Exception("Semua kolom wajib diisi!");
        }
        if (nama.matches(".*\\d.*")) {
            throw new Exception("Nama tidak boleh mengandung angka!");
        }
        if (!email.contains("@")) {
            throw new Exception("Format email salah (harus pakai @)!");
        }
        if (!telepon.matches("\\d+")) {
            throw new Exception("Nomor telepon harus berupa angka saja!");
        }
    }
}