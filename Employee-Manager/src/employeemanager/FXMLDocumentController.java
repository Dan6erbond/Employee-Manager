/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanager;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author greut
 */
public class FXMLDocumentController implements Initializable, Observer {

    private Company company = new Company();
    
    @FXML
    private ListView<Employee> listview;
    @FXML
    private Label nameLabel;
    @FXML
    private Label jobLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        company.addObserver(this);
        company.setSelected(company.getCEO());

        listview.setCellFactory(param -> new ListCell<Employee>() {
            @Override
            protected void updateItem(Employee item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.name == null) {
                    setText(null);
                } else {
                    setText(item.name);
                }
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        listview.setItems(null);
        
        try {
            HeadEmployee employee = (HeadEmployee)company.getSelected();
            ObservableList<Employee> employees = FXCollections.observableArrayList(employee.employees);
            listview.setItems(employees);
        } catch (Exception ignore){ }
        
        nameLabel.setText(company.getSelectedName());
        jobLabel.setText(company.getSelectedJob());
    }

    @FXML
    private void listviewClick(MouseEvent event) {
        Employee employee = listview.getSelectionModel().getSelectedItem();
        if (employee != null){
            company.setSelected(employee);
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        company.goBack();
    }

}
