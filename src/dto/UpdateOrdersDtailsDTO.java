package dto;

public class UpdateOrdersDtailsDTO {
    private String oid;
    private double quan;
    private double tot;

    public UpdateOrdersDtailsDTO() {
    }

    public UpdateOrdersDtailsDTO(String oid, double quan, double tot) {
        this.oid = oid;
        this.quan = quan;
        this.tot = tot;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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
}
