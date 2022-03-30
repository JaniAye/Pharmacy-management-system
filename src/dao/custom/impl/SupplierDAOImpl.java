package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.SupplierDAO;
import entity.Supplier;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public boolean save(Supplier supplier) throws Exception {
        return CrudUtill.execute("INSERT INTO Supplier VALUES(?,?,?,?,?)",supplier.getSupId(),supplier.getCompanyName(),
                supplier.getAddress(),supplier.getEmail(),supplier.getPhoneNo());
    }

    @Override
    public boolean update(Supplier supplier) throws Exception {
        return CrudUtill.execute("UPDATE Supplier SET CompanyName=?,Address=?,Email=?,phoneNo=? WHERE SupId=?",supplier.getCompanyName(),
                supplier.getAddress(),supplier.getEmail(),supplier.getPhoneNo(),supplier.getSupId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtill.execute("DELETE FROM Supplier WHERE SupId=?",s);
    }

    @Override
    public Supplier get(String s) throws Exception {
            ResultSet rst = CrudUtill.execute("SELECT * FROM Supplier WHERE SupId=?",s);
        if (rst.next()){
          return new Supplier(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getInt(5));
        }
        return null;
    }

    @Override
    public List<Supplier> getAll() throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM Supplier");
        ArrayList<Supplier> alist=new ArrayList<>();
        while (rst.next()){
            alist.add(new Supplier(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getInt(5)));
        }
        return alist;
    }
}
