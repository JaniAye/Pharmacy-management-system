package controller;

import bo.BOFactory;
import bo.Custom.HomeBO;
import bo.Custom.ItemBO;
import dto.getAllDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ExpItemsTM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class ExpInThisMOnthViewFormController {

    public TableView tblexp;
    @FXML
    private TableColumn<?, ?> colitcode;

    @FXML
    private TableColumn<?, ?> colbatchid;

    @FXML
    private TableColumn<?, ?> colitname;

    @FXML
    private TableColumn<?, ?> colquantity;

    @FXML
    private TableColumn<?, ?> colstatus;

    @FXML
    private TableColumn<?, ?> colexp;

    @FXML
    private TableColumn<?, ?> colopt;
    ItemBO itemBO;
    HomeBO homeBO;
    public void initialize(){
        itemBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Item);
        homeBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.HOME);
        colitcode.setCellValueFactory(new PropertyValueFactory<>("ItCode"));
        colbatchid.setCellValueFactory(new PropertyValueFactory<>("bid"));
        colitname.setCellValueFactory(new PropertyValueFactory<>("itname"));
        colquantity.setCellValueFactory(new PropertyValueFactory<>("quan"));
        colstatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colexp.setCellValueFactory(new PropertyValueFactory<>("exp"));
        colopt.setCellValueFactory(new PropertyValueFactory<>("btn"));
        try {
            loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    ObservableList<ExpItemsTM> ls= FXCollections.observableArrayList();
    public void loadAll() throws Exception {
        ls.clear();
        DateFormat df=new SimpleDateFormat("YYYY-MM-dd");
        Date date=new Date();
        ArrayList<getAllDTO> getAllDTOS = itemBO.GetAllItems();

        for (getAllDTO a:getAllDTOS){
            if (a.getQuan()==0){

            }else {
                int dateDiff = homeBO.getDateDiff(a.getExpDate(), df.format(date));
                if (dateDiff <= 0) {


                } else if (dateDiff < 30) {
                    Button btn=new Button("Remove");
                    ExpItemsTM expItemsTM = new ExpItemsTM(a.getItCode(), a.getBatchID(), a.getItemName(), a.getQuan(), a.getStatus(), a.getExpDate(), btn);
                    ls.add(expItemsTM);
                    btn.setOnAction(event -> {
                        ButtonType OK=new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                        ButtonType Cancel=new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure ",OK,Cancel);
                        Optional<ButtonType> result=alert.showAndWait();
                        if (result.orElse(Cancel)==OK){
                            try {
                               if(itemBO.updateQuan(0, a.getItCode())){
                                   new Alert(Alert.AlertType.CONFIRMATION,"Successfull ").show();
                                   loadAll();
                                   return;
                               }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
        tblexp.setItems(ls);

    }

}
