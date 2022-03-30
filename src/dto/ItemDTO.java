package dto;

public class ItemDTO {
    private String ItemCode;
    private String ItemName;
    private double price;
    private String expDate;
    private String Mdate;
    private String status;
    private double Quan;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String itemName, double price, String expDate, String mdate, String status, double quan) {
        setItemCode(itemCode);
        setItemName(itemName);
        this.setPrice(price);
        this.setExpDate(expDate);
        setMdate(mdate);
        this.setStatus(status);
        setQuan(quan);
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getMdate() {
        return Mdate;
    }

    public void setMdate(String mdate) {
        Mdate = mdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getQuan() {
        return Quan;
    }

    public void setQuan(double quan) {
        Quan = quan;
    }
}
