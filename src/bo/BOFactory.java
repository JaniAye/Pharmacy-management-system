package bo;

import bo.Custom.impl.*;

public class BOFactory {
    private static BOFactory boFac;

    private BOFactory(){
    }
    public static BOFactory getInstance(){
        if (boFac==null){
            boFac=new BOFactory();
        }
        return boFac;
    }
    public enum BOTYPE{
        Item,Supplier,Employee,Payment,StockDetail,Batch,Details,ORDER,OrderDetails,ITEMRETURN,HOME,ODTEMP,PTEMP
    }
    public <T> T getbo(BOTYPE botype){
        switch (botype){
            case Item:return (T) new ItemBOImpl();
            case Payment:return (T) new PaymentBOImpl();
            case Employee:return (T) new EmployeeBOImpl();
            case Supplier:return (T) new SupplerBOImpl();
            case StockDetail:return (T) new StockDetailBOImpl();
            case Batch:return (T) new BatchBOImpl();
            case Details:return (T) new DetailsBOImpl();
            case ORDER:return (T) new OrderBOImpl();
            case OrderDetails:return (T) new OrdersDetailBOImpl();
            case ITEMRETURN:return (T) new ItemReturnBOImpl();
            case HOME:return (T) new HomeBOImpl();
            case ODTEMP:return (T) new OdTempBOIml();
            case PTEMP:return (T) new PaytempBOImpl();
            default:return null;
        }
    }
}
