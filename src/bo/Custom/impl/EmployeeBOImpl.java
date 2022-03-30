package bo.Custom.impl;

import bo.Custom.EmployeeBO;
import dao.DAOFactory;
import dao.custom.EmployeeDAO;
import dto.EmployeeDTO;
import entity.Employee;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO dao= DAOFactory.getInstance().getdao(DAOFactory.DAOType.Employee);
    @Override
    public boolean addEmployee(EmployeeDTO dto) throws Exception {
        return dao.save(new Employee(dto.getNIC(),dto.getMobileNo(),dto.getUserFullName(),dto.getUn(),
                dto.getPass(),dto.getRole(),dto.getEmail(),dto.getAdddress()));
    }

    @Override
    public boolean UpdateEmployee(EmployeeDTO dto) throws Exception {
        return dao.update(new Employee(dto.getNIC(),dto.getMobileNo(),dto.getUserFullName(),dto.getUn(),dto.getPass(),dto.getRole(),dto.getEmail(),dto.getAdddress()));
    }

    @Override
    public boolean deleteEmployee(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public EmployeeDTO GetEmployee(String id) throws Exception {
        Employee employee = dao.get(id);
        return new EmployeeDTO(employee.getNIC(),employee.getMobile(),employee.getUserFullName(),employee.getUserName(),employee.getPassword(),
                employee.getRole(),employee.getEmail(),employee.getAddress());
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws Exception {
        List<Employee> alllogins=dao.getAll();
        ArrayList<EmployeeDTO> dtolist=new ArrayList<>();
        for(Employee employee:alllogins){
            dtolist.add(new EmployeeDTO(employee.getNIC(),employee.getMobile(),employee.getUserFullName(),employee.getUserName(),employee.getPassword(),
                    employee.getRole(),employee.getEmail(),employee.getAddress()));
        }
        return dtolist;
    }
}
