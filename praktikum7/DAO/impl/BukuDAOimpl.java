package DAO.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DAO.BukuDAO;
import Model.Buku;
import Util.DatabaseHelper;

public class BukuDAOimpl implements BukuDAO {

    @Override
    public void addBuku(Buku buku) throws Exception {
        String sql = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPenulis());
            ps.setDouble(3, buku.getHarga());
            ps.setInt(4, buku.getStok());
            ps.executeUpdate();
        }
    }

    @Override
    public void editBuku(Buku buku) throws Exception {
        String sql = "UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPenulis());
            ps.setDouble(3, buku.getHarga());
            ps.setInt(4, buku.getStok());
            ps.setInt(5, buku.getBukuId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteBuku(int id) throws Exception {
        String sql = "DELETE FROM buku WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Buku> findAllBuku() throws Exception {
        List<Buku> list = new ArrayList<>();
        String sql = "SELECT * FROM buku";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                ));
            }
        }
        return list;
    }
}