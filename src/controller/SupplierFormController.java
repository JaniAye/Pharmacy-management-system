package controller;

import bo.BOFactory;
import bo.Custom.SupplierBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ItemDTO;
import dto.SupplierDTO;
import entity.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import view.tm.SupplerTM;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.regex.Pattern;

public class SupplierFormController {

    public TableView<SupplerTM> tblSupplier;
    @FXML
    private JFXTextField txtSupid;

    @FXML
    private JFXTextField txtCOmpanyName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtPno;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private TableColumn<?, ?> colsupid;

    @FXML
    private TableColumn<?, ?> colcompany;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colphoneno;

    @FXML
    private TableColumn<?, ?> coladdr;

    @FXML
    private TableColumn<?, ?> coloperator;

    @FXML
    private JFXButton btnUpdate;
        private SupplierBO bo;
    @FXML
    public void initialize() throws Exception {
        bo= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Supplier);

        colsupid.setCellValueFactory(new PropertyValueFactory<>("Supid"));
        colcompany.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        coladdr.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colphoneno.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        coloperator.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAll();
        getSupID();
        tblSupplier.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setdata(newValue);
                });
    }
    private void getSupID() throws Exception {
        String id = bo.getID();
        System.out.println(id);
        int x=0;
        if (id==null){
            txtSupid.setText("S001");
        }else {
            id=id.split("[A-z]")[1];
            x=Integer.parseInt(id)+1;
            txtSupid.setText("S00"+x);
        }

    }
    public void setdata(SupplerTM tm){
        txtSupid.setText(tm.getSupid());
        txtCOmpanyName.setText(tm.getCompanyName());
        txtEmail.setText(tm.getEmail());
        txtAddress.setText(tm.getAddress());
        txtPno.setText(String.valueOf(tm.getPhoneNo()));
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        clrAll();
    }

    @FXML
    void btnUpdOnAction(ActionEvent event) throws Exception {
        boolean isUpd=bo.UpdateSupplier(new SupplierDTO(txtSupid.getText(),txtCOmpanyName.getText(),txtAddress.getText(),txtEmail.getText(),
                Integer.parseInt(txtPno.getText())) );
        if (isUpd){
            new Alert(Alert.AlertType.CONFIRMATION,"Item Is Updated").show();
            clrAll();
            loadAll();

        }else {
            new Alert(Alert.AlertType.ERROR,"Update Fail");
        }
    }
    private void clrAll(){

        try {
            getSupID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtAddress.setText("");
        txtCOmpanyName.setText("");
        txtEmail.setText("");
        txtPno.setText("");
    }
    ObservableList<SupplerTM> oblist= FXCollections.observableArrayList();
    private void loadAll() throws Exception {
        oblist.clear();
        ArrayList<SupplierDTO> AllSup = bo.GetAllSuppliers();
        for (SupplierDTO dto : AllSup) {

            Button btn = new Button("Delete");
            SupplerTM tm = new SupplerTM(dto.getSupID(), dto.getCompanyName(), dto.getEmail(), dto.getAddress(), dto.getPhoneNO(),btn);
            oblist.add(tm);
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
                        if (bo.DeleteSupplier(tm.getSupid())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAll();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            });
        }
        tblSupplier.setItems(oblist);
    }

    public void btnsaveOnAction(ActionEvent actionEvent) throws Exception {
        txtEmail.setFocusColor(Paint.valueOf("blue"));
        txtPno.setFocusColor(Paint.valueOf("blue"));
        if (txtAddress.getText().length()!=0){
            if (Pattern.compile("^(.+)@(.+)$").matcher(txtEmail.getText()).matches()){
                if (Pattern.compile("^[0-9]{10}$").matcher(txtPno.getText()).matches()){
                    if (Pattern.compile("^[A-z]{3,}[ ][A-z]{2,}$").matcher(txtCOmpanyName.getText()).matches()) {
                        boolean isAdded=bo.SaveSupplier(new SupplierDTO(txtSupid.getText(),txtCOmpanyName.getText(),txtEmail.getText(),
                                txtAddress.getText(),Integer.parseInt(txtPno.getText())));
                        if (isAdded){
                            new Alert(Alert.AlertType.CONFIRMATION,"Added").show();
                            loadAll();
                            clrAll();
                            getSupID();
                        }else {
                            new Alert(Alert.AlertType.CONFIRMATION,"Error").show();
                        }
                    }else {
                        txtCOmpanyName.requestFocus();
                        txtCOmpanyName.setFocusColor(Paint.valueOf("red"));
                    }


                }else {
                    txtPno.setFocusColor(Paint.valueOf("red"));
                    txtPno.requestFocus();
                }

            }else {
                txtEmail.setFocusColor(Paint.valueOf("red"));
                txtEmail.requestFocus();
            }
        }else {
             new Alert(Alert.AlertType.ERROR,"Provide All Details ").show();
        }


    }
}
