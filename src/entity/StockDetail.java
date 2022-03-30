package entity;

public class StockDetail implements SuperEntity {
    private String ItCode;
    private String SupId;

    public StockDetail() {
    }

    public StockDetail(String itCode, String supId, String date) {
        ItCode = itCode;
        SupId = supId;
        Date = date;
    }

    private String Date;

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
    }

    public String getSupId() {
        return SupId;
    }

    public void setSupId(String supId) {
        SupId = supId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
