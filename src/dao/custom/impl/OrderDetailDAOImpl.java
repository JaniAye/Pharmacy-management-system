package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.OrderDetailDAO;
import entity.OrderDetail;

import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetail orderDetail) throws Exception {
        return CrudUtill.execute("INSERT INTO orderdetails VALUES(?,?,?,?)",orderDetail.getItCode(),
                orderDetail.getOrderId(),orderDetail.getUnitPrice(),orderDetail.getQuantity());
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws Exception {
        return CrudUtill.execute("UPDATE orderdetails SET total=?,Quantity=? WHERE  ItCode=? and OrderId=?",
                orderDetail.getUnitPrice(),orderDetail.getQuantity(),orderDetail.getItCode(),orderDetail.getOrderId());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public OrderDetail get(String s) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetail> getAll() throws Exception {
        return null;
    }
}
