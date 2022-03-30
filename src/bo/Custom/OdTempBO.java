package bo.Custom;

import dto.OdTempDTO;
import dto.OrderDTO;
import entity.OdTemp;

import java.util.ArrayList;

public interface OdTempBO {
    public boolean saveTemp(OdTempDTO tmp)throws Exception;
    public boolean deleteTemp(String id)throws Exception;
    public boolean updateTemp(OdTempDTO tmp)throws Exception;
    public ArrayList<OdTempDTO> getTemp()throws Exception;
    public OdTempDTO getTemp(String id)throws Exception;
}
