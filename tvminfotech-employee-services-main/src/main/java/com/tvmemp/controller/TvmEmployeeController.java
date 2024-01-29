package com.tvmemp.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmemp.model.TvmEmployee;
import com.tvmemp.service.EmployeeService;

// TVM Employee Controller Class

@RestController
@RequestMapping("/tvm")
public class TvmEmployeeController {

	@Autowired
	private EmployeeService ser;

	@PostMapping("/saveEmployee")
	public TvmEmployee postEmployee(@RequestBody TvmEmployee employee) {

		return ser.saveEmp(employee);
	}

	@GetMapping("/getEmployee/{id}")
	public Optional<TvmEmployee> getEmployee(@PathVariable("id") Integer id) {

		return ser.getEmp(id);
	}

	@GetMapping("/getAllEmployee")
	public List<TvmEmployee> getAllEmployee(TvmEmployee employee) {
		return ser.getAllEmp(employee);
	}

	@GetMapping("/getAllEmployee/{salary}")
	public List<TvmEmployee> getAllEmployee(@PathVariable("salary") Long salary) {
		return ser.getEmployeeBySalary(salary);
	}

	@PutMapping("/updateEmp/{id}")
	public TvmEmployee updateEmp(@PathVariable("id") Integer id, @RequestBody TvmEmployee emp) {

		return ser.updateEmployee(id, emp);

	}

	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id) {

		ser.deleteEmployee(id);

		return "Deleted Successfully !!!!";

	}

	// filtering employee by specific details

	@GetMapping("/employeefirstname/{employeefirstname}")
	public List<TvmEmployee> getAllEmployeebyName(@PathVariable("employeefirstname") String employeefirstname) {
		return ser.getEmployeefirstName(employeefirstname);
	}

	@GetMapping("/employeelastname/{employeelastname}")
	public List<TvmEmployee> getAllEmployeebylastName(@PathVariable("employeelastname") String employeelastname) {
		return ser.getEmployeeBylastName(employeelastname);
	}

	@GetMapping("/employeepassout/{yearofPassout}")
	public List<Map<String, Object>>getAllEmployeebyyearofPassout(@PathVariable("yearofPassout") String yearofPassout) {
		return ser.getEmployeeByPassout(yearofPassout);
	}

	// Getting Assets Details Using assets id
	
	 @GetMapping("/getEmployeeByAssestId/{assestId}")
	    public List<TvmEmployee> getEmployeeByAssestId(@PathVariable("assestId") Integer assestId) {
	        return ser.findByAssestId(assestId);
	    }
	 
	 @GetMapping("/getEmployeeByAssestlaptop/{laptop}")
	    public List<TvmEmployee> getEmployeeByAssestlaptop(@PathVariable("laptop") String laptop) {
	        return ser.findByAssestlaptop(laptop);
	    
	 }
	 //Employee Technologies
	 
	 @GetMapping("/getByTechName/{techname}")
		public List<TvmEmployee> getByName(@PathVariable("techname") String str)
		{
			return ser.findByUsersName(str);
		}

		
	 //Employee Log details 
	 
		@GetMapping("/getBynameLogin/{employeefirstname}")
		public List<Map<String, Object>> getEmployeeNameWithInfoLogin(@PathVariable("employeefirstname") String empf){
			return ser.getByNameWithLogin(empf);
		}

		@GetMapping("/getbyedlog/{employeeid}")
		public List<Map<String, Object>> getByemployeeIdLog(@PathVariable("employeeid") Integer id){
			return ser.getByEmpIdWithLogin(id);
		}
		

}