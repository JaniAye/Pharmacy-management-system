package dao.custom;

import dao.CrudUtill;
import dao.SuperDAO;
import entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface QuaryDAO extends SuperDAO {
    public List<allGet> getAllData()throws Exception;
    public List<Item> getItemAll(String name)throws Exception;
    public String getOids()throws Exception;
    public String getItemCode()throws Exception;
    public String getBID()throws Exception;
    public String getSupID()throws Exception;
    public String getPid()throws Exception;
    public ArrayList<Returndetail> geOrderDetails(String oid)throws Exception;
    public int getMonth(String date) throws Exception;
    public int getYear(String date) throws Exception;
    public boolean itemUpdate(double quan,String id) throws Exception;
    public boolean UpdateStatusItem(String status,String code) throws Exception;
    public int getDateDiff(String day,String day2)throws Exception;
    public String getTepID() throws Exception;

}
