package com.tvmemp.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tvmemp.model.TvmEmployee;

public interface EmployeeService {

	/**
	 * 
	 * @param employee
	 * @return
	 */
	public TvmEmployee saveEmp(TvmEmployee employee);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<TvmEmployee> getEmp(Integer id);

	/**
	 * 
	 * @return
	 */
	public List<TvmEmployee> getAllEmp();

	/**
	 * 
	 * @param id
	 * @param employee
	 * @return
	 */
	public TvmEmployee updateEmployee(Integer id, TvmEmployee employee);

	/**
	 * 
	 * @param id
	 */
	public void deleteEmployee(Integer id);

	//filtering employee by specific details
	
	/**
	 * 
	 * @param employeesalary
	 * @return
	 */
	public List<TvmEmployee>getEmployeeBySalary(Long employeesalary );
	
	/**
	 * 
	 * @param employeefirstname
	 * @return
	 */
	public List<TvmEmployee>getEmployeefirstName(String employeefirstname );
	
	/**
	 * 
	 * @param employeelastname
	 * @return
	 */
	public List<TvmEmployee>getEmployeeBylastName(String employeelastname );
	
	/**
	 * 
	 * @param yearofPassout
	 * @return
	 */
	public List<Map<String, Object>> getEmployeeByPassout(String yearofPassout);
	
	// Getting Employee using Assets id
	
	/**
	 * 
	 * @param assestId
	 * @return
	 */
	public List<TvmEmployee> findByAssestId(Integer assestId);
	
	
	/**
	 * 
	 * @param laptop
	 * @return
	 */
    public List<TvmEmployee> findByAssestlaptop(String laptop);
    
    /**
     * 
     * @param str
     * @return
     */
    public List<TvmEmployee> findByUsersName(String str);
    
    /**
     * 
     * @param us
     * @return
     */
    public TvmEmployee getDataFromProject(TvmEmployee us);
    
    /**
     * 
     * @param user
     * @return
     */
	public TvmEmployee getStoretechDetails(TvmEmployee user);

	/**
	 * 
	 * @param empf
	 * @return
	 */
	public List<Map<String, Object>> getByNameWithLogin(String empf);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getByEmpIdWithLogin(Integer id);
	
	public TvmEmployee getEmployeeIdWithImagedetails(Integer employeeid);


	public  TvmEmployee saveEmployee(TvmEmployee employee);

	public List<Map<String, Object>> getAllEmpName();
	
     




	
}
