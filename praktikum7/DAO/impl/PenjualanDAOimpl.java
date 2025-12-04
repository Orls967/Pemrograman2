package DAO.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DAO.PenjualanDAO;
import Model.Buku;
import Model.Pelanggan;
import Model.Penjualan;
import Util.DatabaseHelper;

public class PenjualanDAOimpl implements PenjualanDAO {

    @Override
    public void addPenjualan(Penjualan p) throws Exception {
        String sqlUpdateStok = "UPDATE buku SET stok = stok - ? WHERE buku_id = ?";
        String sqlInsert = "INSERT INTO penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseHelper.getConnection()) {
            conn.setAutoCommit(false);
            
            try (PreparedStatement psStok = conn.prepareStatement(sqlUpdateStok)) {
                psStok.setInt(1, p.getJumlah());
                psStok.setInt(2, p.getBuku().getBukuId());
                psStok.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
                ps.setInt(1, p.getJumlah());
                ps.setDouble(2, p.getTotalHarga());
                ps.setDate(3, p.getTanggal());
                ps.setInt(4, p.getPelanggan().getPelangganId());
                ps.setInt(5, p.getBuku().getBukuId());
                ps.executeUpdate();
            }
            
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Penjualan> findAllPenjualan() throws Exception {
        List<Penjualan> list = new ArrayList<>();
        String sql = "SELECT p.*, pel.nama, pel.email, pel.telepon, b.judul, b.penulis, b.harga, b.stok " +
                     "FROM penjualan p " +
                     "JOIN pelanggan pel ON p.pelanggan_id = pel.pelanggan_id " +
                     "JOIN buku b ON p.buku_id = b.buku_id";

        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pelanggan pel = new Pelanggan(
                    rs.getInt("pelanggan_id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("telepon")
                );
                
                Buku bk = new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                );

                list.add(new Penjualan(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"),
                    rs.getDate("tanggal"),
                    pel,
                    bk
                ));
            }
        }
        return list;
    }
}