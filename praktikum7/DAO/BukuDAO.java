package DAO;

import java.util.List;
import Model.Buku;

public interface BukuDAO {
    void addBuku(Buku buku) throws Exception;
    void editBuku(Buku buku) throws Exception;
    void deleteBuku(int id) throws Exception;
    List<Buku> findAllBuku() throws Exception;
}