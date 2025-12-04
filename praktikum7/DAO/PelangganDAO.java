package DAO;

import java.util.List;
import Model.Pelanggan;

public interface PelangganDAO {
    void addPelanggan(Pelanggan pelanggan) throws Exception;
    void editPelanggan(Pelanggan pelanggan) throws Exception;
    void deletePelanggan(int id) throws Exception;
    List<Pelanggan> findAllPelanggan() throws Exception;
}