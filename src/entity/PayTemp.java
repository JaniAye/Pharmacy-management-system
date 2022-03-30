package entity;

public class PayTemp implements SuperEntity{
    private String OrderID ;
    private String ItCode ;
    private String ItemName ;
    private double UnitPrice ;
    private double Quantity ;
    private double tot;
    private String Ptype ;
    private double Cash ;
    private double balance ;
    private double TotBill ;

    public PayTemp() {
    }

    public PayTemp(String orderID, String itCode, String itemName, double unitPrice, double quantity, double tot, String ptype, double cash, double balance, double totBill) {
        OrderID = orderID;
        ItCode = itCode;
        ItemName = itemName;
        UnitPrice = unitPrice;
        Quantity = quantity;
        this.tot = tot;
        Ptype = ptype;
        Cash = cash;
        this.balance = balance;
        TotBill = totBill;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
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

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    public String getPtype() {
        return Ptype;
    }

    public void setPtype(String ptype) {
        Ptype = ptype;
    }

    public double getCash() {
        return Cash;
    }

    public void setCash(double cash) {
        Cash = cash;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTotBill() {
        return TotBill;
    }

    public void setTotBill(double totBill) {
        TotBill = totBill;
    }
}
