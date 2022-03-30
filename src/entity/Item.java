package entity;

public class Item implements SuperEntity {
    private String ItCode;
    private String ItemName;
    private double Price;
    private String ExpDate;
    private String MDate;
    private String Status;
    private double Quan;

    public Item() {
    }

    public Item(String itCode, String itemName, double price, String expDate, String MDate, String status, double quan) {
        setItCode(itCode);
        setItemName(itemName);
        setPrice(price);
        setExpDate(expDate);
        this.setMDate(MDate);
        setStatus(status);
        setQuan(quan);
    }

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
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
