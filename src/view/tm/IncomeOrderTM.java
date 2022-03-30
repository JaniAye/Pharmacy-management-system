package view.tm;

public class IncomeOrderTM {
    private String oid;
    private String pid;
    private String odate;
    private String otime;
    private double tot;

    public IncomeOrderTM() {
    }

    public IncomeOrderTM(String oid, String pid, String odate, String otime, double tot) {
        this.oid = oid;
        this.pid = pid;
        this.odate = odate;
        this.otime = otime;
        this.tot = tot;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }
}
