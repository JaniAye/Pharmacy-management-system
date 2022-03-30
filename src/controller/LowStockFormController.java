package controller;

import bo.BOFactory;
import bo.Custom.ItemBO;
import dto.ItemDTO;
import dto.getAllDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.OutOfStockTM;

import java.util.ArrayList;

public class LowStockFormController {

    @FXML
    private TableView<OutOfStockTM> tblLowStock;

    @FXML
    private TableColumn<?, ?> colitc;

    @FXML
    private TableColumn<?, ?> colbid;

    @FXML
    private TableColumn<?, ?> colitname;

    @FXML
    private TableColumn<?, ?> colquan;

    @FXML
    private TableColumn<?, ?> colstatus;

    @FXML
    private TableColumn<?, ?> colExp;
    ItemBO itemBO;
    public void initialize(){
        itemBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Item);

        colitc.setCellValueFactory(new PropertyValueFactory<>("ItCode"));
        colbid.setCellValueFactory(new PropertyValueFactory<>("bid"));
        colitname.setCellValueFactory(new PropertyValueFactory<>("itname"));
        colquan.setCellValueFactory(new PropertyValueFactory<>("quan"));
        colstatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colExp.setCellValueFactory(new PropertyValueFactory<>("exp"));

        loadAll();
    }
    ObservableList<OutOfStockTM> getItems= FXCollections.observableArrayList();
    public void loadAll(){
        try {
            ArrayList<getAllDTO> getAl = itemBO.GetAllItems();
            for (getAllDTO get:getAl){
                ArrayList<ItemDTO> getdata=itemBO.getitemsAll(get.getItemName());
                double qun=0;
                for (ItemDTO itm:getdata){
                    qun+=itm.getQuan();
                }
                if (qun<5){

                    OutOfStockTM outOfStockTM = new OutOfStockTM(get.getItCode(), get.getBatchID(), get.getItemName(), get.getQuan(), get.getStatus(),
                            get.getExpDate());
                    getItems.add(outOfStockTM);
                }
            }
            tblLowStock.setItems(getItems);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
