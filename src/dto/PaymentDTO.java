package dto;

public class PaymentDTO {
      private String pid;
      private double cost;
     private String type;
      private double cash;
      private double balance;

    public PaymentDTO() {
    }

    public PaymentDTO(String pid, double cost, String type, double cash, double balance) {
        this.pid = pid;
        this.cost = cost;
        this.type = type;
        this.cash = cash;
        this.balance = balance;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
