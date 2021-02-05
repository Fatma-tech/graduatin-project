package graduation.demo.pharmacymanagementsystem.dao;

import graduation.demo.pharmacymanagementsystem.entity.Employee;

public interface EmployeesDAO {
	public Employee signIn(String theusername, String thepassword);
	public Employee getEmployeeByUsername(String theusername);
	public String restoreThePassword(String username);
}
