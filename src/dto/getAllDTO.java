package dto;

public class getAllDTO {
     private String ItCode;
     private String BatchID;
     private String SupId;
     private String ItemName;
     private double Price;
     private String ExpDate;
     private String MDate;
     private String Status;

    public getAllDTO(String itCode, String batchID, String supId, String itemName, double price, String expDate, String MDate, String status, double quan) {
        ItCode = itCode;
        BatchID = batchID;
        SupId = supId;
        ItemName = itemName;
        Price = price;
        ExpDate = expDate;
        this.MDate = MDate;
        Status = status;
        Quan = quan;
    }

    public getAllDTO() {
    }

    private double Quan;

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
    }

    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String batchID) {
        BatchID = batchID;
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
}
