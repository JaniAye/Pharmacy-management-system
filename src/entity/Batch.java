package entity;

public class Batch implements SuperEntity {
    private String BatchID;
    private String Date;
    private String Time;

    public Batch() {
    }

    public Batch(String batchID, String date, String time) {
        BatchID = batchID;
        Date = date;
        Time = time;
    }



    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String batchID) {
        BatchID = batchID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
