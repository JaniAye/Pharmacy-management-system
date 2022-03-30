package view.tm;

import javafx.scene.control.Button;

public class OutOfStockTM {
     private String ItCode;
     private String bid;
     private String itname;
     private double quan;
     private String Status;
     private String exp;

    public OutOfStockTM() {
    }

    public OutOfStockTM(String itCode, String bid, String itname, double quan, String status, String exp) {
        ItCode = itCode;
        this.bid = bid;
        this.itname = itname;
        this.quan = quan;
        Status = status;
        this.exp = exp;
    }

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getItname() {
        return itname;
    }

    public void setItname(String itname) {
        this.itname = itname;
    }

    public double getQuan() {
        return quan;
    }

    public void setQuan(double quan) {
        this.quan = quan;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
