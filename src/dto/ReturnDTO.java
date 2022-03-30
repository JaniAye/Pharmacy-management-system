package dto;

public class ReturnDTO {
       private String Itcode;
       private String ItName;
       private double up;
       private double quan;
       private String MDate;
       private String ExpDate;
      private double totprice;

    public ReturnDTO() {
    }

    public ReturnDTO(String itcode, String itName, double up, double quan, String MDate, String expDate, double totprice) {
        Itcode = itcode;
        ItName = itName;
        this.up = up;
        this.quan = quan;
        this.MDate = MDate;
        ExpDate = expDate;
        this.totprice = totprice;
    }

    public String getItcode() {
        return Itcode;
    }

    public void setItcode(String itcode) {
        Itcode = itcode;
    }

    public String getItName() {
        return ItName;
    }

    public void setItName(String itName) {
        ItName = itName;
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

    public String getMDate() {
        return MDate;
    }

    public void setMDate(String MDate) {
        this.MDate = MDate;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }

    public double getTotprice() {
        return totprice;
    }

    public void setTotprice(double totprice) {
        this.totprice = totprice;
    }
}
