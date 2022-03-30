package bo.Custom.impl;

import bo.Custom.DetailsBO;
import dao.DAOFactory;
import dao.custom.DetailsDAO;
import dao.custom.QuaryDAO;
import dto.DetailsBDTO;
import dto.OrderDetailDTO;
import entity.DetailsB;
import entity.Odetails;

import java.util.ArrayList;

public class DetailsBOImpl implements DetailsBO {
    DetailsDAO dao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Details);
    QuaryDAO qdao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);
    @Override
    public boolean addBatchDetails(DetailsBDTO bdto) throws Exception {
        return dao.save(new DetailsB(bdto.getItCode(),bdto.getBatchID()) );
    }

    @Override
    public boolean deleteBatchDetails(String id) throws Exception {
        return false;
    }



}
