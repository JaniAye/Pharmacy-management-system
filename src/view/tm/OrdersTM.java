package view.tm;

import javafx.scene.control.Button;

public class OrdersTM {
    private String itcode;
    private String itemname;
    private double up;
    private double quan;
    private double tot;
    private Button btn;

    public OrdersTM() {
    }

    public OrdersTM(String itcode, String itemname, double up, double quan, double tot, Button btn) {
        this.itcode = itcode;
        this.itemname = itemname;
        this.up = up;
        this.quan = quan;
        this.tot = tot;
        this.btn = btn;
    }

    public String getItcode() {
        return itcode;
    }

    public void setItcode(String itcode) {
        this.itcode = itcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getUp() {
        return up;
    }

    public void setUp(double up) {
        this.up = up;
    }

    public double getQuan() {
        return quan;
    }

    public void setQuan(double quan) {
        this.quan = quan;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
