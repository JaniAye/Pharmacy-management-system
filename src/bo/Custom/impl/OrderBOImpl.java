package bo.Custom.impl;

import bo.Custom.OrderBO;
import dao.DAOFactory;
import dao.custom.OrderDAO;
import dao.custom.QuaryDAO;
import dao.custom.impl.OrderDAOImpl;
import dto.OrderDTO;
import entity.Orders;

import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {
    OrderDAO dao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.ORDER);
    QuaryDAO quaryDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);
    @Override
    public boolean SaveItem(OrderDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean UpdateItem(OrderDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean DeleteItem(String id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<OrderDTO> GetAllItems() throws Exception {
        List<Orders> all = dao.getAll();
        ArrayList<OrderDTO> dtolist=new ArrayList<>();
        for(Orders od:all){
            dtolist.add(new OrderDTO(od.getOrderId(),od.getPID(),od.getOrderDate(),od.getOrderTime(),od.getTotCost()));
        }
        return dtolist;
    }

    @Override
    public OrderDTO getItem(String id) throws Exception {
        Orders orders = dao.get(id);
        if (orders!=null) {
            return new OrderDTO(orders.getOrderId(), orders.getPID(), orders.getOrderDate(), orders.getOrderTime(), orders.getTotCost());
        }
        return null;
    }

    @Override
    public String getID() throws Exception {
        return quaryDAO.getOids();
    }
    public int getMonth(String date) throws Exception {
        int month = quaryDAO.getMonth(date);
        return month;
    }
    public int getYear(String date) throws Exception {
        int year = quaryDAO.getYear(date);
        return year;
    }

}
