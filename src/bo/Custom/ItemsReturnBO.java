package bo.Custom;

import dto.*;

import java.util.ArrayList;

public interface ItemsReturnBO {
    public boolean AddReturnItems(ItemsReturnDTO dto,UpdateOrdersDtailsDTO upd)throws Exception;
    public ArrayList<ItemsReturnDTO> getallReturnItems()throws Exception;
    public String getID()throws Exception;
}
