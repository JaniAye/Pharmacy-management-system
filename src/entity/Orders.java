package entity;

public class Orders implements SuperEntity{
     private String OrderId;
     private String PID;
     private String OrderDate;
     private String OrderTime;
     private double totCost;

    public Orders() {
    }

    public Orders(String orderId, String PID, String orderDate, String orderTime, double totCost) {
        OrderId = orderId;
        this.PID = PID;
        OrderDate = orderDate;
        OrderTime = orderTime;
        this.totCost = totCost;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(String orderTime) {
        OrderTime = orderTime;
    }

    public double getTotCost() {
        return totCost;
    }

    public void setTotCost(double totCost) {
        this.totCost = totCost;
    }
}
