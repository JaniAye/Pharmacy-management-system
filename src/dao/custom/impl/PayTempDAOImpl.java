package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.PayTempDAO;
import entity.PayTemp;

import java.util.List;

public class PayTempDAOImpl implements PayTempDAO {
    @Override
    public boolean save(PayTemp payTemp) throws Exception {
        return CrudUtill.execute("INSERT INTO buytemp VALUES(?,?,?,?,?,?,?,?,?,?)",payTemp.getOrderID(),payTemp.getItCode(),
                payTemp.getItemName(),payTemp.getUnitPrice(),payTemp.getQuantity(),payTemp.getTot(),payTemp.getPtype(),
                payTemp.getCash(),payTemp.getBalance(),payTemp.getTotBill());
    }

    @Override
    public boolean update(PayTemp payTemp) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtill.execute("DELETE FROM buytemp WHERE OrderID=?",s);
    }

    @Override
    public PayTemp get(String s) throws Exception {
        return null;
    }

    @Override
    public List<PayTemp> getAll() throws Exception {
        return null;
    }
}
