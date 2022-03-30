package entity;

public class Employee implements SuperEntity{
     private String NIC;
     private int Mobile;
     private String UserFullName;
     private String UserName;
     private String Password;
     private String Role;
     private String Email;
    private String address;

    public Employee() {
    }

    public Employee(String NIC, int mobile, String userFullName, String userName, String password, String role, String email, String address) {
        this.NIC = NIC;
        Mobile = mobile;
        UserFullName = userFullName;
        UserName = userName;
        Password = password;
        Role = role;
        Email = email;
        this.address = address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public int getMobile() {
        return Mobile;
    }

    public void setMobile(int mobile) {
        Mobile = mobile;
    }

    public String getUserFullName() {
        return UserFullName;
    }

    public void setUserFullName(String userFullName) {
        UserFullName = userFullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
