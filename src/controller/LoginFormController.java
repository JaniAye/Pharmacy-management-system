package controller;

import bo.BOFactory;
import bo.Custom.EmployeeBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.EmployeeDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class LoginFormController {

    public AnchorPane root;
    public JFXPasswordField psfield;

    @FXML
    private JFXTextField txtUn;



    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnClr;
    private EmployeeBO empBo;
    public void initialize(){
        empBo= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Employee);

    }

    @FXML
    void btnClrOnAction(ActionEvent event) {

    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws Exception {

        ArrayList<EmployeeDTO> allEmployee = empBo.getAllEmployee();
        for (EmployeeDTO emp:allEmployee) {
            if (txtUn.getText().equalsIgnoreCase(emp.getUn())&& psfield.getText().equalsIgnoreCase(emp.getPass())){
              //  FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/DashBoardForm.fxml"));

//           Stage stage= (Stage) root.getScene().getWindow();
//           stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
//             stage.setTitle(txtUn.getText());
//             stage.centerOnScreen();

                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/DashBoardForm.fxml"));
                Parent root=fxmlLoader.load();
                DashBoardFormController dashBoardFormController=fxmlLoader.getController();
                dashBoardFormController.setUser(txtUn.getText());

                FXMLLoader fxmlLoader2=new FXMLLoader(getClass().getResource("../view/HomeForm.fxml"));
                Parent root2=fxmlLoader2.load();
                HomeFormController homeFormController=fxmlLoader2.getController();
                homeFormController.setUser(txtUn.getText());

                FXMLLoader fxmlLoader3=new FXMLLoader(getClass().getResource("../view/ProfileForm.fxml"));
                Parent root3=fxmlLoader3.load();
                ProfileFormController profileFormController=fxmlLoader3.getController();
                profileFormController.setnaemofuser(txtUn.getText());



                Stage stage1 = new Stage();
                stage1.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
                stage1.show();

                Stage stage= (Stage) txtUn.getScene().getWindow();
                stage.close();
//                stage1.initStyle(StageStyle.UNDECORATED);
                return;

            }
        }

            new Alert(Alert.AlertType.ERROR,"Invalid user name or password ").show();




    }

    @FXML
    void txtUnOnAction(ActionEvent event) {

    }

}
