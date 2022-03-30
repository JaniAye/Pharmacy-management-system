package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.OdTempDAO;
import entity.OdTemp;

import java.util.List;

public class OdTempDAOImpl implements OdTempDAO {
    @Override
    public boolean save(OdTemp odTemp) throws Exception {
        return CrudUtill.execute("INSERT INTO OdTemp VALUES(?,?,?,?,?)",odTemp.getOrderId(),odTemp.getPID(),
                odTemp.getOrderDate(),odTemp.getOrderTime(),odTemp.getTotCost());
    }

    @Override
    public boolean update(OdTemp odTemp) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtill.execute("DELETE FROM OdTemp WHERE OrderId=?",s);
    }

    @Override
    public OdTemp get(String s) throws Exception {
        return null;
    }

    @Override
    public List<OdTemp> getAll() throws Exception {
        return null;
    }
}
