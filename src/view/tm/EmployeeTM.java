package view.tm;

import javafx.scene.control.Button;

public class EmployeeTM {
       private String NIC;
       private String fname;
       private String addr;
       private int mobi;
       private String role;
      private String email;
       private Button btn;

    public EmployeeTM() {
    }

    public EmployeeTM(String NIC, String fname, String addr, int mobi, String role, String email, Button btn) {
        this.NIC = NIC;
        this.fname = fname;
        this.addr = addr;
        this.mobi = mobi;
        this.role = role;
        this.email = email;
        this.btn = btn;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getMobi() {
        return mobi;
    }

    public void setMobi(int mobi) {
        this.mobi = mobi;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
