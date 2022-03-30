package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.BatchDAO;
import entity.Batch;

import java.sql.ResultSet;
import java.util.List;

public class BatchDAOImpl implements BatchDAO {


    @Override
    public boolean save(Batch batch) throws Exception {
        return CrudUtill.execute("INSERT INTO batch VALUES(?,?,?)",batch.getBatchID(),batch.getDate(),batch.getTime());
    }

    @Override
    public boolean update(Batch batch) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Batch get(String s) throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM batch WHERE BatchID=?",s);
        if (rst.next()){
            return new Batch(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }

    @Override
    public List<Batch> getAll() throws Exception {
        return null;
    }
}
