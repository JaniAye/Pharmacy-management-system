package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.EmployeeDAO;
import entity.Employee;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO
{

    @Override
    public boolean save(Employee employee) throws Exception {
        return CrudUtill.execute("INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?)",employee.getNIC(),
                employee.getMobile(),employee.getUserFullName(), employee.getUserName(),employee.getPassword(),employee.getRole(),employee.getEmail(),employee.getAddress());
    }

    @Override
    public boolean update(Employee employee) throws Exception {
        return CrudUtill.execute("UPDATE Employee SET Mobile=?,UserFullName=?,UserName=?,Password=?,Role=?,Email=?,address=? WHERE NIC=?",
                employee.getMobile(),employee.getUserFullName(),employee.getUserName(),employee.getPassword(),employee.getRole(),
                employee.getEmail(),employee.getAddress(),employee.getNIC());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtill.execute("DELETE FROM employee WHERE NIC=?",s);
    }

    @Override
    public Employee get(String s) throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT * FROM Employee WHERE UserName=?",s);
        if (rst.next()){
            return new Employee(rst.getString(1),rst.getInt(2),rst.getString(3),rst.getString(4),
                    rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8));
        }
        return null;
    }

    @Override
    public List<Employee> getAll() throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM Employee");
        ArrayList<Employee> alllogins=new ArrayList();
        while (rst.next()){
            alllogins.add(new Employee(rst.getString(1),rst.getInt(2),rst.getString(3),
                    rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return alllogins;
    }
}
