package bo.Custom.impl;

import bo.BOFactory;
import bo.Custom.PayTempBO;
import dao.DAOFactory;
import dao.custom.PayTempDAO;
import dao.custom.QuaryDAO;
import dto.PaymentDTO;
import dto.getAllDTO;

import java.util.ArrayList;

public class PaytempBOImpl implements PayTempBO {
    QuaryDAO quaryDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);
    PayTempDAO payTempDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.PAYTEMP);
    @Override
    public boolean SaveItem(PaymentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean UpdateItem(PaymentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean DeleteItem(String id) throws Exception {
        return payTempDAO.delete(id);
    }

    @Override
    public String getTempID() throws Exception {
        return quaryDAO.getTepID();
    }

    @Override
    public ArrayList<getAllDTO> GetAllItems() throws Exception {
        return null;
    }
}
