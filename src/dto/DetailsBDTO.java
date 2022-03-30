package dto;

public class DetailsBDTO {
    private String ItCode;
    private String BatchID;

    public DetailsBDTO() {
    }

    public DetailsBDTO(String itCode, String batchID) {
        setItCode(itCode);
        setBatchID(batchID);
    }

    public String getItCode() {
        return ItCode;
    }

    public void setItCode(String itCode) {
        ItCode = itCode;
    }

    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String batchID) {
        BatchID = batchID;
    }
}
