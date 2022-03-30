package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.ItemReturnDAO;
import entity.ItemsReturn;

import java.util.List;

public class ItemReturnDAOImpl implements ItemReturnDAO {
    @Override
    public boolean save(ItemsReturn itemsReturn) throws Exception {
        return CrudUtill.execute("INSERT INTO Returnitem VALUES(?,?,?,?,?,?,?)",itemsReturn.getItCode(),
                itemsReturn.getOrderId(),itemsReturn.getReturnid(),itemsReturn.getReturnQuantity(),itemsReturn.getReturnDate(),
                itemsReturn.getReturnedCost(),itemsReturn.getReason());
    }

    @Override
    public boolean update(ItemsReturn itemsReturn) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ItemsReturn get(String s) throws Exception {
        return null;
    }

    @Override
    public List<ItemsReturn> getAll() throws Exception {
        return null;
    }
}
