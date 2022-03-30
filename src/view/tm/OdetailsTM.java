package view.tm;

public class OdetailsTM {
    private String ItCode;
    private String oid;
    private double up;
    private double quan;

    public OdetailsTM() {
    }

    public OdetailsTM(String itCode, String oid, double up, double quan) {
        ItCode = itCode;
        this.oid = oid;
        this.up = up;
        this.quan = quan;
    }

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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
}
