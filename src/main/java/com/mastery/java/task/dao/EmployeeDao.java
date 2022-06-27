package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.mastery.java.task.config.AppConfiguration;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

    private static final class EmployeeMapper implements RowMapper<Employee> {

        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getLong("employee_id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setDepartmentId(rs.getLong("department_id"));
            employee.setJobTitle(rs.getString("job_title"));
            return employee;
        }
    }

    private AppConfiguration appConfiguration;
    private JdbcTemplate jdbcTemplate;

    public EmployeeDao()
    {
        appConfiguration = new AppConfiguration();
        jdbcTemplate  = appConfiguration.jdbcTemplate();
    }

    public List<Employee> findAllEmployees(){
        String sql = "select employee_id, first_name, last_name, department_id, job_title from employee";
        return this.jdbcTemplate.query( sql, new EmployeeMapper());
    }

    public List<Employee> findEmployeesByName(String first_name)
    {
        String sql = "select employee_id, first_name, last_name, department_id, job_title from employee " +
                        "where first_name = ?";
        return this.jdbcTemplate.query( sql, new String[]{first_name},new EmployeeMapper());
    }

    public void addEmployee(Employee _employee)
    {
        String sql = "insert into employee (employee_id, first_name, last_name, department_id, job_title) " +
                "values (?, ?, ?, ?, ?)";


        this.jdbcTemplate.update(sql,
                _employee.getEmployeeId(),
                _employee.getFirstName(),
                _employee.getLastName(),
                _employee.getDepartmentId(),
                _employee.getJobTitle());

    }

    public void deleteByID(long ID)
    {
        String sql = "delete from employee where employee_id = ?";
        this.jdbcTemplate.update(sql, Long.valueOf(ID));
    }

    public Employee findByID(long ID)
    {
        String sql = "select employee_id, first_name, last_name, department_id, job_title from employee " +
                "where employee_id = ?";

        return this.jdbcTemplate.query( sql, new Long[]{ID},new EmployeeMapper()).get(0);
    }

    public void updateEmployee(Employee _employee)
    {
        String sql = "update employee set first_name = ?, " +
                "last_name = ?, " +
                "department_id = ?, " +
                "job_title = ? " +
                "where employee_id = ?";

        this.jdbcTemplate.update(sql, _employee.getFirstName(),
                _employee.getLastName(), _employee.getDepartmentId(),
                _employee.getJobTitle(), _employee.getEmployeeId());
    }

}
