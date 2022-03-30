package controller;

import bo.BOFactory;
import bo.Custom.EmployeeBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.EmployeeDTO;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import view.tm.EmployeeTM;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Optional;
import java.util.regex.Pattern;

public class EmployeeFormController {

    public TableColumn colemail;
    public CheckBox radiobtn;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtFname;

    @FXML
    private JFXTextField txtaddr;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtmobile;

    @FXML
    private JFXTextField txtPs;

    @FXML
    private JFXTextField txtUn;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<EmployeeTM> tblEmployee;

    @FXML
    private TableColumn<?, ?> colnic;

    @FXML
    private TableColumn<?, ?> colfullname;

    @FXML
    private TableColumn<?, ?> coladdr;

    @FXML
    private TableColumn<?, ?> colmobile;

    @FXML
    private TableColumn<?, ?> colrole;

    @FXML
    private TableColumn<?, ?> colOPt;

    @FXML
    private JFXTextField txtRole;
    EmployeeBO empbo;
    ObservableList<EmployeeTM> employeeObservableList= FXCollections.observableArrayList();
    public void initialize() throws Exception {
        empbo= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Employee);

        colnic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colfullname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        coladdr.setCellValueFactory(new PropertyValueFactory<>("addr"));
        colmobile.setCellValueFactory(new PropertyValueFactory<>("mobi"));
        colrole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colOPt.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadALlData();

        tblEmployee.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });

    }
    public void setData(EmployeeTM tm){
        txtNic.setText(tm.getNIC());
        txtFname.setText(tm.getFname());
        txtmobile.setText(String.valueOf(tm.getMobi()));
        txtRole.setText(tm.getRole());
        txtaddr.setText(tm.getAddr());
        txtEmail.setText(tm.getEmail());
    }
    public void loadALlData() throws Exception {
        employeeObservableList.clear();
        ArrayList<EmployeeDTO> alist=empbo.getAllEmployee();
        for (EmployeeDTO dto:alist){
            Button btn=new Button("Remove");
         EmployeeTM employeeTM=new EmployeeTM(dto.getNIC(),dto.getUserFullName(),dto.getAdddress(),dto.getMobileNo(),dto.getRole(),dto.getEmail(),btn);
         employeeObservableList.add(employeeTM);
            btn.setOnAction(event -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (empbo.deleteEmployee(employeeTM.getNIC())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadALlData();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tblEmployee.setItems(employeeObservableList);
    }
    public void clearAll(){
        txtUn.setText("");
        txtaddr.setText("");
        txtEmail.setText("");
        txtFname.setText("");
        txtmobile.setText("");
        txtNic.setText("");
        txtPs.setText("");
        txtRole.setText("");
        txtNic.requestFocus();
    }
    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
        txtmobile.setFocusColor(Paint.valueOf("blue"));
        txtEmail.setFocusColor(Paint.valueOf("blue"));
        txtNic.setFocusColor(Paint.valueOf("blue"));
        txtFname.setFocusColor(Paint.valueOf("blue"));
        txtRole.setFocusColor(Paint.valueOf("blue"));

        if (Pattern.compile("^[0-9]{9}[vVxX]$").matcher(txtNic.getText()).matches()) {
            if (Pattern.compile("^[A-z]{3,}[ ][A-z]{2,}$").matcher(txtFname.getText()).matches()) {
                if (Pattern.compile("^[A-z]{1,}$").matcher(txtRole.getText()).matches()) {
                    if (Pattern.compile("^(.+)@(.+)$").matcher(txtEmail.getText()).matches()) {
                        if (Pattern.compile("^[0-9]{10}$").matcher(txtmobile.getText()).matches()) {

                            boolean isAdded = empbo.addEmployee(new EmployeeDTO(txtNic.getText(), Integer.parseInt(txtmobile.getText()), txtFname.getText(), txtUn.getText(), txtPs.getText(),
                                    txtRole.getText(), txtEmail.getText(), txtaddr.getText()));
                            if (isAdded) {
                                clearAll();
                                loadALlData();
                                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added Successfull").show();
                            }
                        } else {
                            txtmobile.setFocusColor(Paint.valueOf("red"));
                            txtmobile.requestFocus();
                        }

                    } else {
                        txtEmail.setFocusColor(Paint.valueOf("red"));
                        txtEmail.requestFocus();
                    }
                } else {
                    txtRole.setFocusColor(Paint.valueOf("red"));
                    txtRole.requestFocus();
                }


            } else {
                txtFname.setFocusColor(Paint.valueOf("red"));
                txtFname.requestFocus();
            }

        } else {
            txtNic.setFocusColor(Paint.valueOf("red"));
            txtNic.requestFocus();
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {

        boolean isUpdated=empbo.UpdateEmployee(new EmployeeDTO(txtNic.getText(),Integer.parseInt(txtmobile.getText()),txtFname.getText(),
                txtUn.getText(),txtPs.getText(),txtRole.getText(),txtEmail.getText(),txtaddr.getText()));
        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"Employee details  sccessfully changed").show();
            clearAll();
            loadALlData();
        }else {
            new Alert(Alert.AlertType.ERROR,"Update error");
        }

    }

    public void rdioBtnOnAction(ActionEvent actionEvent) {


    }

    public void rdioBtnOnMouseClick(MouseEvent mouseEvent) {
        if (radiobtn.isSelected()){
            txtUn.setText(txtNic.getText());
        }
    }

    public void NICOnKeyRelassed(KeyEvent keyEvent) {
        txtUn.setText(txtNic.getText());
    }
}
