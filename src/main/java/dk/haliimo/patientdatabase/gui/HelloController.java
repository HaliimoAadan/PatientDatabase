package dk.haliimo.patientdatabase.gui;

import dk.haliimo.patientdatabase.be.Patient;
import dk.haliimo.patientdatabase.bll.BLLManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    public TableColumn columnId;
    public TableColumn columnName;
    public TableColumn columnEmail;
    public TableColumn columnDiagnosis;
    public TableView tablePatients;

    public void onDeleteClick(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readDataIntoList();
    }

    private void readDataIntoList() {

        ObservableList<Patient> patientList =
                FXCollections.observableArrayList();

        BLLManager bllManager = BLLManager.getInstance();
        patientList.addAll(bllManager.getAllPatients());

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnDiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        tablePatients.setItems(patientList);
    }
}