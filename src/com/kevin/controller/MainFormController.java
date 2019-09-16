package com.kevin.controller;

import com.kevin.entity.Category;
import com.kevin.entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public Button btnUp;
    @FXML
    private TextField isiNama;
    @FXML
    private TextField isiHarga;
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


    private ComboBox isiCat;
    @FXML


    private void saveCat(ActionEvent actionEvent) {
		isiCat.getValue().setItems(masCat.getText());
    }

    @FXML
    private void actionSave(ActionEvent actionEvent) {
		Item i=new Item();
        i.setName(isiNama.getText().trim());
        i.setPrice(isiHarga.getText().trim());
		i.setCategory(isiCat.getText().trim());
        items.add(i);
    }

    @FXML
    private void actionReset(ActionEvent actionEvent) {
		isiNama.clear();
		isiHarga.clear();
		isiCat.clear();
    }

    @FXML
    private void actionUpdate(ActionEvent actionEvent) {
        btnUp.setDisable(false);
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

        };

    public ObservableList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ObservableList<Category> categories) {
        this.categories = categories;
    }
}

