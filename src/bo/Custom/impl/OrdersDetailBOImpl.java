package bo.Custom.impl;

import bo.Custom.OrderDetailsBO;
import dao.DAOFactory;
import dao.custom.OrderDetailDAO;
import dao.custom.QuaryDAO;
import dto.ItemDTO;
import dto.OrderDetailDTO;
import dto.ReturnDTO;
import entity.Odetails;
import entity.OrderDetail;
import entity.Returndetail;

import java.util.ArrayList;

public class OrdersDetailBOImpl implements OrderDetailsBO {
    OrderDetailDAO dao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.ORDERDETAIL);
    QuaryDAO qdao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);
    @Override
    public boolean saveOrderdetails(OrderDetailDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean UpdateOD(OrderDetailDTO dto) throws Exception {
        return dao.update(new OrderDetail(dto.getOid(),dto.getItCode(),dto.getTprice(),dto.getQuan()));
    }

    @Override
    public boolean DeleteOD(String id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<OrderDetail> GetallOD() throws Exception {
        return null;
    }


    @Override
    public ArrayList<ReturnDTO> GetOD(String id) throws Exception {
        ArrayList<Returndetail> lst=qdao.geOrderDetails(id);
        ArrayList<ReturnDTO> dtolist=new ArrayList<>();
        for(Returndetail dt:lst){
            dtolist.add(new ReturnDTO(dt.getItcode(),dt.getItName(),dt.getPrice(),dt.getQuantity(),dt.getMDate(),dt.getExpDate(),
                    dt.getUnitPrice()));
        }
        return dtolist;
    }

    @Override
    public int dateDiff(String date, String date2) throws Exception {
        return qdao.getDateDiff(date,date2);
    }

}
