package dto;

public class StockDetailDTO {
    private String itCode;
    private String SuppCode;

    public StockDetailDTO() {
    }

    public StockDetailDTO(String itCode, String suppCode, String date) {
        this.itCode = itCode;
        SuppCode = suppCode;
        this.date = date;
    }

    private String date;

    public String getItCode() {
        return itCode;
    }

    public void setItCode(String itCode) {
        this.itCode = itCode;
    }

    public String getSuppCode() {
        return SuppCode;
    }

    public void setSuppCode(String suppCode) {
        SuppCode = suppCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
