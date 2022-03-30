package entity;

public class Supplier implements SuperEntity {
    private String SupId;
    private String CompanyName;
    private String Address;
    private String Email;
    private int phoneNo;

    public Supplier() {
    }

    public Supplier(String supId, String companyName, String address, String email, int phoneNo) {
        setSupId(supId);
        setCompanyName(companyName);
        setAddress(address);
        setEmail(email);
        this.setPhoneNo(phoneNo);
    }

    public String getSupId() {
        return SupId;
    }

    public void setSupId(String supId) {
        SupId = supId;
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
}
