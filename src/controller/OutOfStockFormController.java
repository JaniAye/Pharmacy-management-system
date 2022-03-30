package controller;

import bo.BOFactory;
import bo.Custom.ItemBO;
import dto.ItemDTO;
import dto.getAllDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ExpItemsTM;
import view.tm.ItemTM;
import view.tm.OutOfStockTM;

import java.util.ArrayList;

public class OutOfStockFormController {

    @FXML
    private TableView<OutOfStockTM> tblExpItem;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colBatchId;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colQuan;

    @FXML
    private TableColumn<?, ?> colstatus;

    @FXML
    private TableColumn<?, ?> colExp;
    ItemBO itemBO;
    public void initialize(){
        itemBO= BOFactory.getInstance().getbo(BOFactory.BOTYPE.Item);

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ItCode"));
        colBatchId.setCellValueFactory(new PropertyValueFactory<>("bid"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itname"));
        colQuan.setCellValueFactory(new PropertyValueFactory<>("quan"));
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
                if (qun==0){

                    OutOfStockTM outOfStockTM = new OutOfStockTM(get.getItCode(), get.getBatchID(), get.getItemName(), get.getQuan(), get.getStatus(),
                            get.getExpDate());
                    getItems.add(outOfStockTM);
                }
            }
            tblExpItem.setItems(getItems);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
