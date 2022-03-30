package dao.custom.impl;

import dao.CrudDAO;
import dao.CrudUtill;
import dao.custom.StockDetailDAO;
import entity.StockDetail;

import java.util.List;

public class StockDetailDAOImpl implements StockDetailDAO {
    @Override
    public boolean save(StockDetail stockDetail) throws Exception {
        return CrudUtill.execute("INSERT INTO stockdetails VALUES(?,?,?)",stockDetail.getItCode(),stockDetail.getSupId(),
                stockDetail.getDate());
    }

    @Override
    public boolean update(StockDetail stockDetail) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public StockDetail get(String s) throws Exception {
        return null;
    }

    @Override
    public List<StockDetail> getAll() throws Exception {
        return null;
    }
}
