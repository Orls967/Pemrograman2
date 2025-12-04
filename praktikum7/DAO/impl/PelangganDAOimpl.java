package DAO.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DAO.PelangganDAO;
import Model.Pelanggan;
import Util.DatabaseHelper;

public class PelangganDAOimpl implements PelangganDAO {

    @Override
    public void addPelanggan(Pelanggan pelanggan) throws Exception {
        String sql = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pelanggan.getNama());
            ps.setString(2, pelanggan.getEmail());
            ps.setString(3, pelanggan.getTelepon());
            ps.executeUpdate();
        }
    }

    @Override
    public void editPelanggan(Pelanggan pelanggan) throws Exception {
        String sql = "UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE pelanggan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pelanggan.getNama());
            ps.setString(2, pelanggan.getEmail());
            ps.setString(3, pelanggan.getTelepon());
            ps.setInt(4, pelanggan.getPelangganId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deletePelanggan(int id) throws Exception {
        String sql = "DELETE FROM pelanggan WHERE pelanggan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Pelanggan> findAllPelanggan() throws Exception {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Pelanggan(
                    rs.getInt("pelanggan_id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("telepon")
                ));
            }
        }
        return list;
    }
}