package bo.Custom.impl;

import bo.Custom.StockDetailsBO;
import dao.DAOFactory;
import dao.custom.StockDetailDAO;
import dto.StockDetailDTO;
import entity.StockDetail;

public class StockDetailBOImpl implements StockDetailsBO {
    private StockDetailDAO dao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.StockDetail);
    @Override
    public boolean addStockDetail(StockDetailDTO dto) throws Exception {
        return dao.save(new StockDetail(dto.getItCode(),dto.getSuppCode(),dto.getDate()));
    }
}
