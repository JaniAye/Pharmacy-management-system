package entity;

public class Returndetail {
     private String Itcode;
     private String ItName;
     private double Price;
     private double Quantity;
     private String MDate;
     private String ExpDate;
     private double UnitPrice;

    public Returndetail() {
    }

    public Returndetail(String itcode, String itName, double price, double quantity, String MDate, String expDate, double unitPrice) {
        Itcode = itcode;
        ItName = itName;
        Price = price;
        Quantity = quantity;
        this.MDate = MDate;
        ExpDate = expDate;
        UnitPrice = unitPrice;
    }

    public String getItcode() {
        return Itcode;
    }

    public void setItcode(String itcode) {
        Itcode = itcode;
    }

    public String getItName() {
        return ItName;
    }

    public void setItName(String itName) {
        ItName = itName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public String getMDate() {
        return MDate;
    }

    public void setMDate(String MDate) {
        this.MDate = MDate;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }
}
