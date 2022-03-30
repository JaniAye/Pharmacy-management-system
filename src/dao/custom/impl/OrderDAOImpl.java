package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.OrderDAO;
import entity.Orders;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Orders orders) throws Exception {
        return CrudUtill.execute("INSERT INTO Orders VALUES (?,?,?,?,?)",orders.getOrderId(),
                orders.getPID(),orders.getOrderDate(),orders.getOrderTime(),orders.getTotCost());
    }

    @Override
    public boolean update(Orders orders) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Orders get(String s) throws Exception {
        ResultSet rst= CrudUtill.execute("SELECT * FROM orders WHERE OrderId=?",s);
        if (rst.next()){
          return new Orders(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getDouble(5));

        }
        return null;
    }

    @Override
    public List<Orders> getAll() throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM orders");
        ArrayList<Orders> order=new ArrayList<>();

        while (rst.next()){
            order.add(new Orders(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getDouble(5)));
        }
        return order;
    }
}
