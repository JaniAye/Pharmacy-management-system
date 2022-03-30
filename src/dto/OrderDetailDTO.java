package dto;

public class OrderDetailDTO {
      private String ItCode;
      private String Oid;
      private double tprice;
      private double quan;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String itCode, String oid, double tprice, double quan) {
        ItCode = itCode;
        Oid = oid;
        this.tprice = tprice;
        this.quan = quan;
    }

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
    }

    public String getOid() {
        return Oid;
    }

    public void setOid(String oid) {
        Oid = oid;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public double getQuan() {
        return quan;
    }

    public void setQuan(double quan) {
        this.quan = quan;
    }
}
