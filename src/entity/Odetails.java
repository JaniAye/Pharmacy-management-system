package entity;

public class Odetails implements SuperEntity{
     private String ItCode;
     private String OrderId;
     private double UnitPrice;
     private double Quantity;
     private String ReturnStatus;
     private double ReturnQuantity;
     private String ReturnDate;
     private double ReturnedCost;

    public Odetails() {
    }

    public Odetails(String itCode, String orderId, double unitPrice, double quantity, String returnStatus, double returnQuantity, String returnDate, double returnedCost) {
        ItCode = itCode;
        OrderId = orderId;
        UnitPrice = unitPrice;
        Quantity = quantity;
        ReturnStatus = returnStatus;
        ReturnQuantity = returnQuantity;
        ReturnDate = returnDate;
        ReturnedCost = returnedCost;
    }

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
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

    public String getReturnStatus() {
        return ReturnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        ReturnStatus = returnStatus;
    }

    public double getReturnQuantity() {
        return ReturnQuantity;
    }

    public void setReturnQuantity(double returnQuantity) {
        ReturnQuantity = returnQuantity;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public double getReturnedCost() {
        return ReturnedCost;
    }

    public void setReturnedCost(double returnedCost) {
        ReturnedCost = returnedCost;
    }
}
