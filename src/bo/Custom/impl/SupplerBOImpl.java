package bo.Custom.impl;

import bo.Custom.SupplierBO;
import dao.DAOFactory;
import dao.custom.QuaryDAO;
import dao.custom.SupplierDAO;
import dto.ItemDTO;
import dto.SupplierDTO;
import entity.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplerBOImpl implements SupplierBO {
    private SupplierDAO dao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Supplier);
    private QuaryDAO quaryDAO= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Quary);
    @Override
    public boolean SaveSupplier(SupplierDTO dto) throws Exception {
        return dao.save(new Supplier(dto.getSupID(),dto.getCompanyName(),dto.getEmail(),dto.getAddress(),dto.getPhoneNO()));
    }

    @Override
    public boolean UpdateSupplier(SupplierDTO dto) throws Exception {
        return dao.update(new Supplier(dto.getSupID(),dto.getCompanyName(),dto.getEmail(),dto.getAddress(),dto.getPhoneNO()));
    }

    @Override
    public boolean DeleteSupplier(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public ArrayList<SupplierDTO> GetAllSuppliers() throws Exception {
        List<Supplier> sup=dao.getAll();
        ArrayList<SupplierDTO> dtolist=new ArrayList<>();
        for (Supplier suplist:sup){
            dtolist.add(new SupplierDTO(suplist.getSupId(),suplist.getCompanyName(),suplist.getAddress(),suplist.getEmail(),suplist.getPhoneNo()));
        }
        return dtolist;
    }

    @Override
    public SupplierDTO getSuppler(String id) throws Exception {
        Supplier supplier=dao.get(id);
        if (supplier!=null) {
            return new SupplierDTO(supplier.getSupId(), supplier.getCompanyName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhoneNo());
        }
        return null;
    }

    @Override
    public String getID() throws Exception {
        return quaryDAO.getSupID();
    }
}
