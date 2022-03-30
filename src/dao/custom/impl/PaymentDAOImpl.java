package dao.custom.impl;

import dao.CrudUtill;
import entity.Payment;

import java.util.List;

public class PaymentDAOImpl implements dao.custom.PaymentDAO {
    @Override
    public boolean save(Payment payment) throws Exception {
        return CrudUtill.execute("INSERT INTO Payment VALUES(?,?,?,?,?)",payment.getPID(),payment.getCost(),
                payment.getType(),payment.getCash(),payment.getBalance());
    }

    @Override
    public boolean update(Payment payment) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Payment get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Payment> getAll() throws Exception {
        return null;
    }
}
