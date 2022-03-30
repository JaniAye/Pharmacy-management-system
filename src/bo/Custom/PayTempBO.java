package bo.Custom;

import dto.*;

import java.util.ArrayList;

public interface PayTempBO {
    public boolean SaveItem(PaymentDTO dto)throws Exception;
    public boolean UpdateItem(PaymentDTO dto)throws Exception;
    public boolean DeleteItem(String id)throws Exception;
    public String getTempID()throws Exception;
    public ArrayList<getAllDTO> GetAllItems()throws Exception;
}
