package bo.Custom;

import dto.*;

import java.util.ArrayList;

public interface OrderBO {
    public boolean SaveItem(OrderDTO dto)throws Exception;
    public boolean UpdateItem(OrderDTO dto)throws Exception;
    public boolean DeleteItem(String id)throws Exception;
    public ArrayList<OrderDTO> GetAllItems()throws Exception;
    public OrderDTO getItem(String id)throws Exception;
    public String getID()throws Exception;
    public int getMonth(String date) throws Exception;
    public int getYear(String date) throws Exception;
}
