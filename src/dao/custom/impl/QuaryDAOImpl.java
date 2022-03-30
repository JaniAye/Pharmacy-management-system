package dao.custom.impl;

import com.sun.org.apache.regexp.internal.RE;
import dao.CrudUtill;
import dto.OrderDetailDTO;
import entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuaryDAOImpl implements dao.custom.QuaryDAO {

    @Override
    public List<allGet> getAllData() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.execute("SELECT item.ItCode,BatchID,SupId,ItemName,Price,ExpDate,MDate,Status,Quan from batchdetails join item on batchdetails.ItCode=item.ItCode join stockdetails on item.ItCode=stockdetails.ItCode");
        ArrayList<allGet> items=new ArrayList();
        while (rst.next()){
            items.add(new allGet(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8),
                    rst.getDouble(9)));
        }
        return items;
    }
    public List<Item> getItemAll(String name) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT * FROM item WHERE ItemName=?", name);
        ArrayList<Item> itm=new ArrayList();
        while (rst.next()){
          itm.add(new Item(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getString(4),
                    rst.getString(5),rst.getString(6),rst.getDouble(7)));
        }
        return itm;

    }
    public String getOids() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT OrderId FROM orders ORDER BY OrderId DESC LIMIT 1");
        if (rst.next()){
            return  rst.getString(1);
        }

        return null;
    }
    public String getItemCode() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT ItCode FROM item ORDER BY ItCode DESC LIMIT 1");
        if (rst.next()){
            return  rst.getString(1);
        }

        return null;
    }

    @Override
    public String getBID() throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT BatchID FROM batch ORDER BY BatchID DESC LIMIT 1");
        if (rst.next()){
            return  rst.getString(1);
        }

        return null;
    }

    @Override
    public String getSupID() throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT SupId FROM supplier ORDER BY SupId DESC LIMIT 1");
        if (rst.next()){
            return  rst.getString(1);
        }

        return null;
    }

    @Override
    public String getPid() throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT PID FROM payment ORDER BY PID DESC LIMIT 1");
        if (rst.next()){
            return  rst.getString(1);
        }

        return null;
    }

    @Override
    public ArrayList<Returndetail> geOrderDetails(String oid) throws Exception {
        ResultSet resultSet=CrudUtill.execute("SELECT orderdetails.ItCode,ItemName,Price,Quantity,MDate,ExpDate,total from orderdetails join item on orderdetails.ItCode=item.ItCode where OrderId=?",oid);
        ArrayList<Returndetail> alist=new ArrayList<>();
        while (resultSet.next()){
            alist.add(new Returndetail(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4),
                    resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7)));
        }
        return alist;
    }
    public int getMonth(String date) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.execute("SELECT MONTH(?)",date);
        int a=0;
        if (rst.next()){
            a= rst.getInt(1);
        }
        return a;
    }
    public int getYear(String date) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.execute("SELECT YEAR(?)",date);
        int a=0;
        if (rst.next()){
            a= rst.getInt(1);
        }
        return a;
    }
    public boolean itemUpdate(double quan,String id) throws Exception {
        return CrudUtill.execute("UPDATE item SET Quan=? WHERE ItCode=?",quan,id);
    }

    @Override
    public boolean UpdateStatusItem(String status,String code) throws Exception {
        return CrudUtill.execute("UPDATE item SET Status=? WHERE ItCode=?",status,code);
    }

    @Override
    public int getDateDiff(String day, String day2) throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT datediff(?,?)", day, day2);
        if (rst.next()){
         return rst.getInt(1);
        }
    return 0;
    }

    @Override
    public String getTepID() throws Exception {
            ResultSet rst = CrudUtill.execute("SELECT OrderId FROM buytemp ORDER BY OrderId DESC LIMIT 1");
            if (rst.next()){
                return  rst.getString(1);
            }

            return null;
        }



}
