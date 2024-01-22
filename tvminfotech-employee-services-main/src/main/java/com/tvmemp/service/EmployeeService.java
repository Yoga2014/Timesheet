package com.tvmemp.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.tvmemp.model.TvmEmployee;

public interface EmployeeService {

	public TvmEmployee saveEmp(TvmEmployee employee);

	public Optional<TvmEmployee> getEmp(Integer id);

	public List<TvmEmployee> getAllEmp(TvmEmployee employee);

	public TvmEmployee updateEmployee(Integer id, TvmEmployee employee);

	public void deleteEmployee(Integer id);

	//filtering employee by specific details
	
	public List<TvmEmployee>getEmployeeBySalary(Long employeesalary );
	
	public List<TvmEmployee>getEmployeefirstName(String employeefirstname );
	
	public List<TvmEmployee>getEmployeeBylastName(String employeelastname );
	
	public List<Map<String, Object>> getEmployeeByPassout(String yearofPassout);
	
	// Getting Employee using Assets id
	
	public List<TvmEmployee> findByAssestId(Integer assestId);
	
	
    public List<TvmEmployee> findByAssestlaptop(String laptop);
    
    public List<TvmEmployee> findByUsersName(String str);
    
    public TvmEmployee getDataFromProject(TvmEmployee us);
    
	public TvmEmployee getStoretechDetails(TvmEmployee user);

	public List<Map<String, Object>> getByNameWithLogin(String empf);

	public List<Map<String, Object>> getByEmpIdWithLogin(Integer id);


	





	
}
