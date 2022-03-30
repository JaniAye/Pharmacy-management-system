package controller;

import bo.BOFactory;
import bo.Custom.EmployeeBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.EmployeeDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;

import javax.swing.tree.AbstractLayoutCache;

public class ProfileFormController {

    public JFXTextField txtnewpass;
    public JFXButton btnupd;
    public JFXButton btnChange;
    @FXML
    private JFXTextField txtnic;

    @FXML
    private JFXTextField txtmobile;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtrole;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXTextField txtpasseord;

    @FXML
    private JFXTextField txtConfPS;


    EmployeeBO employeeBO;
    public static String un;
    public void initialize(){
        employeeBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Employee);
        if (un!=null){
            try {
                EmployeeDTO employeeDTO = employeeBO.GetEmployee(un);
                txtnic.setText(employeeDTO.getNIC());
                txtAddress.setText(employeeDTO.getAdddress());
                txtEmail.setText(employeeDTO.getEmail());
                txtmobile.setText(String.valueOf(employeeDTO.getMobileNo()));
                txtrole.setText(employeeDTO.getRole());
                txtusername.setText(employeeDTO.getUn());
                txtname.setText(employeeDTO.getUserFullName());
                txtpasseord.setText(employeeDTO.getPass());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        loadDetails();
    }
    public void setnaemofuser(String id){

        un=id;
    }
    public void loadDetails(){

            try {


            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    @FXML
    void btnChangeOnAction(ActionEvent event) {

    }

    public void btnupdOnAction(ActionEvent actionEvent) {
        if (txtnewpass.getText().length()!=0 && txtnewpass.getText().length()!=0){

            if (txtnewpass.getText().equalsIgnoreCase(txtConfPS.getText())){
                try {
                    boolean b = employeeBO.UpdateEmployee(new EmployeeDTO(txtnic.getText(), Integer.parseInt(txtmobile.getText()), txtname.getText(),
                            txtusername.getText(), txtnewpass.getText(),
                            txtrole.getText(), txtEmail.getText(), txtAddress.getText()));
                    if (b){
                        new Alert(Alert.AlertType.CONFIRMATION,"Password Changed successfully").show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"new password and confirm password didn't match").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Enter New password and conform password ").show();
            txtnewpass.requestFocus();
            txtnewpass.setFocusColor(Paint.valueOf("red"));
        }
    }
}
