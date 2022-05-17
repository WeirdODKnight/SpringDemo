package com.craft.employee.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.craft.employee.model.Employee;

public class EmpDao {
	private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;

	public EmpDao(NamedParameterJdbcTemplate template) {
			this.template = template;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public int saveEmployee(Employee e){
		String query="insert into employee(NAME, AGE, SALARY) values('"+e.getName()+"','"+e.getAge()+"','"+e.getSalary()+"')";
		return jdbcTemplate.update(query);
	}
	public int updateEmployee(Employee e){
		String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"', age='"+e.getAge()+"' where EMPLOYEE_ID='"+e.getEmployeeId()+"' ";
		return jdbcTemplate.update(query);
	}
	public int deleteEmployee(Employee e){
		String query="delete from employee where EMPLOYEE_ID='"+e.getEmployeeId()+"' ";
		return jdbcTemplate.update(query);
	}
	
	public Boolean saveEmployeeByPreparedStatement(final Employee e){
		String query="insert into employee(name, age, salary) values(?,?,?)";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1,e.getName());
				
				ps.setInt(2, e.getAge());
				ps.setInt(3,e.getSalary());
				
				return ps.execute();
				
			}
		});
	}
	
	public List<Employee> getAllEmployees(){
		return jdbcTemplate.query("select * from employee",new ResultSetExtractor<List<Employee>>(){

			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list=new ArrayList<Employee>();
				while(rs.next()){
				Employee e=new Employee();
				e.setEmployeeId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setSalary(rs.getInt(4));
				list.add(e);
				}
				return list;
			}
		});
	  }
	
	public List<Employee> getAllEmployeesRowMapper(){
		return jdbcTemplate.query("select * from employee",new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee e=new Employee();
				e.setEmployeeId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setSalary(rs.getInt(4));
				return e;
			}
		});
	}
	
}