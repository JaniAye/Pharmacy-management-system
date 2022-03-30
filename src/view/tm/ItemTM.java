package view.tm;

import javafx.scene.control.Button;

public class ItemTM {
     private String ItCode;
    private String batchID;
    private String SupId;
     private String ItemName;
     private double Price;
     private String ExpDate;
     private String MDate;
     private String Status;
     private double Quan;
     private Button btn;

    public ItemTM() {
    }

    public ItemTM(String itCode, String batchID, String supId, String itemName, double price, String expDate, String MDate, String status, double quan, Button btn) {
        setItCode(itCode);
        this.setBatchID(batchID);
        setSupId(supId);
        setItemName(itemName);
        setPrice(price);
        setExpDate(expDate);
        this.setMDate(MDate);
        setStatus(status);
        setQuan(quan);
        this.setBtn(btn);
    }

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getSupId() {
        return SupId;
    }

    public void setSupId(String supId) {
        SupId = supId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }

    public String getMDate() {
        return MDate;
    }

    public void setMDate(String MDate) {
        this.MDate = MDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public double getQuan() {
        return Quan;
    }

    public void setQuan(double quan) {
        Quan = quan;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
