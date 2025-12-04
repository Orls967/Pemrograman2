package DAO;

import java.util.List;
import Model.Penjualan;

public interface PenjualanDAO {
    void addPenjualan(Penjualan penjualan) throws Exception;
    List<Penjualan> findAllPenjualan() throws Exception;
}