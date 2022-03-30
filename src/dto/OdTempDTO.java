package dto;

public class OdTempDTO {
     private String Oid;
     private String Pid;
     private String odate;
     private String otime;
    private double totCost;

    public OdTempDTO() {
    }

    public OdTempDTO(String oid, String pid, String odate, String otime, double totCost) {
        Oid = oid;
        Pid = pid;
        this.odate = odate;
        this.otime = otime;
        this.totCost = totCost;
    }

    public String getOid() {
        return Oid;
    }

    public void setOid(String oid) {
        Oid = oid;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public double getTotCost() {
        return totCost;
    }

    public void setTotCost(double totCost) {
        this.totCost = totCost;
    }
}
