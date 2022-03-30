package bo.Custom;

import dto.BatchDTO;
import dto.ItemDTO;
import dto.StockDetailDTO;
import dto.getAllDTO;

import java.util.ArrayList;

public interface ItemBO {
    public boolean SaveItem(ItemDTO dto, StockDetailDTO sdto, BatchDTO bdto)throws Exception;
    public boolean UpdateItem(ItemDTO dto)throws Exception;
    public boolean DeleteItem(String id)throws Exception;
    public ArrayList<getAllDTO> GetAllItems()throws Exception;
    public ItemDTO getItem(String id)throws Exception;
    public String getID()throws Exception;
    public ArrayList<ItemDTO> getitemsAll(String name)throws Exception;
    public boolean updateQuan(double quan,String id)throws Exception;
    public boolean updateStatus(String status,String icode)throws Exception;
    public int getdateDiff(String date,String date2)throws Exception;




}
