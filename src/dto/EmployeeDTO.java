package dto;

public class EmployeeDTO {
     private String NIC;
     private int mobileNo;
     private String UserFullName;
     private String un;
     private String pass;
     private String role;
     private String email;
    private String Adddress;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String NIC, int mobileNo, String userFullName, String un, String pass, String role, String email, String adddress) {
        this.NIC = NIC;
        this.mobileNo = mobileNo;
        UserFullName = userFullName;
        this.un = un;
        this.pass = pass;
        this.role = role;
        this.email = email;
        Adddress = adddress;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUserFullName() {
        return UserFullName;
    }

    public void setUserFullName(String userFullName) {
        UserFullName = userFullName;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getAdddress() {
        return Adddress;
    }

    public void setAdddress(String adddress) {
        Adddress = adddress;
    }
}
