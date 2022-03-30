package bo.Custom;

import dto.BatchDTO;

public interface BatchBO {
    public boolean AddBatch(BatchDTO dto)throws Exception;
    public boolean deleteBatch(String bid)throws Exception;
    public String getBid()throws Exception;

}
