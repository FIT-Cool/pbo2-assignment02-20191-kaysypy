package com.kevin.controller;

import com.kevin.entity.Category;
import com.kevin.entity.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    @FXML
    private TextField isiNama;
    @FXML
    private TextField isiHarga;
    @FXML
    private ComboBox isiCat;
    @FXML
    private TextField masCat;
    @FXML
    private TableColumn<Item,String>  colNam;
    @FXML
    private TableColumn<Item,String>  colPrice;
    @FXML
    private TableColumn<Item, Category> colCat;
    @FXML
    private TableView<Item> itemDepartment;

    private ObservableList<Item> items;
    private ObservableList<Category> categories;

    @FXML
    private void saveCat(ActionEvent actionEvent) {
        Category c=new Category();
        c.setName(masCat.getText().trim());
        categories.add(c);
    }

    @FXML
    private void actionSave(ActionEvent actionEvent) {
    }

    @FXML
    private void actionReset(ActionEvent actionEvent) {
    }

    @FXML
    private void actionUpdate(ActionEvent actionEvent) {
    }

    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        //Fakultas f=tableDepartment.getSelectionModel().getSelectedItem();
        //txtName.setText(f.getNama());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        items= FXCollections.observableArrayList();
        itemDepartment.setItems(items);
        colNam.setCellValueFactory(data ->{
            Item i=data.getValue();
            return new SimpleStringProperty(i.getName());
        });

        colPrice.setCellValueFactory(data ->{
            Item i=data.getValue();
            return new SimpleStringProperty(String.valueOf(i.getPrice()));
        });






    }
}
