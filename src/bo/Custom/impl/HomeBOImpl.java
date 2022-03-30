package bo.Custom.impl;

import bo.Custom.HomeBO;
import dao.DAOFactory;
import dao.custom.QuaryDAO;

public class HomeBOImpl implements HomeBO {
    QuaryDAO qd= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);
    @Override
    public int getDateDiff(String day, String day2) throws Exception {
        return qd.getDateDiff(day,day2);

    }
}
