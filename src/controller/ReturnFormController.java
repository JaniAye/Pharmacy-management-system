package controller;

import bo.BOFactory;
import bo.Custom.DetailsBO;
import bo.Custom.ItemsReturnBO;
import bo.Custom.OrderBO;
import bo.Custom.OrderDetailsBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import entity.Odetails;
import entity.OrderDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import view.tm.ItemTM;
import view.tm.OdetailsTM;
import view.tm.ReturnTM;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;

public class ReturnFormController {

    public JFXTextField txtOrderDT;
    public TableColumn colprice;
    public TableColumn colItCode;
    public JFXButton btnCancel;
    public JFXButton btnReturnItem;
    public TableColumn colrstatus;
    public JFXTextField txtExpDate;
    public JFXTextField txtmanufacturedate;
    public JFXTextField txtqty;
    public JFXTextField txtup;
    public JFXTextField txtitname;
    public JFXTextField txtReason;
    public JFXTextField txtReturnMoney;
    public JFXTextField txtReturnQTY;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtOid;

    @FXML
    private JFXButton btnReturnAll;

    @FXML
    private JFXButton btnReturnAll1;

    @FXML
    private TableView<ReturnTM> tblReturn;

    @FXML
    private TableColumn<?, ?> colitemname;

    @FXML
    private TableColumn<?, ?> colup;

    @FXML
    private TableColumn<?, ?> colquan;

    @FXML
    private TableColumn<?, ?> colmanudate;

    @FXML
    private TableColumn<?, ?> colexp;

    @FXML
    private TableColumn<?, ?> colitemcode;
    @FXML
    private JFXTextField txtOrderTime;

    @FXML
    private JFXTextField txtTot;
    @FXML
    private JFXButton btnReturnAll11;
    private OrderBO orderBO;
    private DetailsBO detailsBO;
    private OrderDetailsBO odbo;
    private String cde;
    private ItemsReturnBO returnBO;

