package entity;

public class OrderDetail implements SuperEntity{
       private String ItCode;
       private String OrderId;
       private double UnitPrice;
       private double Quantity;


    public OrderDetail() {
    }

    public OrderDetail(String itCode, String orderId, double unitPrice, double quantity) {
        setItCode(itCode);
        setOrderId(orderId);
        setUnitPrice(unitPrice);
        setQuantity(quantity);
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
}
