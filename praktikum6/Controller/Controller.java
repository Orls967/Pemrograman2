package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Model.Mahasiswa; 
public class Controller implements Initializable {
	
	@FXML
    private TableView<Mahasiswa> tabelMahasiswa;

    @FXML
    private TableColumn<Mahasiswa, String> colNim;

    @FXML
    private TableColumn<Mahasiswa, String> colNama;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tabelMahasiswa.setItems(getDaftarMahasiswa());
    }

    private ObservableList<Mahasiswa> getDaftarMahasiswa() {
        return FXCollections.observableArrayList(
            new Mahasiswa(1, "John", "112233"),
            new Mahasiswa(2, "Jane", "112234"),
            new Mahasiswa(3, "Jono", "112235"),
            new Mahasiswa(4, "Agus", "112236"),
            new Mahasiswa(5, "Gojo", "112237"),
            new Mahasiswa(6, "Saitama", "112238"),
            new Mahasiswa(7, "Balmond", "112239"),
            new Mahasiswa(8, "Citlali", "112240"),
            new Mahasiswa(9, "Skirk", "112241"),
            new Mahasiswa(10, "Opah", "112242")
        );
    }
}