package bo.Custom;

import dto.ItemDTO;
import dto.SupplierDTO;

import java.util.ArrayList;

public interface SupplierBO {
    public boolean SaveSupplier(SupplierDTO dto)throws Exception;
    public boolean UpdateSupplier(SupplierDTO dto)throws Exception;
    public boolean DeleteSupplier(String id)throws Exception;
    public ArrayList<SupplierDTO> GetAllSuppliers()throws Exception;
    public SupplierDTO getSuppler(String id)throws Exception;
    public String getID()throws Exception;
}
