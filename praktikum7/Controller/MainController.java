package Controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import Model.Buku;
import Model.Pelanggan;
import Model.Penjualan;
import Service.BukuService;
import Service.PelangganService;
import Service.PenjualanService;

public class MainController implements Initializable {

    private PelangganService pelangganService = new PelangganService();
    private BukuService bukuService = new BukuService();
    private PenjualanService penjualanService = new PenjualanService();

    @FXML private TextField txtNama, txtEmail, txtTelepon;
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colNamaPelanggan;
    @FXML private TableColumn<Pelanggan, String> colEmailPelanggan;
    @FXML private TableColumn<Pelanggan, String> colTeleponPelanggan;
    private int selectedPelangganId = 0;

    @FXML private TextField txtJudul, txtPenulis, txtHarga, txtStok;
    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, String> colJudul;
    @FXML private TableColumn<Buku, String> colPenulis;
    @FXML private TableColumn<Buku, Double> colHarga;
    @FXML private TableColumn<Buku, Integer> colStok;
    private int selectedBukuId = 0;

    @FXML private ComboBox<Pelanggan> cbPelanggan;
    @FXML private ComboBox<Buku> cbBuku;          
    @FXML private TextField txtJumlahJual;
    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, String> colJualPelanggan;
    @FXML private TableColumn<Penjualan, String> colJualBuku;
    @FXML private TableColumn<Penjualan, Integer> colJualJumlah;
    @FXML private TableColumn<Penjualan, Double> colJualTotal;
    @FXML private TableColumn<Penjualan, Date> colJualTanggal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTablePelanggan();
        setupTableBuku();
        setupTablePenjualan();
        loadAllData();
    }

    private void loadAllData() {
        loadDataPelanggan();
        loadDataBuku();
        loadDataPenjualan();
        refreshComboBox();
    }

    private void refreshComboBox() {
        try {
            cbPelanggan.setItems(FXCollections.observableArrayList(pelangganService.getAllPelanggan()));
            cbBuku.setItems(FXCollections.observableArrayList(bukuService.getAllBuku()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupTablePelanggan() {
        colNamaPelanggan.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colEmailPelanggan.setCellValueFactory(cell -> cell.getValue().emailProperty());
        colTeleponPelanggan.setCellValueFactory(cell -> cell.getValue().teleponProperty());

        tblPelanggan.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
            if (newVal != null) {
                selectedPelangganId = newVal.getPelangganId();
                txtNama.setText(newVal.getNama());
                txtEmail.setText(newVal.getEmail());
                txtTelepon.setText(newVal.getTelepon());
            }
        });
    }

    private void loadDataPelanggan() {
        try {
            tblPelanggan.setItems(FXCollections.observableArrayList(pelangganService.getAllPelanggan()));
        } catch (Exception e) { showAlert("Error Load Pelanggan", e.getMessage()); }
    }

    @FXML 
    void onAddPelanggan(ActionEvent event) {
        try {
            pelangganService.addPelanggan(txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
            showAlert("Sukses", "Pelanggan berhasil ditambah!");
            clearFormPelanggan();
            loadAllData(); 
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML
    void onEditPelanggan(ActionEvent event) {
        if (selectedPelangganId == 0) { showAlert("Peringatan", "Pilih data dulu!"); return; }
        try {
            pelangganService.editPelanggan(selectedPelangganId, txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
            showAlert("Sukses", "Pelanggan berhasil diupdate!");
            clearFormPelanggan();
            loadAllData();
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML
    void onDeletePelanggan(ActionEvent event) {
        if (selectedPelangganId == 0) { showAlert("Peringatan", "Pilih data dulu!"); return; }
        try {
            pelangganService.deletePelanggan(selectedPelangganId);
            showAlert("Sukses", "Pelanggan berhasil dihapus!");
            clearFormPelanggan();
            loadAllData();
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }
    
    private void clearFormPelanggan() {
        txtNama.clear(); txtEmail.clear(); txtTelepon.clear();
        selectedPelangganId = 0;
    }

    private void setupTableBuku() {
        colJudul.setCellValueFactory(cell -> cell.getValue().judulProperty());
        colPenulis.setCellValueFactory(cell -> cell.getValue().penulisProperty());
        colHarga.setCellValueFactory(cell -> cell.getValue().hargaProperty().asObject());
        colStok.setCellValueFactory(cell -> cell.getValue().stokProperty().asObject());

        tblBuku.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
            if (newVal != null) {
                selectedBukuId = newVal.getBukuId();
                txtJudul.setText(newVal.getJudul());
                txtPenulis.setText(newVal.getPenulis());
                txtHarga.setText(String.valueOf(newVal.getHarga()));
                txtStok.setText(String.valueOf(newVal.getStok()));
            }
        });
    }

    private void loadDataBuku() {
        try {
            tblBuku.setItems(FXCollections.observableArrayList(bukuService.getAllBuku()));
        } catch (Exception e) { showAlert("Error Load Buku", e.getMessage()); }
    }

    @FXML
    void onAddBuku(ActionEvent event) {
        try {
            bukuService.addBuku(txtJudul.getText(), txtPenulis.getText(), txtHarga.getText(), txtStok.getText());
            showAlert("Sukses", "Buku berhasil ditambah!");
            clearFormBuku();
            loadAllData();
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML
    void onEditBuku(ActionEvent event) {
        if (selectedBukuId == 0) { showAlert("Peringatan", "Pilih buku dulu!"); return; }
        try {
            bukuService.editBuku(selectedBukuId, txtJudul.getText(), txtPenulis.getText(), txtHarga.getText(), txtStok.getText());
            showAlert("Sukses", "Buku berhasil diupdate!");
            clearFormBuku();
            loadAllData();
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML
    void onDeleteBuku(ActionEvent event) {
        if (selectedBukuId == 0) { showAlert("Peringatan", "Pilih buku dulu!"); return; }
        try {
            bukuService.deleteBuku(selectedBukuId);
            showAlert("Sukses", "Buku dihapus!");
            clearFormBuku();
            loadAllData();
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    private void clearFormBuku() {
        txtJudul.clear(); txtPenulis.clear(); txtHarga.clear(); txtStok.clear();
        selectedBukuId = 0;
    }

    private void setupTablePenjualan() {
        colJualPelanggan.setCellValueFactory(cell -> cell.getValue().getPelanggan().namaProperty());
        colJualBuku.setCellValueFactory(cell -> cell.getValue().getBuku().judulProperty());
        colJualJumlah.setCellValueFactory(cell -> cell.getValue().jumlahProperty().asObject());
        colJualTotal.setCellValueFactory(cell -> cell.getValue().totalHargaProperty().asObject());
        colJualTanggal.setCellValueFactory(cell -> cell.getValue().tanggalProperty());
    }

    private void loadDataPenjualan() {
        try {
            tblPenjualan.setItems(FXCollections.observableArrayList(penjualanService.getAllPenjualan()));
        } catch (Exception e) { showAlert("Error Load Penjualan", e.getMessage()); }
    }

    @FXML
    void onAddPenjualan(ActionEvent event) {
        try {
            Pelanggan p = cbPelanggan.getValue();
            Buku b = cbBuku.getValue();
            penjualanService.addPenjualan(p, b, txtJumlahJual.getText());
            
            showAlert("Sukses", "Transaksi Berhasil!");
            txtJumlahJual.clear();
            cbPelanggan.getSelectionModel().clearSelection();
            cbBuku.getSelectionModel().clearSelection();
            loadAllData(); 
        } catch (Exception e) {
            showAlert("Gagal Transaksi", e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}