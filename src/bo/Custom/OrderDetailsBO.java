package bo.Custom;

import dto.*;
import entity.OrderDetail;

import java.util.ArrayList;

public interface OrderDetailsBO {
    public boolean saveOrderdetails(OrderDetailDTO dto)throws Exception;
    public boolean UpdateOD(OrderDetailDTO dto)throws Exception;
    public boolean DeleteOD(String id)throws Exception;
    public ArrayList<OrderDetail> GetallOD()throws Exception;
    public ArrayList<ReturnDTO> GetOD(String id)throws Exception;
    public int dateDiff(String date,String date2)throws Exception;

}
