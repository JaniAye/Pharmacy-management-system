package bo.Custom.impl;

import bo.Custom.OdTempBO;
import dao.DAOFactory;
import dao.custom.OdTempDAO;
import dto.OdTempDTO;
import entity.OdTemp;

import java.util.ArrayList;

public class OdTempBOIml implements OdTempBO {
    OdTempDAO oddao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.ODTEMP);
    @Override
    public boolean saveTemp(OdTempDTO tmp) throws Exception {
        return oddao.save(new OdTemp(tmp.getOid(),tmp.getPid(),tmp.getOdate(),tmp.getOtime(),tmp.getTotCost()));
    }

    @Override
    public boolean deleteTemp(String id) throws Exception {
        return oddao.delete(id);
    }

    @Override
    public boolean updateTemp(OdTempDTO tmp) throws Exception {
        return false;
    }

    @Override
    public ArrayList<OdTempDTO> getTemp() throws Exception {
        return null;
    }

    @Override
    public OdTempDTO getTemp(String id) throws Exception {
        return null;
    }
}
