package bo.Custom;

import dto.DetailsBDTO;
import dto.OrderDetailDTO;

import java.util.ArrayList;

public interface DetailsBO {
    public boolean addBatchDetails(DetailsBDTO bdto)throws Exception;
    public boolean deleteBatchDetails(String id)throws Exception;


}
