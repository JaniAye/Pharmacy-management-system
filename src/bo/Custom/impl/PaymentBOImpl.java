package bo.Custom.impl;

import bo.BOFactory;
import bo.Custom.PaymentBO;
import dao.DAOFactory;
import dao.custom.*;
import db.DBConnection;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import dto.PaymentDTO;
import entity.OrderDetail;
import entity.Orders;
import entity.PayTemp;
import entity.Payment;
import javafx.collections.ObservableList;
import view.tm.OrdersTM;

import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    private PaymentDAO paymentDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Payment);
    private OrderDAO orderDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.ORDER);
    private OrderDetailDAO orderDetailDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.ORDERDETAIL);
    private QuaryDAO quaryDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);
    private PayTempDAO payTempDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.PAYTEMP);


    @Override
    public boolean SaveItem(PaymentDTO dto, OrderDTO orderDTO, ObservableList<OrdersTM> orderDetailDTO) throws Exception {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        try {

            boolean payadd = paymentDAO.save(new Payment(dto.getPid(), dto.getCost(), dto.getType(), dto.getCash(), dto.getBalance()));
            if (payadd) {
                boolean orderADD = orderDAO.save(new Orders(orderDTO.getOid(), orderDTO.getPid(), orderDTO.getOdate(), orderDTO.getOtime(),orderDTO.getTotCost()));
                if (orderADD){
                    boolean isadded=false;
                    for (OrdersTM dtoo:orderDetailDTO) {
                        isadded= orderDetailDAO.save(new OrderDetail(dtoo.getItcode(),orderDTO.getOid(),
                                dtoo.getTot(),dtoo.getQuan()));

                        payTempDAO.save(new PayTemp(orderDTO.getOid(),dtoo.getItcode(),dtoo.getItemname(),
                                dtoo.getUp(),dtoo.getQuan(),dtoo.getTot(),dto.getType(),dto.getCash(),dto.getBalance(),dto.getCost()));
                    }
                    DBConnection.getInstance().getConnection().commit();
                    return isadded;

                }

            }

        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
        return false;

    }

    @Override
    public ArrayList<PaymentDTO> GetAllItems() throws Exception {
        return null;
    }

    @Override
    public ItemDTO getItem(String id) throws Exception {
        return null;
    }

    @Override
    public String getPid() throws Exception {
        return quaryDAO.getPid();
    }
}
