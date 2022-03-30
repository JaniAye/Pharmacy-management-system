package controller;

import bo.BOFactory;
import bo.Custom.OdTempBO;
import bo.Custom.OrderBO;
import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import dto.OdTempDTO;
import dto.OrderDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import view.tm.IncomeOrderTM;
import view.tm.OrdersTM;

import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class IncomeReportsFormController {

    public Label lbltotsales;
    public JFXButton btnPrint;
    @FXML
    private TableView<IncomeOrderTM> tblorders;

    @FXML
    private TableColumn<?, ?> coloid;

    @FXML
    private TableColumn<?, ?> colpid;

    @FXML
    private TableColumn<?, ?> colodate;

    @FXML
    private TableColumn<?, ?> coltot;
    @FXML
    private TableView<IncomeOrderTM> tblYearlysales;

    @FXML
    private TableColumn<?, ?> colYOrderID;

    @FXML
    private TableColumn<?, ?> colYPayId;

    @FXML
    private TableColumn<?, ?> colYOrderDate;

    @FXML
    private TableColumn<?, ?> colYTotal;

    @FXML
    private Label lblYselseTot;

    @FXML
    private JFXButton btnPrintYsalses;

    OrderBO orderBO;
    OdTempBO odtem;
    ObservableList<IncomeOrderTM> orderoblist= FXCollections.observableArrayList();
    ObservableList<IncomeOrderTM> Ysales= FXCollections.observableArrayList();
    public void initialize(){
        orderBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.ORDER);
        odtem= BOFactory.getInstance().getbo(BOFactory.BOTYPE.ODTEMP);


        coloid.setCellValueFactory(new PropertyValueFactory<>("oid"));
        colpid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        colodate.setCellValueFactory(new PropertyValueFactory<>("odate"));
        coltot.setCellValueFactory(new PropertyValueFactory<>("tot"));
         colYOrderID.setCellValueFactory(new PropertyValueFactory<>("oid"));
        colYPayId.setCellValueFactory(new PropertyValueFactory<>("pid"));
        colYOrderDate.setCellValueFactory(new PropertyValueFactory<>("odate"));
        colYTotal.setCellValueFactory(new PropertyValueFactory<>("tot"));


        loadAll();
        gettot();
        getYearlySales();
        getYearly();
    }
    public void gettot(){
        double tot=0;

        for (int i = 0; i <tblorders.getItems().size() ; i++) {
            TableColumn column=tblorders.getColumns().get(3);
            tot+= (double) column.getCellObservableValue(i).getValue();
        }
        lbltotsales.setText(String.valueOf(tot));

    }
    public void loadAll(){
        DateFormat df=new SimpleDateFormat("MM");
        DateFormat year=new SimpleDateFormat("YYY");
        Date date=new Date();
        try {
            ArrayList<OrderDTO> ollorder=orderBO.GetAllItems();
            for (OrderDTO odto:ollorder){
                int month = orderBO.getMonth(odto.getOdate());
                int yr = orderBO.getYear(odto.getOdate());
                int thismonth= Integer.parseInt(df.format(date));
                int thisYr= Integer.parseInt(year.format(date));

                if (yr==thisYr && month==thismonth){
                    IncomeOrderTM tm=new IncomeOrderTM(odto.getOid(),odto.getPid(),odto.getOdate(),odto.getOtime(),odto.getTotCost());
                    orderoblist.add(tm);
                }

            }
            tblorders.setItems(orderoblist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getYearlySales(){
        DateFormat df=new SimpleDateFormat("MM");
        DateFormat year=new SimpleDateFormat("YYY");
        Date date=new Date();
        try {
            ArrayList<OrderDTO> ollorder=orderBO.GetAllItems();
            for (OrderDTO odto:ollorder){

                int yr = orderBO.getYear(odto.getOdate());

                int thisYr= Integer.parseInt(year.format(date));

                if (yr==thisYr){

                    IncomeOrderTM tm=new IncomeOrderTM(odto.getOid(),odto.getPid(),odto.getOdate(),odto.getOtime(),odto.getTotCost());
                    Ysales.add(tm);
                }

            }
            tblYearlysales.setItems(Ysales);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {
        deleteTemp();
        boolean isAdd=false;
        for (IncomeOrderTM tm:orderoblist){
            try {
                isAdd=odtem.saveTemp(new OdTempDTO(tm.getOid(),tm.getPid(),tm.getOdate(),tm.getOtime(),tm.getTot()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (isAdd){
            try {
                InputStream is=this.getClass().getResourceAsStream("/reports/MonthlySReport.jrxml");
                JasperReport jasperReport= JasperCompileManager.compileReport(is);
                DateFormat dft=new SimpleDateFormat("YYYY-MM-dd");
                DateFormat tim=new SimpleDateFormat("HH:MM");
                Date date=new Date();
                HashMap hashMap=new HashMap();

                hashMap.put("dateY",dft.format(date));
                hashMap.put("timeY",tim.format(date));
                hashMap.put("totalY",Double.parseDouble(lbltotsales.getText()));
                JasperPrint jp= JasperFillManager.fillReport(jasperReport,hashMap, DBConnection.getInstance().getConnection());
                JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void btnYsalsesPrint(ActionEvent event) {
        deleteTemp();
        boolean isAdd=false;
        for (IncomeOrderTM tm:Ysales){
            try {
              isAdd=odtem.saveTemp(new OdTempDTO(tm.getOid(),tm.getPid(),tm.getOdate(),tm.getOtime(),tm.getTot()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (isAdd){
            try {
                InputStream is=this.getClass().getResourceAsStream("/reports/YRReport.jrxml");
                JasperReport jasperReport= JasperCompileManager.compileReport(is);
                DateFormat dft=new SimpleDateFormat("YYYY-MM-dd");
                DateFormat tim=new SimpleDateFormat("HH:MM");
                Date date=new Date();
                HashMap hashMap=new HashMap();

                hashMap.put("dateY",dft.format(date));
                hashMap.put("timeY",tim.format(date));
                hashMap.put("totalY",Double.parseDouble(lblYselseTot.getText()));
                JasperPrint jp= JasperFillManager.fillReport(jasperReport,hashMap, DBConnection.getInstance().getConnection());
                JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
    public void getYearly(){
        double tot=0;

        for (int i = 0; i <tblYearlysales.getItems().size() ; i++) {
            TableColumn column=tblYearlysales.getColumns().get(3);
            tot+= (double) column.getCellObservableValue(i).getValue();
        }
        lblYselseTot.setText(String.valueOf(tot));
    }
    public void deleteTemp(){
        if (Ysales!=null) {
            for (IncomeOrderTM tm : Ysales) {
                try {
                    odtem.deleteTemp(tm.getOid());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if (orderoblist!=null){
            for (IncomeOrderTM tm : orderoblist) {
                try {
                    odtem.deleteTemp(tm.getOid());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
