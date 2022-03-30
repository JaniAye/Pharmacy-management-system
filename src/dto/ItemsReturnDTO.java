package dto;

public class ItemsReturnDTO {
     private String ItCode;
     private String OrderId;
     private String Returnid;
     private double ReturnQuantity;
     private String ReturnDate;
     private double ReturnedCost;
     private String  Reason;

    public ItemsReturnDTO() {
    }

    public ItemsReturnDTO(String itCode, String orderId, String returnid, double returnQuantity, String returnDate, double returnedCost, String reason) {
        ItCode = itCode;
        OrderId = orderId;
        Returnid = returnid;
        ReturnQuantity = returnQuantity;
        ReturnDate = returnDate;
        ReturnedCost = returnedCost;
        Reason = reason;
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

    public String getReturnid() {
        return Returnid;
    }

    public void setReturnid(String returnid) {
        Returnid = returnid;
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

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }
}
