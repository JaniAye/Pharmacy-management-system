package controller;

import bo.BOFactory;
import bo.Custom.HomeBO;
import bo.Custom.ItemBO;
import com.jfoenix.controls.JFXButton;
import com.lowagie.text.html.simpleparser.ALink;
import dto.getAllDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.ExpItemsTM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class ExpItemsFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<ExpItemsTM> tblExp;

    @FXML
    private TableColumn<?, ?> colItCode;

    @FXML
    private TableColumn<?, ?> ColBatchID;

    @FXML
    private TableColumn<?, ?> colitName;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colExp;

    @FXML
    private TableColumn<?, ?> coldelete;
        ItemBO itemBO;
        HomeBO homeBO;
    @FXML
    private JFXButton btnClose;
    public void initialize(){
        itemBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Item);
        homeBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.HOME);

        colItCode.setCellValueFactory(new PropertyValueFactory<>("ItCode"));
        ColBatchID.setCellValueFactory(new PropertyValueFactory<>("bid"));
        colitName.setCellValueFactory(new PropertyValueFactory<>("itname"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quan"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colExp.setCellValueFactory(new PropertyValueFactory<>("exp"));
        coldelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        try {
            loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ObservableList<ExpItemsTM> ls= FXCollections.observableArrayList();

    public void loadAll() throws Exception {
        ls.clear();
        DateFormat df=new SimpleDateFormat("YYY-MM-dd");
        Date date=new Date();
        ArrayList<getAllDTO> getAllDTOS = itemBO.GetAllItems();
        int count=0;
        int countExp=0;
        for (getAllDTO a:getAllDTOS){
            if (a.getQuan()==0){

            }else {
                int dateDiff = homeBO.getDateDiff(a.getExpDate(), df.format(date));
                if (dateDiff <= 0) {
                    Button btn=new Button("Remove");
                    ExpItemsTM expItemsTM = new ExpItemsTM(a.getItCode(), a.getBatchID(), a.getItemName(), a.getQuan(), a.getStatus(), a.getExpDate(), btn);
                    ls.add(expItemsTM);

                    btn.setOnAction(event -> {
                            ButtonType OK=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                            ButtonType Cancel =new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
                            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure ",OK,Cancel);
                        Optional<ButtonType> result=alert.showAndWait();
                        if (result.orElse(Cancel)==OK){
                            try {
                                if(itemBO.updateQuan(0, a.getItCode())){
                                    new Alert(Alert.AlertType.CONFIRMATION,"Successfull ").show();
                                    loadAll();
                                    return;
                                }else {
                                    new Alert(Alert.AlertType.CONFIRMATION,"Fail ").show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } else if (dateDiff < 30) {
                    countExp++;
                }
            }
        }
        tblExp.setItems(ls);

    }
    @FXML
    void btnCloseOnAction(ActionEvent event) {

    }

}
