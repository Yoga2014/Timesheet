package com.tvmemp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tvmemp.model.TvmEmployee;
import com.tvmemp.repository.TvmEmployeeRepository;
import com.tvmemp.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	private TvmEmployeeRepository repo;

	@InjectMocks
	private EmployeeServiceImpl service;

	TvmEmployee emp = null;

	@Before
	public void setUp() {

		emp = new TvmEmployee();

		emp.setEmployeeFirstname("Dinesh");
	}

	@Test
	public void saveEmpTest() {

		when(repo.save(Mockito.any(TvmEmployee.class))).thenReturn(emp);

		TvmEmployee response = service.saveEmp(emp);

		assertNotNull(response);

	}

	@Test
	public void saveEmpTestFail() {

		emp.setEmployeeFirstname(null);

		when(repo.save(Mockito.any(TvmEmployee.class))).thenReturn(emp);

		TvmEmployee response = service.saveEmp(emp);

		assertNotNull(response);

	}

	/**
	 * 
	 */

	@Test
	public void testGetEmpWhenEmployeeExists() {
		// Arrange
		Integer employeeId = 1;
		TvmEmployee mockEmployee = new TvmEmployee(/* set employee properties here */);
		when(repo.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

		// Act
		Optional<TvmEmployee> result = service.getEmp(employeeId);

		// Assert
		assertTrue(result.isPresent());
		assertEquals(mockEmployee, result.get());
		verify(repo, times(1)).findById(employeeId);
	}

	@Test
	public void testGetEmpWhenEmployeeDoesNotExist() {
		// Arrange
		Integer nonExistentEmployeeId = 2;
		when(repo.findById(nonExistentEmployeeId)).thenReturn(Optional.empty());

		// Act
		Optional<TvmEmployee> result = service.getEmp(nonExistentEmployeeId);

		// Assert
		assertFalse(result.isPresent());
		verify(repo, times(1)).findById(nonExistentEmployeeId);
	}

	/**
	 * 
	 */
	@Test
	public void testGetAllEmp() {
		// Arrange
		TvmEmployee employee1 = new TvmEmployee(/* set employee1 properties here */);
		TvmEmployee employee2 = new TvmEmployee(/* set employee2 properties here */);

		List<TvmEmployee> mockEmployees = Arrays.asList(employee1, employee2);
		when(repo.findAll()).thenReturn(mockEmployees);

		// Act
		List<TvmEmployee> result = service.getAllEmp(employee1);

		// Assert
		assertEquals(2, result.size());
		assertEquals(mockEmployees, result);
		verify(repo, times(1)).findAll();
	}

	/**
	 * 
	 */

	@Test
	public void testUpdateEmployee() {
		// Arrange
		Integer employeeId = 1;
		TvmEmployee existingEmployee = new TvmEmployee(/* set existing employee properties here */);
		TvmEmployee updatedEmployee = new TvmEmployee(/* set updated employee properties here */);

		when(repo.findById(employeeId)).thenReturn(Optional.of(existingEmployee));
		when(repo.save(Mockito.any(TvmEmployee.class))).thenAnswer(invocation -> invocation.getArgument(0));

		// Act
		TvmEmployee result = service.updateEmployee(employeeId, updatedEmployee);

		// Assert
		assertNotNull(result);
		assertEquals(updatedEmployee.getEmployeeEmail(), result.getEmployeeEmail());
		assertEquals(updatedEmployee.getEmployeeeSalary(), result.getEmployeeeSalary());
		// ... repeat for other properties

		verify(repo, times(1)).findById(employeeId);
		verify(repo, times(1)).save(Mockito.any(TvmEmployee.class));
	}

	/**
	 * 
	 */

	@Test
	public void testDeleteEmployee() {
		// Arrange
		Integer employeeId = 1;

		// Act
		service.deleteEmployee(employeeId);

		// Assert
		verify(repo, times(1)).deleteById(employeeId);
	}

	/**
	 * 
	 */

	@Test
	public void testGetEmployeeBySalary() {
		// Arrange
		Long targetSalary = 50000L;
		TvmEmployee employee1 = new TvmEmployee(/* set employee1 properties here */);
		TvmEmployee employee2 = new TvmEmployee(/* set employee2 properties here */);

		List<TvmEmployee> mockEmployees = Arrays.asList(employee1, employee2);
		when(repo.getEmployeeBySalary(targetSalary)).thenReturn(mockEmployees);

		// Act
		List<TvmEmployee> result = service.getEmployeeBySalary(targetSalary);

		// Assert
		assertNotNull(result);
		assertEquals(mockEmployees.size(), result.size());
		assertEquals(mockEmployees, result);
		verify(repo, times(1)).getEmployeeBySalary(targetSalary);
	}

	/**
	 * 
	 */

	@Test
	public void testGetEmployeefirstName() {
		// Arrange
		String targetFirstName = "John";
		TvmEmployee employee1 = new TvmEmployee(/* set employee1 properties here */);
		TvmEmployee employee2 = new TvmEmployee(/* set employee2 properties here */);

		List<TvmEmployee> mockEmployees = Arrays.asList(employee1, employee2);
		when(repo.getEmployeefirstName(targetFirstName)).thenReturn(mockEmployees);

		// Act
		List<TvmEmployee> result = service.getEmployeefirstName(targetFirstName);

		// Assert
		assertNotNull(result);
		assertEquals(mockEmployees.size(), result.size());
		assertEquals(mockEmployees, result);
		verify(repo, times(1)).getEmployeefirstName(targetFirstName);
	}

	/**
	 * 
	 */

	@Test
	public void testGetEmployeeByLastName() {
		// Arrange
		String targetLastName = "Doe";
		TvmEmployee employee1 = new TvmEmployee(/* set employee1 properties here */);
		TvmEmployee employee2 = new TvmEmployee(/* set employee2 properties here */);

		List<TvmEmployee> mockEmployees = Arrays.asList(employee1, employee2);
		when(repo.getEmployeeBylastName(targetLastName)).thenReturn(mockEmployees);

		// Act
		List<TvmEmployee> result = service.getEmployeeBylastName(targetLastName);

		// Assert
		assertNotNull(result);
		assertEquals(mockEmployees.size(), result.size());
		assertEquals(mockEmployees, result);
		verify(repo, times(1)).getEmployeeBylastName(targetLastName);
	}

	/**
	 * 
	 */

	@Test
	public void testGetEmployeeByPassout() {
		// Arrange
		String targetYearOfPassout = "2022";
		Map<String, Object> employee1 = new HashMap<>();
		employee1.put("id", 1);
		employee1.put("name", "John Doe");
		employee1.put("salary", 50000L);
		employee1.put("department", "IT");

		Map<String, Object> employee2 = new HashMap<>();
		employee2.put("id", 2);
		employee2.put("name", "Jane Smith");
		employee2.put("salary", 60000L);
		employee2.put("department", "HR");

		List<Map<String, Object>> mockEmployees = Arrays.asList(employee1, employee2);
		when(repo.getEmployeeByPassout(targetYearOfPassout)).thenReturn(mockEmployees);

		// Act
		List<Map<String, Object>> result = service.getEmployeeByPassout(targetYearOfPassout);

		// Assert
		assertNotNull(result);
		assertEquals(mockEmployees.size(), result.size());
		assertEquals(mockEmployees, result);
		verify(repo, times(1)).getEmployeeByPassout(targetYearOfPassout);
	}

	/**
	 * 	   
	 */

	@Test
	public void testFindByAssestId() {
		// Arrange
		Integer targetAssestId = 123;
		TvmEmployee employee1 = new TvmEmployee(/* set employee1 properties here */);
		TvmEmployee employee2 = new TvmEmployee(/* set employee2 properties here */);

		List<TvmEmployee> mockEmployees = Arrays.asList(employee1, employee2);
		when(repo.findByAssestId(targetAssestId)).thenReturn(mockEmployees);

		// Act
		List<TvmEmployee> result = service.findByAssestId(targetAssestId);

		// Assert
		assertNotNull(result);
		assertEquals(mockEmployees.size(), result.size());
		assertEquals(mockEmployees, result);
		verify(repo, times(1)).findByAssestId(targetAssestId);
	}

	/**
	 * 
	 */

	@Test
	public void testFindByAssestlaptop() {
		// Arrange
		String targetLaptop = "Dell";
		TvmEmployee employee1 = new TvmEmployee(/* set employee1 properties here */);
		TvmEmployee employee2 = new TvmEmployee(/* set employee2 properties here */);

		List<TvmEmployee> mockEmployees = Arrays.asList(employee1, employee2);
		when(repo.findByAssestlaptop(targetLaptop)).thenReturn(mockEmployees);

		// Act
		List<TvmEmployee> result = service.findByAssestlaptop(targetLaptop);

		// Assert
		assertNotNull(result);
		assertEquals(mockEmployees.size(), result.size());
		assertEquals(mockEmployees, result);
		verify(repo, times(1)).findByAssestlaptop(targetLaptop);
	}

	/**
	 * 
	 */

	@Test
	public void testFindByUsersName() {
		// Arrange
		String targetUserName = "john.doe";
		TvmEmployee employee1 = new TvmEmployee(/* set employee1 properties here */);
		TvmEmployee employee2 = new TvmEmployee(/* set employee2 properties here */);

		List<TvmEmployee> mockEmployees = Arrays.asList(employee1, employee2);
		when(repo.getUsersByTechnology(targetUserName)).thenReturn(mockEmployees);

		// Act
		List<TvmEmployee> result = service.findByUsersName(targetUserName);

		// Assert
		assertNotNull(result);
		assertEquals(mockEmployees.size(), result.size());
		assertEquals(mockEmployees, result);
		verify(repo, times(1)).getUsersByTechnology(targetUserName);
	}

	/**
	 * 
	 */

	@Test
	public void testGetDataFromProject() {
		// Arrange
		TvmEmployee userData = new TvmEmployee(/* set user data properties here */);
		when(repo.save(userData)).thenReturn(userData);

		// Act
		TvmEmployee result = service.getDataFromProject(userData);

		// Assert
		assertNotNull(result);
		assertEquals(userData, result);
		verify(repo, times(1)).save(userData);
	}

	/**
	 * 
	 */

	@Test
	public void testGetStoretechDetails() {
		// Arrange
		TvmEmployee userData = new TvmEmployee(/* set user data properties here */);
		when(repo.save(userData)).thenReturn(userData);

		// Act
		TvmEmployee result = service.getStoretechDetails(userData);

		// Assert
		assertNotNull(result);
		assertEquals(userData, result);
		verify(repo, times(1)).save(userData);
	}

	/**
	 * 
	 */

	@Test
	public void testGetByEmpIdWithLogin() {
		// Arrange
		Integer targetEmployeeId = 1;
		// Inside your test method or setup method
		Map<String, Object> loginDetails1 = new HashMap<>();
		loginDetails1.put("username", "john.doe");
		loginDetails1.put("lastLogin", "2022-01-01T12:30:00");
		// Add more properties as needed

		Map<String, Object> loginDetails2 = new HashMap<>();
		loginDetails2.put("username", "jane.smith");
		loginDetails2.put("lastLogin", "2022-01-02T10:45:00");

		List<Map<String, Object>> mockLoginDetails = Arrays.asList(loginDetails1, loginDetails2);
		when(repo.getByEmpIdLogio(targetEmployeeId)).thenReturn(mockLoginDetails);

		// Act
		List<Map<String, Object>> result = service.getByEmpIdWithLogin(targetEmployeeId);

		// Assert
		assertNotNull(result);
		assertEquals(mockLoginDetails.size(), result.size());
		assertEquals(mockLoginDetails, result);
		verify(repo, times(1)).getByEmpIdLogio(targetEmployeeId);
	}

}