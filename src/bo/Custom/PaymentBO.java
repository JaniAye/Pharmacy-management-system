package bo.Custom;

import dto.*;
import javafx.collections.ObservableList;
import view.tm.OrdersTM;

import java.util.ArrayList;

public interface PaymentBO {

    public boolean SaveItem(PaymentDTO dto, OrderDTO orderDTO, ObservableList<OrdersTM> orderDetailDTOS)throws Exception;
    public ArrayList<PaymentDTO> GetAllItems()throws Exception;
    public ItemDTO getItem(String id)throws Exception;
    public String getPid()throws Exception;

}
