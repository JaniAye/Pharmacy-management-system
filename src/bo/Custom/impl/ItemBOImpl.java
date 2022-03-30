package bo.Custom.impl;

import bo.Custom.ItemBO;
import dao.DAOFactory;
import dao.custom.*;
import db.DBConnection;
import dto.BatchDTO;
import dto.ItemDTO;
import dto.StockDetailDTO;
import dto.getAllDTO;
import entity.*;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    private ItemDAO dao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Item);
    private StockDetailDAO stkdao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.StockDetail);
    private BatchDAO bdao=DAOFactory.getInstance().getdao(DAOFactory.DAOType.Batch);
    private DetailsDAO detailsDAO=DAOFactory.getInstance().getdao(DAOFactory.DAOType.Details);
    private QuaryDAO qdo=DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);

    @Override
    public boolean SaveItem(ItemDTO dto, StockDetailDTO sdto, BatchDTO bdto) throws Exception {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        try {
            boolean isAdd = dao.save(new Item(dto.getItemCode(), dto.getItemName(), dto.getPrice(), dto.getExpDate(), dto.getMdate(),
                    dto.getStatus(), dto.getQuan()));
            if (isAdd) {
                boolean stdetailAdd = stkdao.save(new StockDetail(sdto.getItCode(), sdto.getSuppCode(), sdto.getDate()));
                if (stdetailAdd) {
                    Batch bt=bdao.get(bdto.getBatchId());

                    if (bt==null){
                        boolean batchdtadd = bdao.save(new Batch(bdto.getBatchId(), bdto.getDate(), bdto.getTime()));
                    }else {}
                        boolean deailsAdd = detailsDAO.save(new DetailsB(dto.getItemCode(), bdto.getBatchId()));
                        DBConnection.getInstance().getConnection().commit();
                        return deailsAdd;

                }else {
                    DBConnection.getInstance().getConnection().rollback();
                }
            }

            return false;
        }finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }

    }

    @Override
    public boolean UpdateItem(ItemDTO dto) throws Exception {
        return dao.update(new Item(dto.getItemCode(),dto.getItemName(),dto.getPrice(),dto.getExpDate(),dto.getMdate(),
                dto.getStatus(),dto.getQuan()));
    }

    @Override
    public boolean DeleteItem(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public ArrayList<getAllDTO> GetAllItems() throws Exception {
        List<allGet> allData = qdo.getAllData();
        ArrayList<getAllDTO> dtlist=new ArrayList<>();
        for (allGet i:allData) {
            dtlist.add(new getAllDTO(i.getItCode(),i.getBatchID(),i.getSupId(),i.getItemName(),
                    i.getPrice(),i.getExpDate(),i.getMDate(),i.getStatus(),i.getQuan()));
        }
        return dtlist;
    }

    @Override
    public ItemDTO getItem(String id) throws Exception {
        Item itemDetails =dao.get(id);
        if (itemDetails!=null){
            return new ItemDTO(itemDetails.getItCode(),itemDetails.getItemName(),itemDetails.getPrice(),itemDetails.getExpDate(),
                    itemDetails.getMDate(),itemDetails.getStatus(),itemDetails.getQuan());
        }
       return null;
    }

    @Override
    public String getID() throws Exception {
       return qdo.getItemCode();


    }

    @Override
    public ArrayList<ItemDTO> getitemsAll(String name) throws Exception {
        List<Item> itemAll = qdo.getItemAll(name);
        ArrayList<ItemDTO> itms=new ArrayList();
        for (Item itm:itemAll){
            itms.add(new ItemDTO(itm.getItCode(),itm.getItemName(),itm.getPrice(),itm.getExpDate(),itm.getMDate(),itm.getStatus(),
                    itm.getQuan()));
        }
        return itms;
    }

    @Override
    public boolean updateQuan(double quan, String id) throws Exception {
        return  qdo.itemUpdate(quan,id);
    }

    @Override
    public boolean updateStatus(String status, String icode) throws Exception {
        return qdo.UpdateStatusItem(status,icode);
    }

    @Override
    public int getdateDiff(String date, String date2) throws Exception {
        return qdo.getDateDiff(date,date2);
    }


}
