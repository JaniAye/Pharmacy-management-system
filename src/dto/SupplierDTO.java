package dto;

public class SupplierDTO {
     private String SupID;
     private String CompanyName;
     private String Email;
    private String Address;
    private int phoneNO;

    public SupplierDTO() {
    }

    public SupplierDTO(String supID, String companyName, String email, String address, int phoneNO) {
        SupID = supID;
        CompanyName = companyName;
        Email = email;
        Address = address;
        this.phoneNO = phoneNO;
    }




    public String getSupID() {
        return SupID;
    }

    public void setSupID(String supID) {
        SupID = supID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(int phoneNO) {
        this.phoneNO = phoneNO;
    }
}
