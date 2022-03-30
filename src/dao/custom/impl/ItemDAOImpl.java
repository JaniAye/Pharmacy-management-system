package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.ItemDAO;
import entity.Item;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
        public boolean save(Item item) throws Exception {
        return CrudUtill.execute("INSERT INTO Item VALUES(?,?,?,?,?,?,?)",item.getItCode(),
                item.getItemName(),item.getPrice(),item.getExpDate(),item.getMDate(),item.getStatus(),
                item.getQuan());
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtill.execute("UPDATE item SET ItemName=?,Price=?,ExpDate=?,MDate=?,Status=?,Quan=? WHERE ItCode=?",
                item.getItemName(),item.getPrice(),item.getExpDate(),item.getMDate(),item.getStatus(),item.getQuan(),item.getItCode());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtill.execute("DELETE FROM item WHERE ItCode=?",s);
    }

    @Override
    public Item get(String s) throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT * FROM item WHERE ItemName=?", s);
        if (rst.next()){
            return new Item(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getString(4),rst.getString(5),
                    rst.getString(6),rst.getDouble(7));
        }
        return null;
    }

    @Override
    public List<Item> getAll() throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM Item");
        ArrayList<Item> items=new ArrayList();
        while (rst.next()){
            items.add(new Item(rst.getString(1),rst.getString(2),
                    rst.getDouble(3),rst.getString(4),rst.getString(5),rst.getString(6),
                    rst.getDouble(7)));
        }
        return items;
    }
}