    public void initialize(){
        btnReturnItem.setDisable(true);
        orderBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.ORDER);
        detailsBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Details);
        odbo = BOFactory.getInstance().getbo(BOFactory.BOTYPE.OrderDetails);
        returnBO=BOFactory.getInstance().getbo(BOFactory.BOTYPE.ITEMRETURN);


        colitemname.setCellValueFactory(new PropertyValueFactory<>("ItName"));
        colup.setCellValueFactory(new PropertyValueFactory<>("up"));
        colquan.setCellValueFactory(new PropertyValueFactory<>("quan"));
        colmanudate.setCellValueFactory(new PropertyValueFactory<>("MDate"));
        colexp.setCellValueFactory(new PropertyValueFactory<>("ExpDate"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("totprice"));
        colItCode.setCellValueFactory(new PropertyValueFactory<>("Itcode"));

        tblReturn.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });

    }
    ObservableList<ReturnTM> olist= FXCollections.observableArrayList();
    private void setData(ReturnTM tm) {
        txtitname.setText(tm.getItName());
        txtup.setText(tm.getUp()+"");
        txtqty.setText(tm.getQuan()+"");
        txtmanufacturedate.setText(tm.getMDate());
        txtExpDate.setText(tm.getExpDate());
        cde=tm.getItcode();
        txtReturnQTY.requestFocus();

    }
    private void loadal() throws Exception {
        ArrayList<ReturnDTO> orders = odbo.GetOD(txtOid.getText());
        if (orders != null) {
            for (ReturnDTO dt : orders) {
                ReturnTM odt = new ReturnTM(dt.getItcode(), dt.getItName(), dt.getUp(), dt.getQuan(), dt.getMDate(), dt.getExpDate(),
                        dt.getTotprice());
                olist.add(odt);


            }
            txtReturnQTY.requestFocus();
            tblReturn.setItems(olist);
        }else {
        new Alert(Alert.AlertType.CONFIRMATION,"No records found.");
        clr();
    }
    }



    @FXML
    void txtOidOnAction(ActionEvent event) throws Exception {


    }
    public void clr(){
        txtOid.clear();
        txtTot.clear();
        txtOrderTime.clear();
        txtOrderDT.clear();
        txtOid.requestFocus();
    }
    public void btnCancelOnAction(ActionEvent actionEvent) {

    }

    public void btnReturnItemOnAction(ActionEvent actionEvent) throws Exception {
        olist.clear();
        if (Pattern.compile("^[0-9]{1,}$").matcher(txtReturnQTY.getText()).matches()){
            DateFormat datefmt=new SimpleDateFormat("yyy/MM/dd");

            Date date=new Date();
            if (Double.parseDouble(txtqty.getText())>=Double.parseDouble(txtReturnQTY.getText())){
                double c=Double.parseDouble(txtqty.getText())- Double.parseDouble(txtReturnQTY.getText());
                System.out.println(c+"");
                boolean issave= returnBO.AddReturnItems(new ItemsReturnDTO(cde,txtOid.getText(),"R002",Double.parseDouble(txtReturnQTY.getText()),datefmt.format(date),
                        Double.parseDouble(txtReturnMoney.getText()),txtReason.getText()),new UpdateOrdersDtailsDTO(txtOid.getText(),c,c*(Double.parseDouble(txtup.getText()))));
                if (issave){
                    new Alert(Alert.AlertType.CONFIRMATION,"Item returned").show();
                    loadal();
                    txtReason.clear();
                    txtReturnMoney.clear();
                    txtReturnQTY.clear();
                    txtitname.clear();
                    txtup.clear();
                    txtqty.clear();
                    txtmanufacturedate.clear();
                    txtExpDate.clear();

                }
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid Return amount").show();
                txtReturnQTY.setFocusColor(Paint.valueOf("red"));
                txtReturnQTY.requestFocus();
            }
        }else {
            txtReturnQTY.setFocusColor(Paint.valueOf("red"));
            txtReturnQTY.requestFocus();
        }




    }

    public void txtReturnQtyOnKeyRelease(KeyEvent keyEvent) {

            if (Double.parseDouble(txtReturnQTY.getText())<=Double.parseDouble(txtqty.getText())){
                btnReturnItem.setDisable(false);
                txtReturnQTY.setFocusColor(Paint.valueOf("blue"));
                txtReturnMoney.setText(String.valueOf(Double.parseDouble(txtup.getText())*Double.parseDouble(txtReturnQTY.getText())));

            }else {
                btnReturnItem.setDisable(true);
                txtReturnQTY.setFocusColor(Paint.valueOf("red"));
                txtReturnMoney.setText(String.valueOf(0));

            }


    }


    public void txtoidKeyRealsed(KeyEvent keyEvent) throws Exception {
        if (Pattern.compile("^(OID00)[0-9]{1,}$").matcher(txtOid.getText()).matches()){
            txtOid.setFocusColor(Paint.valueOf("blue"));
            olist.clear();
            DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
            Date date=new Date();
            OrderDTO orderDTO=orderBO.getItem(txtOid.getText());
            int i = odbo.dateDiff(dateFormat.format(date), orderDTO.getOdate());

            System.out.println(i+" days");
            if (orderDTO==null){
                new Alert(Alert.AlertType.ERROR,"No Records Found ").show();
                clr();
            }else {
                if (i<=7) {
                    txtTot.setText(String.valueOf(orderDTO.getTotCost()));
                    txtOrderTime.setText(orderDTO.getOtime());
                    txtOrderDT.setText(orderDTO.getOdate());
                    loadal();
                }else {
                    new Alert(Alert.AlertType.ERROR,"This order is older than 7 days, Can't Return ").show();
                    txtOid.requestFocus();
                    txtOid.setFocusColor(Paint.valueOf("red"));


                }

            }
        }else {
            olist.clear();
            txtOid.setFocusColor(Paint.valueOf("red"));
        }
    }
}
