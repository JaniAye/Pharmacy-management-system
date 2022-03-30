package view.tm;

import javafx.scene.control.Button;

public class SupplerTM {
    private String Supid;
    private String CompanyName;
    private String Address;
    private String Email;
    private int phoneNo;
    private Button btn;

    public SupplerTM() {
    }

    public SupplerTM(String supid, String companyName, String address, String email, int phoneNo, Button btn) {
        setSupid(supid);
        setCompanyName(companyName);
        setAddress(address);
        setEmail(email);
        this.setPhoneNo(phoneNo);
        this.setBtn(btn);
    }

    public String getSupid() {
        return Supid;
    }

    public void setSupid(String supid) {
        Supid = supid;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
