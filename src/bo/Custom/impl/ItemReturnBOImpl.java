package bo.Custom.impl;

import bo.Custom.ItemsReturnBO;
import dao.DAOFactory;
import dao.custom.ItemReturnDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailDAO;
import dto.ItemsReturnDTO;
import dto.UpdateOrdersDtailsDTO;
import entity.ItemsReturn;
import entity.OrderDetail;

import java.util.ArrayList;

public class ItemReturnBOImpl implements ItemsReturnBO {
    ItemReturnDAO irdao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.ITEMRETURN);
    OrderDetailDAO odao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.ORDERDETAIL);
    @Override
    public boolean AddReturnItems(ItemsReturnDTO dto, UpdateOrdersDtailsDTO upd) throws Exception {
        boolean issvd= irdao.save(new ItemsReturn(dto.getItCode(),dto.getOrderId(),dto.getReturnid(),dto.getReturnQuantity(),dto.getReturnDate(),
                dto.getReturnedCost(),dto.getReason()));
        if (issvd){
            boolean isupd=odao.update(new OrderDetail(dto.getItCode(),upd.getOid(),upd.getTot(),upd.getQuan()));
            return  isupd;
        }
        return false;
    }

    @Override
    public ArrayList<ItemsReturnDTO> getallReturnItems() throws Exception {
        return null;
    }

    @Override
    public String getID() throws Exception {
        return null;
    }
}
