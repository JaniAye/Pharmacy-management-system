package entity;

public class Payment  implements  SuperEntity{
     private String PID;
     private double Cost;
     private String Type;
     private double Cash;
    private double Balance;

    public Payment() {
    }

    public Payment(String PID, double cost, String type, double cash, double balance) {
        this.PID = PID;
        Cost = cost;
        Type = type;
        Cash = cash;
        Balance = balance;
    }




    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getCash() {
        return Cash;
    }

    public void setCash(double cash) {
        Cash = cash;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
