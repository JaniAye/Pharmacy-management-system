package controller;

import bo.BOFactory;
import bo.Custom.ItemBO;
import bo.Custom.OrderBO;
import bo.Custom.PayTempBO;
import bo.Custom.PaymentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.QuaryDAO;
import db.DBConnection;
import dto.*;
import entity.allGet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import view.tm.OrdersTM;

import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class PaymentFormController {


    public JFXTextField txtExpDate;

    @FXML
    private TableColumn<?, ?> colItCode;

    @FXML
    private TableColumn<?, ?> colItName;

    @FXML
    private TableColumn<?, ?> colUp;

    @FXML
    private TableColumn<?, ?> Colqty;

    @FXML
    private TableColumn<?, ?> coltot;

    @FXML
    private TableColumn<?, ?> colopt;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtItCode;

    @FXML
    private JFXComboBox cmbItName;

    @FXML
    private JFXTextField txtAvailableQ;

    @FXML
    private JFXTextField txtUp;

    @FXML
    private JFXTextField txtQuan;

    @FXML
    private JFXTextField txtoid;

    @FXML
    private JFXTextField txtOtime;

    @FXML
    private TableView<OrdersTM>  tblPayments;

    @FXML
    private JFXTextField txtTot;

    @FXML
    private JFXComboBox cmbptype;

    @FXML
    private JFXTextField txtCash;

    @FXML
    private JFXTextField txtbal;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnCancelOrder;

    @FXML
    private JFXTextField txtUp1;

    @FXML
    private JFXButton btnUpdate;

    private PaymentBO paymentBO;
    private ItemBO itemBO;
    private OrderBO orderBO;
    private PayTempBO payTempBO;
    private String pid;

    ObservableList <String> observableList= FXCollections.observableArrayList();
    ObservableList <OrdersTM> TabelData= FXCollections.observableArrayList();
    ObservableList <String> cmblst= FXCollections.observableArrayList();

    public void initialize() throws Exception {

        btnPayment.setDisable(true);
        btnAdd.setDisable(true);
       paymentBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Payment);
       itemBO=BOFactory.getInstance().getbo(BOFactory.BOTYPE.Item);
       orderBO=BOFactory.getInstance().getbo(BOFactory.BOTYPE.ORDER);
       payTempBO=BOFactory.getInstance().getbo(BOFactory.BOTYPE.PTEMP);

        observableList.add("Cash");
        observableList.add("Card");
        cmbptype.setItems(observableList);
        getItemName();
        getOid();


    }
    private void getItemName() throws Exception {
        List<getAllDTO> getAllDTOS = itemBO.GetAllItems();
        for (getAllDTO a:getAllDTOS) {
            if (a.getQuan() == 0) {

//                boolean isdlete=itemBO.DeleteItem(a.);

            } else {

            int j = 0;
            for (int i = 0; i < cmblst.size(); i++) {
                if (a.getItemName().equalsIgnoreCase(cmblst.get(i))) {
                    j++;
                }
            }
            if (j >= 1) {

                System.out.println("same");

            } else {

                cmblst.add(a.getItemName());
            }
        }
//            System.out.println(cmblst.get(0)+"ssq");
        }
        cmbItName.setItems(cmblst);
    }
    private void clrall(){
        txtQuan.setText("");
        cmbItName.setValue("");
        txtUp.setText("");
        txtExpDate.setText("");
        txtAvailableQ.setText("");
        txtQuan.setText("");

    }
    private void getOid() throws Exception {
        String id = orderBO.getID();
        pid=paymentBO.getPid();
        System.out.println(pid);
      int x=0,x2=0;
        if (id==null){
            txtoid.setText("OID001");
            pid="P001";

        }else {
            id=id.split("[A-z]")[3];
            pid=pid.split("[A-z]")[1];
            x=Integer.parseInt(id)+1;
            x2=Integer.parseInt(pid)+1;
            txtoid.setText("OID00"+x);
            pid="P00"+x2;

        }

    }
    private void getDetailsItem() throws Exception {
        ItemDTO itdto=itemBO.getItem(cmbItName.getValue().toString());
        ArrayList<ItemDTO> itemDTOS = itemBO.getitemsAll(itdto.getItemName());
        double tot=0;
        for (ItemDTO it:itemDTOS){
            tot+=it.getQuan();
        }

        txtItCode.setText(itdto.getItemCode());
       txtUp.setText(String.valueOf(itdto.getPrice()));
       txtExpDate.setText(itdto.getExpDate());
       txtAvailableQ.setText(String.valueOf(tot));
    }
    private void TempTB(){
        try {
            String tempID = payTempBO.getTempID();
            payTempBO.DeleteItem(tempID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int have(String code){
       for (int j = 0; j <tblPayments.getItems().size() ; j++) {
            if (colItCode.getCellData(j).equals(code)){
                return j;
            }

        }
       return -1;
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (Pattern.compile("^[0-9]{1,}$").matcher(txtQuan.getText()).matches()){

            txtQuan.setFocusColor(Paint.valueOf("blue"));
            colItCode.setCellValueFactory(new PropertyValueFactory<>("itcode"));
            colItName.setCellValueFactory(new PropertyValueFactory<>("itemname"));
            colUp.setCellValueFactory(new PropertyValueFactory<>("up"));
            Colqty.setCellValueFactory(new PropertyValueFactory<>("quan"));
            coltot.setCellValueFactory(new PropertyValueFactory<>("tot"));
            colopt.setCellValueFactory(new PropertyValueFactory<>("btn"));
            Button btn=new Button("Remove");


            int i=have(txtItCode.getText());
            if (i<0){

                double tot = Double.parseDouble(txtUp.getText()) * Double.parseDouble(txtQuan.getText());

                TabelData.add(new OrdersTM(txtItCode.getText(), cmbItName.getValue().toString(), Double.parseDouble(txtUp.getText()),
                        Double.parseDouble(txtQuan.getText()), tot, btn));

            }else{
                OrdersTM ordersTM=TabelData.get(i);
                double qty=ordersTM.getQuan()+Double.parseDouble(txtQuan.getText());
                double tot1=qty*ordersTM.getUp();

                TabelData.add(new OrdersTM(ordersTM.getItcode(),ordersTM.getItemname(),ordersTM.getUp(),qty,tot1,btn));
                tblPayments.getItems().remove(i);
            }
            tblPayments.setItems(TabelData);


            btn.setOnAction(event1 -> {
                tblPayments.getItems().remove(tblPayments.getSelectionModel().getSelectedItem());
                if (tblPayments.getItems().size()==0){
                    btnPayment.setDisable(true);
                }else {
                    btnPayment.setDisable(false);
                }
                getTot();
            });

            clrall();
            tblPayments.setItems(TabelData);
            btnPayment.setDisable(false);
            getTot();
            txtbal.setText("");
            txtCash.setText("");

        }else {
            txtQuan.setFocusColor(Paint.valueOf("red"));
            txtQuan.requestFocus();
        }




    }
    private void getTot(){
        double total=0;
        for (int i = 0; i <tblPayments.getItems().size() ; i++) {
            TableColumn col=tblPayments.getColumns().get(4);

            total +=(double)col.getCellObservableValue(i).getValue();

        }
        txtTot.setText(String.valueOf(total));
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) throws Exception {

    }

    @FXML
    void btnCancelOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) throws Exception {
        TempTB();
        txtCash.setFocusColor(Paint.valueOf("blue"));
        if (Pattern.compile("^[0-9/0.0-9.0]{1,}$").matcher(txtCash.getText()).matches()){
            DateFormat datefmt=new SimpleDateFormat("yyy/MM/dd");
            DateFormat timefmt=new SimpleDateFormat("HH:MM");
            Date date=new Date();

            if (Double.parseDouble(txtTot.getText())>Double.parseDouble(txtCash.getText())){
                new Alert(Alert.AlertType.ERROR,"Invalid Amount").show();
                txtCash.requestFocus();
                txtCash.setFocusColor(Paint.valueOf("red"));
            }else {

                for (int i = 0; i <tblPayments.getItems().size() ; i++) {
                    String getname="";
                    double getquan=0;
                    TableColumn columnnm=tblPayments.getColumns().get(1);
                    TableColumn columnqu=tblPayments.getColumns().get(3);
                    getname= (String) columnnm.getCellObservableValue(i).getValue();
                    getquan= (double) columnqu.getCellObservableValue(i).getValue();

                    ArrayList<ItemDTO> itemDTOS = itemBO.getitemsAll(getname);
                    double quan=getquan;
                    L1: for (ItemDTO itd:itemDTOS){
                        if (quan>=itd.getQuan()) {
                            quan -= itd.getQuan();
                            itemBO.updateQuan(0, itd.getItemCode());
                        }else {
                            if (quan>0){
                                double ntot=0;
                                ntot=itd.getQuan()-quan;
                                itemBO.updateQuan(ntot,itd.getItemCode());
                            }
                            break L1;
                        }

                    }

                }
                boolean isdone=paymentBO.SaveItem(new PaymentDTO(pid,Double.parseDouble(txtTot.getText()),cmbptype.getValue().toString(),
                        Double.parseDouble( txtCash.getText()),Double.parseDouble(txtbal.getText())),new OrderDTO(txtoid.getText(),
                        pid,datefmt.format(date),timefmt.format(date),Double.parseDouble(txtTot.getText())),TabelData);
                if (isdone){


                    try {
                        InputStream is=this.getClass().getResourceAsStream("/reports/BillReport.jrxml");
                        JasperReport jasperReport= JasperCompileManager.compileReport(is);

                        HashMap hashMap=new HashMap();

                        hashMap.put("Date",datefmt.format(date));
                        hashMap.put("Time",timefmt.format(date));

                        JasperPrint jp= JasperFillManager.fillReport(jasperReport,hashMap, DBConnection.getInstance().getConnection());
                        JasperViewer.viewReport(jp,false);
                    } catch (JRException e) {
                        e.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    this.root.getChildren().clear();
                    this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/PaymentForm.fxml")));
                }


            }
        }else {
            txtCash.setFocusColor(Paint.valueOf("red"));
            txtCash.requestFocus();
        }



    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    public void cmbItNameOnAction(ActionEvent actionEvent) throws Exception {
        getDetailsItem();
        btnAdd.setDisable(false);
        txtQuan.requestFocus();

    }

    public void btnQtyOnKeyTyped(KeyEvent keyEvent) {

    }

    public void btnQtyOnKeyReleased(KeyEvent keyEvent) {
        if (txtQuan.getLength()!=0){
            if (Double.parseDouble(txtAvailableQ.getText())<Double.parseDouble(txtQuan.getText())){
                btnAdd.setDisable(true);
                txtQuan.setFocusColor(Paint.valueOf("red"));

            }else {
                btnAdd.setDisable(false);
                txtQuan.setFocusColor(Paint.valueOf("blue"));
            }
        }
        System.out.println(txtQuan.getLength());

    }

    public void cmbPytypeOnAction(ActionEvent actionEvent) {
        txtCash.setText("");
        txtbal.setText("");
        if (cmbptype.getValue().toString()=="Card"){

            txtCash.setText(txtTot.getText());
            txtbal.setText(String.valueOf(0));
        }else {
            txtCash.requestFocus();

        }
    }

    public void txtCashOnKeyRealsed(KeyEvent keyEvent) {
        txtCash.setFocusColor(Paint.valueOf("blue"));
        if (Double.parseDouble(txtTot.getText())<Double.parseDouble(txtCash.getText())) {
            txtbal.setText(String.valueOf(Double.parseDouble(txtCash.getText()) - Double.parseDouble(txtTot.getText())));
        }else {
            txtbal.setText(String.valueOf(0));
        }
    }

    public void txtCashOnKeyPressed(KeyEvent keyEvent) {
    }
}
