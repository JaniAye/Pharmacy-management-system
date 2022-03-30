package entity;

public class DetailsB implements SuperEntity {
    private String ItCode;
    private String BatchID;

    public DetailsB() {
    }

    public DetailsB(String itCode, String batchID) {
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
