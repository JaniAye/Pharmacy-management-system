package dto;

public class BatchDTO {
    private String batchId;
    private String date;
    private String time;

    public BatchDTO() {
    }

    public BatchDTO(String batchId, String date, String time) {
        this.setBatchId(batchId);
        this.setDate(date);
        this.setTime(time);
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
