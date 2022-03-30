package bo.Custom.impl;

import bo.Custom.BatchBO;
import dao.DAOFactory;
import dao.custom.BatchDAO;
import dao.custom.QuaryDAO;
import dto.BatchDTO;
import entity.Batch;

public class BatchBOImpl implements BatchBO {
    private BatchDAO dao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Batch);
    private QuaryDAO quaryDAO=DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);
    @Override
    public boolean AddBatch(BatchDTO dto) throws Exception {
        return dao.save(new Batch(dto.getBatchId(),dto.getDate(),dto.getTime()));
    }

    @Override
    public boolean deleteBatch(String bid) {
        return false;
    }

    @Override
    public String getBid() throws Exception {
        return quaryDAO.getBID();
    }
}
