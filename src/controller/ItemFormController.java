package controller;

import bo.BOFactory;
import bo.Custom.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.*;
import entity.Batch;
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
import org.omg.CORBA.Object;
import view.tm.ItemTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


public class ItemFormController {

    public JFXButton btnUpdate;
    public AnchorPane root;
    public TableColumn colbatchID;
    public TableColumn colSupID;
    public JFXButton btnnextBatch;
    @FXML
    private JFXTextField txtItCode;

    @FXML
    private JFXTextField txtSupId;

    @FXML
    private JFXTextField txtBatchID;

    @FXML
    private JFXTextField txtItName;

    @FXML
    private JFXTextField txtStatus;

    @FXML
    private DatePicker DtpExD;

    @FXML
    private DatePicker DTPmdate;

    @FXML
    private JFXTextField txtUp;

    @FXML
    private JFXTextField txtQuan;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TableView<ItemTM> tblitem;

    @FXML
    private TableColumn<?, ?> colItCode;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colExpDate;

    @FXML
    private TableColumn<?, ?> colManuDate;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colOpt;

    @FXML
    private JFXButton btnCancel;


    private ItemBO bo;
    private   SupplierBO bosup;
    private StockDetailsBO boStockDtail;
    private BatchBO bobatch;
   // private BatchDetailsBO bdetailsBO;
    private DetailsBO dtails;

