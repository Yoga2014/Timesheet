package com.tvmemp.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.tvmemp.model.Employee_Assest;
import com.tvmemp.model.TvmEmployee;
import com.tvmemp.repository.TvmEmployeeRepository;

/**
 * EmployeeServiceImpl class
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private TvmEmployeeRepository repo;

	/**
	 * save employee details
	 */
	
	@Override
	public TvmEmployee saveEmp(TvmEmployee employee) {
		return repo.save(employee);
	}

	// get
	@Override
	public Optional<TvmEmployee> getEmp(Integer id) {

		return repo.findById(id);

	}

	// getAll
	@Override
	public List<TvmEmployee> getAllEmp() {
		return repo.findAll();
	}

	// put
	@Override
	public TvmEmployee updateEmployee(Integer id, TvmEmployee employee) {

		Optional<TvmEmployee> tvm = repo.findById(id);
		TvmEmployee emp1 = tvm.get();
		emp1.setEmployeeEmail(employee.getEmployeeEmail());
		emp1.setEmployeeeSalary(employee.getEmployeeeSalary());
		emp1.setEmployeeFirstname(employee.getEmployeeFirstname());
		emp1.setEmployeeLastname(employee.getEmployeeLastname());
		emp1.setEmployeePhone(employee.getEmployeePhone());
		emp1.setEmployeeAddress(employee.getEmployeeAddress());
		emp1.setEmployeeEducation(employee.getEmployeeEducation());
		emp1.setAssest(employee.getAssest());
		emp1.setEmployeetechnologydetails(employee.getEmployeetechnologydetails());
		emp1.setEmployeeprojectdetails(employee.getEmployeeprojectdetails());
		
		return repo.save(emp1);

	}

	// delete
	@Override
	public void deleteEmployee(Integer id) {

		repo.deleteById(id);

	}

	// filtering employee by specific details

	@Override
	public List<TvmEmployee> getEmployeeBySalary(Long employeesalary) {

		return repo.getEmployeeBySalary(employeesalary);
	}

	@Override
	public List<TvmEmployee> getEmployeefirstName(String employeefirstname) {

		return repo.getEmployeefirstName(employeefirstname);
	}

	@Override
	public List<TvmEmployee> getEmployeeBylastName(String employeelastname) {
		return repo.getEmployeeBylastName(employeelastname);
	}

	@Override
	public List<Map<String,Object>> getEmployeeByPassout(String yearofPassout) {
		
		return repo.getEmployeeByPassout(yearofPassout);
	}

	//Getting Employee details Using Assets Id
	
	@Override
	public List<TvmEmployee> findByAssestId(Integer assest) {
		
		return repo.findByAssestId(assest);
	}

	@Override
	public List<TvmEmployee> findByAssestlaptop(String laptop) {
		
		return repo.findByAssestlaptop(laptop);
	}

	@Override
	public List<TvmEmployee> findByUsersName(String str) {
		
		return repo.getUsersByTechnology(str);
	}

	@Override
	public TvmEmployee getDataFromProject(TvmEmployee us) {
		
		return repo.save(us);
	}

	@Override
	public TvmEmployee getStoretechDetails(TvmEmployee user) {
		
		return repo.save(user);
	}

	@Override
	public List<Map<String, Object>> getByNameWithLogin(String empf) {
		// TODO Auto-generated method stub
		return repo.getByNameLoginDetails(empf);
	}

	@Override
	public List<Map<String, Object>> getByEmpIdWithLogin(Integer id) {
		
		return repo.getByEmpIdLogio(id);
	}
	


	

	

}
