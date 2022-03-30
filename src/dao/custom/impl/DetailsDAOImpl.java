package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.DetailsDAO;
import entity.DetailsB;

import java.util.List;

public class DetailsDAOImpl implements DetailsDAO {
    @Override
    public boolean save(DetailsB detailsB) throws Exception {
        return CrudUtill.execute("INSERT INTO BatchDetails VALUES(?,?)",detailsB.getItCode(),detailsB.getBatchID());
    }

    @Override
    public boolean update(DetailsB detailsB) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public DetailsB get(String s) throws Exception {
        return null;
    }

    @Override
    public List<DetailsB> getAll() throws Exception {
        return null;
    }
}