    public void initialize() throws Exception {

         bo = BOFactory.getInstance().getbo(BOFactory.BOTYPE.Item);
         bosup=BOFactory.getInstance().getbo(BOFactory.BOTYPE.Supplier);
         boStockDtail=BOFactory.getInstance().getbo(BOFactory.BOTYPE.StockDetail);
         bobatch=BOFactory.getInstance().getbo(BOFactory.BOTYPE.Batch);
         dtails=BOFactory.getInstance().getbo(BOFactory.BOTYPE.Details);
//         bdetailsBO=BOFactory.getInstance().getbo(BOFactory.BOTYPE.BatchDetails);

        colItCode.setCellValueFactory(new PropertyValueFactory<>("ItCode"));
        colName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colExpDate.setCellValueFactory(new PropertyValueFactory<>("ExpDate"));
        colManuDate.setCellValueFactory(new PropertyValueFactory<>("MDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quan"));
        colbatchID.setCellValueFactory(new PropertyValueFactory<>("batchID"));
        colSupID.setCellValueFactory(new PropertyValueFactory<>("SupId"));
        colOpt.setCellValueFactory(new PropertyValueFactory<>("btn"));

        getItCode();
        loadAll();
        getBatchID();
        tblitem.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void clrAll(){

        txtQuan.setText("");
        txtStatus.setText("");
        txtItName.setText("");
        txtUp.setText("");
        DtpExD.setValue(null);
        DTPmdate.setValue(null);

    }
    private void getBatch(){

    }
    private void setData(ItemTM tm) {
        txtItCode.setText(tm.getItCode());
        txtItName.setText(tm.getItemName());
        txtUp.setText(tm.getPrice()+"");
        DtpExD.setValue(LocalDate.parse(tm.getExpDate()));
        DTPmdate.setValue(LocalDate.parse(tm.getMDate()));
        txtStatus.setText(tm.getStatus());
        txtQuan.setText(String.valueOf(tm.getQuan()));
        txtSupId.setText(String.valueOf(tm.getSupId()));
        txtBatchID.setText(String.valueOf(tm.getBatchID()));
    }
    ObservableList<ItemTM> oblist= FXCollections.observableArrayList();

    private void loadAll() throws Exception {
        oblist.clear();
        List<getAllDTO> AllItm=bo.GetAllItems();
        for (getAllDTO itm:AllItm) {
            if (itm.getQuan()==0){

            }else {
                Button btn=new Button("Delete");
                ItemTM tm=new ItemTM(itm.getItCode(),itm.getBatchID(),itm.getSupId(),itm.getItemName(),itm.getPrice(),
                        itm.getExpDate(),itm.getMDate(),itm.getStatus(),itm.getQuan(),btn);
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
                            if(bo.updateQuan(0, itm.getItCode())){
                                new Alert(Alert.AlertType.CONFIRMATION,
                                        "Deleted", ButtonType.OK).show();
                                loadAll();
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

        }
        tblitem.setItems(oblist);

    }
    private void getBatchID() throws Exception {

        String bid = bobatch.getBid();
        txtSupId.setEditable(true);
        int x2=0;
        if (bid==null){

            txtBatchID.setText("B001");
        }else {

            bid=bid.split("[A-z]")[1];
            x2=Integer.parseInt(bid)+1;
            txtBatchID.setText("B00"+x2);
        }

    }
    private void getItCode() throws Exception {
        String id = bo.getID();

        int x=0;

        if (id==null){
            txtItCode.setText("IT001");

        }else {
            id=id.split("[A-z]")[2];

            x=Integer.parseInt(id)+1;

            txtItCode.setText("IT00"+x);

        }

    }
    private int getdateDiff(String date,String date2){
        int dtdiff =0;
        try {
            dtdiff= bo.getdateDiff(date, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtdiff;
    }
    @FXML
    void btnAddOnAction(ActionEvent event)  {
        DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        Date date=new Date();
       try {
           if (DTPmdate.getValue().equals(null)){
               new Alert(Alert.AlertType.ERROR,"Provide All details ").show();
           }else {

               int dtdiff = getdateDiff(dateFormat.format(date), DTPmdate.getValue().toString());
               if (dtdiff > 0) {
                   int dif = getdateDiff(DtpExD.getValue().toString(), dateFormat.format(date));
                   if (dif > 1) {
                       txtQuan.setFocusColor(Paint.valueOf("blue"));
                       txtUp.setFocusColor(Paint.valueOf("blue"));
                       txtSupId.setFocusColor(Paint.valueOf("blue"));
                       if (Pattern.compile("^(S00)[0-9]{1,}$").matcher(txtSupId.getText()).matches()){
                           if (Pattern.compile("^[0-9]{1,}$").matcher(txtUp.getText()).matches()){
                               if (Pattern.compile("^[0-9]{1,}$").matcher(txtQuan.getText()).matches()){

                                   DateFormat datefmt=new SimpleDateFormat("yyy/MM/dd");
                                   DateFormat timefmt=new SimpleDateFormat("HH:MM");
                                   //Time time=new Time();
                                   if ( searchSupp()){

                                   }else {
                                       ItemDTO item = bo.getItem(txtItName.getText());

                                       boolean isAdd = bo.SaveItem(new ItemDTO(txtItCode.getText(), txtItName.getText().toUpperCase(), Double.parseDouble(txtUp.getText()), DtpExD.getValue().toString(), DTPmdate.getValue().toString(), txtStatus.getText(), Double.parseDouble(txtQuan.getText())),
                                               new StockDetailDTO(txtItCode.getText(),txtSupId.getText(),datefmt.format(date)),new BatchDTO(txtBatchID.getText(),
                                                       datefmt.format(date),timefmt.format(date)));
                                       if (isAdd){
                                           Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Item Added to the Stock");
                                           txtSupId.setEditable(false);
                                           alert.show();
                                           loadAll();
                                           clrAll();
                                           getItCode();
                                       }else {
                                           Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Item Adding Faill");
                                           alert.show();
                                           clrAll();
                                       }

                                   }
                               }else{
                                   txtQuan.setFocusColor(Paint.valueOf("red"));
                                   txtQuan.requestFocus();
                               }



                           }else {
                               txtUp.setFocusColor(Paint.valueOf("red"));
                               txtUp.requestFocus();
                           }
                       }else {
                           txtSupId.setFocusColor(Paint.valueOf("red"));
                           txtSupId.requestFocus();
                       }

                   } else {
                       new Alert(Alert.AlertType.ERROR, "Invalid Expired Date").show();
                   }

               } else {
                   new Alert(Alert.AlertType.ERROR, "Invalid Manufacture Date ").show();
               }
           }
       }catch (NullPointerException e){
          new Alert(Alert.AlertType.ERROR,"Provide All details ").show();
       } catch (Exception e) {
           e.printStackTrace();
       }


    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        clrAll();

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {

        boolean isUpd=bo.UpdateItem(new ItemDTO(txtItCode.getText(),txtItName.getText().toUpperCase(),Double.parseDouble(txtUp.getText()),DtpExD.getValue().toString(),
                DTPmdate.getValue().toString(),txtStatus.getText(),Double.parseDouble(txtQuan.getText())) );
        if (isUpd){
            new Alert(Alert.AlertType.CONFIRMATION,"Item Is Updated").show();
            clrAll();
            loadAll();

        }else {
            new Alert(Alert.AlertType.ERROR,"Update Fail");
        }
    }
    private boolean searchSupp() throws Exception {
        SupplierDTO suppdto=bosup.getSuppler(txtSupId.getText());
        if (suppdto==null){

            ButtonType OK =new ButtonType("OK",ButtonBar.ButtonData.OK_DONE);
            ButtonType Cancel =new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert= new Alert(Alert.AlertType.ERROR,"Supplier is not registered, Would you like to register Supplier First",OK,Cancel);
            Optional<ButtonType> rsult=alert.showAndWait();
            if (rsult.orElse(Cancel)==OK){
                this.root.getChildren().clear();
                this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/SupplierForm.fxml")));
            }else{
                txtSupId.setText("");
            }
            return true;
        }else{

        }
        return false;
    }
    public void txtSupIDOnAction(ActionEvent actionEvent) throws Exception {
        searchSupp();
    }

    public void txtBatchIDOnAction(ActionEvent actionEvent) {
    }

    public void txtSupIDPressOnAction(KeyEvent keyEvent) throws Exception {
//        SupplierDTO suppdto=bosup.getSuppler(txtSupId.getText());
//        if (suppdto!=null) {
//            System.out.println("wd");
//            txtSupId.setFocusColor(Paint.valueOf("red"));
//            return;
//        }
//        System.out.println("ddd");
//        txtSupId.setFocusColor(Paint.valueOf("blue"));

    }

    public void txtBtachIDPressOnAction(KeyEvent keyEvent) {
    }

    public void txtItNameKeyRealsed(KeyEvent keyEvent) {
        txtStatus.setText("Availabel");
    }

    public void btnnextBatchOnAction(ActionEvent actionEvent) {
        try {
            getBatchID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
