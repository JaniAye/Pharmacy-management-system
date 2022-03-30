package controller;

import bo.BOFactory;
import bo.Custom.EmployeeBO;
import bo.Custom.HomeBO;
import bo.Custom.ItemBO;
import com.jfoenix.controls.JFXPasswordField;
import dto.EmployeeDTO;
import dto.ItemDTO;
import dto.getAllDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.OutOfStockTM;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HomeFormController {

    public Label lbluname;
    public Hyperlink hypprofile;
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

    @FXML
    private Hyperlink hypShowDetails;
          public static String  un;
    EmployeeBO bo;
    HomeBO homeBO;
    ItemBO itemBO;
        public void initialize(){
            bo= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Employee);
            homeBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.HOME);
            itemBO=BOFactory.getInstance().getbo(BOFactory.BOTYPE.Item);


            if (un!=null){
                try {
                    EmployeeDTO emp = bo.GetEmployee(un);
                    lblFname.setText(emp.getUserFullName());
                    lbluname.setText(emp.getUn());
                    lblAdmin.setText(emp.getRole());
                    txtPs.setText(emp.getPass());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            getExp();
            outofStock();
        }
    private void outofStock(){
            int outstk=0;
            int lowStk=0;
        try {
            ArrayList<getAllDTO> getAl = itemBO.GetAllItems();
            for (getAllDTO get:getAl){
                ArrayList<ItemDTO> getdata=itemBO.getitemsAll(get.getItemName());
                double qun=0;
                for (ItemDTO itm:getdata){
                    qun+=itm.getQuan();
                }
                if (qun==0){
                    itemBO.updateStatus("Out Of Stock",get.getItCode());
                    outstk++;
                }
                else if (qun<5){
                    lowStk++;
                }
            }
            lblcountOutStock.setText(String.valueOf(outstk));
            lblcountLowStock.setText(String.valueOf(lowStk));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getExp(){
        DateFormat df=new SimpleDateFormat("YYY-MM-dd");
        DateFormat df2=new SimpleDateFormat("MM");
        Date date=new Date();

        try {
            ArrayList<getAllDTO> getAllDTOS = itemBO.GetAllItems();
            int count=0;
            int countExp=0;
            for (getAllDTO a:getAllDTOS){
                if (a.getQuan()==0){

                }else {
                    int dateDiff = homeBO.getDateDiff(a.getExpDate(), df.format(date));
                    if (dateDiff <= 0) {
                        count++;
                        itemBO.updateStatus("Expired", a.getItCode());
                    } else if (dateDiff < 30) {
                        countExp++;
                    }
                }
            }
            lblcountOfExp.setText(String.valueOf(count));
            lblcountThismonthExp.setText(String.valueOf(countExp));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void hypExpShowDtOnAction(ActionEvent event) throws IOException {
        initUi("ExpItemsForm.fxml");
    }

    @FXML
    void hypExpthisMonthOnAction(ActionEvent event) throws IOException {
       initUi("ExpInThisMOnthViewForm.fxml");
    }

    @FXML
    void hypOutStockOnAction(ActionEvent event) {
        try {
            initUi("OutOfStockForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUser(String id) {
            un=id;
    }

    @FXML
    void hypShowDetailsOnAction(ActionEvent event) {
        try {
            initUi("LowStockForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void initUi(String loc) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+loc)));
    }

    public void hypprofileOnAction(ActionEvent actionEvent) {
        try {
            initUi("ProfileForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
