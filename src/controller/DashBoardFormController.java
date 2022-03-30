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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public JFXButton btnReturn;
    public JFXButton btnCloseApp;
    public Label lblun;
    public Label lbldashun;
    public JFXTextField txtdash;


    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnItems;

    @FXML
    private JFXButton btnsupplier;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private JFXButton btnEmp;

    @FXML
    private JFXButton btnReports;

    @FXML
    private JFXButton btnlogout;

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblcountOfExp;

    @FXML
    private Hyperlink hypExpShowDt;

    @FXML
    private Label lblFname;

    @FXML
    private Label lblAdmin;

    @FXML
    private Label lblAdmin1;

    @FXML
    private JFXPasswordField txtPs;

    @FXML
    private Label lblcountThismonthExp;

    @FXML
    private Hyperlink hypExpthisMonth;

    @FXML
    private Label lblcountOutStock;

    @FXML
    private Hyperlink hypOutStock;

    @FXML
    private Label lblcountLowStock;
    EmployeeBO empbo;
   public static String un=null;
    public void initialize() throws Exception {
        empbo= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Employee);
        initUi("HomeForm.fxml");
        System.out.println(un+"  m n");
        if (un!=null){
            EmployeeDTO ep=empbo.GetEmployee(un);

           if (ep.getRole().equalsIgnoreCase("user")){
               btnItems.setDisable(true);
               btnsupplier.setDisable(true);
               btnEmp.setDisable(true);
               btnReports.setDisable(true);
           }

        }

    }
    @FXML
    private Hyperlink hypShowDetails;

    @FXML
    void btnEmpOnAction(ActionEvent event) throws IOException {
        initUi("EmployeeForm.fxml");
    }
    public void setUser(String id){
        un=id;
        System.out.println(id);
        System.out.println(un);


//        txtdash.setText(id);
    }

    @FXML
    void btnItemsOnAction(ActionEvent event) throws IOException {
        initUi("ItemForm.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/LoginForm.fxml"))));
        stage.centerOnScreen();
    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) throws IOException {
        initUi("PaymentForm.fxml");
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) throws IOException {
        initUi("IncomeReportsForm.fxml");

    }

    @FXML
    void btnhomeOnAction(ActionEvent event) throws IOException {
        initUi("HomeForm.fxml");
    }

    @FXML
    void btnsupplierOnAction(ActionEvent event) throws IOException {
        initUi("SupplierForm.fxml");
    }


    private void initUi(String loc) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+loc)));

    }

    public void btnReturnOnAction(ActionEvent actionEvent) throws IOException {
        initUi("ReturnForm.fxml");

    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
