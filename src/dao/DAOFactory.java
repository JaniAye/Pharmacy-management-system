package dao;

import bo.Custom.impl.DetailsBOImpl;
import dao.custom.StockDetailDAO;
import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getInstance(){
        return (daoFactory==null)?(daoFactory=new DAOFactory()):(daoFactory);
    }
    public enum DAOType{
        Item,Supplier,Employee,Payment,StockDetail,Batch,Details,Quary,ORDER,ORDERDETAIL,ITEMRETURN,ODTEMP,PAYTEMP
    }
    public <T> T getdao(DAOType type){
        switch (type){
            case Item:return(T) new ItemDAOImpl();
            case Supplier:return (T)new SupplierDAOImpl();
            case Employee:return (T) new EmployeeDAOImpl();
            case Payment:return (T) new PaymentDAOImpl();
            case StockDetail:return (T) new StockDetailDAOImpl();
            case Batch:return (T) new BatchDAOImpl();
            case Details:return (T) new DetailsDAOImpl();
            case Quary:return (T) new QuaryDAOImpl();
            case ORDER:return (T) new OrderDAOImpl();
            case ORDERDETAIL:return (T) new OrderDetailDAOImpl();
            case ITEMRETURN:return (T) new ItemReturnDAOImpl();
            case ODTEMP:return (T) new OdTempDAOImpl();
            case PAYTEMP:return (T) new PayTempDAOImpl();
            default:return null;
        }
    }
}
