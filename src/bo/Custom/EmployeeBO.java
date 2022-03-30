package bo.Custom;

import dto.EmployeeDTO;

import java.util.ArrayList;

public interface EmployeeBO {
    public  boolean addEmployee(EmployeeDTO dto)throws Exception;
    public  boolean UpdateEmployee(EmployeeDTO dto)throws Exception;
    public  boolean deleteEmployee(String id)throws Exception;
    public EmployeeDTO GetEmployee(String id)throws Exception;
    public ArrayList<EmployeeDTO> getAllEmployee()throws Exception;
}
