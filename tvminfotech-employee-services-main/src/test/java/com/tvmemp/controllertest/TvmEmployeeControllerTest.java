package com.tvmemp.controllertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tvmemp.controller.TvmEmployeeController;
import com.tvmemp.model.TvmEmployee;
import com.tvmemp.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class TvmEmployeeControllerTest {

	@InjectMocks
	TvmEmployeeController controller;

	@Mock
	EmployeeService service;

	/**
	 * 
	 */

	@Test
	public void testPostEmployee() {
		// Arrange
		TvmEmployee inputEmployee = new TvmEmployee(/* set employee properties here */);
		TvmEmployee savedEmployee = new TvmEmployee(/* set saved employee properties here */);

		when(service.saveEmp(inputEmployee)).thenReturn(savedEmployee);

		// Act
		TvmEmployee resultEmployee = controller.postEmployee(inputEmployee);

		// Assert
		assertNotNull(resultEmployee);
		assertEquals(savedEmployee, resultEmployee);

		verify(service, times(1)).saveEmp(inputEmployee);
	}

	/**
	 * 
	 */

	@Test
	public void testGetEmployee() {
		// Arrange
		Integer targetEmployeeId = 1;
		TvmEmployee expectedEmployee = new TvmEmployee(/* set employee properties here */);
		Optional<TvmEmployee> optionalEmployee = Optional.of(expectedEmployee);

		when(service.getEmp(targetEmployeeId)).thenReturn(optionalEmployee);

		// Act
		Optional<TvmEmployee> resultEmployee = controller.getEmployee(targetEmployeeId);

		// Assert
		assertNotNull(resultEmployee);
		assertTrue(resultEmployee.isPresent());

		TvmEmployee actualEmployee = resultEmployee.get();
		assertNotNull(actualEmployee);
		assertEquals(expectedEmployee, actualEmployee);

		verify(service, times(1)).getEmp(targetEmployeeId);
	}

	/**
	 * 
	 */

	@Test
	public void testGetAllEmployee() {
		// Arrange
		TvmEmployee employee = new TvmEmployee(/* set employee properties here */);
		List<TvmEmployee> expectedEmployees = Arrays.asList(/* create multiple TvmEmployee instances here */);

		when(service.getAllEmp()).thenReturn(expectedEmployees);

		// Act
		List<TvmEmployee> resultEmployees = controller.getAllEmployee();

		// Assert
		assertNotNull(resultEmployees);
		assertEquals(expectedEmployees.size(), resultEmployees.size());
		assertEquals(expectedEmployees, resultEmployees);

		verify(service, times(1)).getAllEmp();
	}

	/**
	 * 
	 */

	@Test
	public void testGetAllEmployeeBySalary() {
		// Arrange
		Long targetSalary = 50000L;
		List<TvmEmployee> expectedEmployees = Arrays.asList(/* create multiple TvmEmployee instances here */);

		when(service.getEmployeeBySalary(targetSalary)).thenReturn(expectedEmployees);

		// Act
		List<TvmEmployee> resultEmployees = controller.getAllEmployee(targetSalary);

		// Assert
		assertNotNull(resultEmployees);
		assertEquals(expectedEmployees.size(), resultEmployees.size());
		assertEquals(expectedEmployees, resultEmployees);

		verify(service, times(1)).getEmployeeBySalary(targetSalary);
	}

	/**
	 * 
	 */

	@Test
	public void testUpdateEmp() {
		// Arrange
		Integer targetEmployeeId = 1;
		TvmEmployee updatedEmployee = new TvmEmployee(/* set updated employee properties here */);

		// Assuming you have a mock request body
		TvmEmployee requestBody = new TvmEmployee(/* set request body properties here */);

		when(service.updateEmployee(targetEmployeeId, requestBody)).thenReturn(updatedEmployee);

		// Act
		TvmEmployee resultEmployee = controller.updateEmp(targetEmployeeId, requestBody);

		// Assert
		assertNotNull(resultEmployee);
		assertEquals(updatedEmployee, resultEmployee);

		verify(service, times(1)).updateEmployee(targetEmployeeId, requestBody);

	}

	/**
	 * 
	 */

	@Test
	public void testDeleteEmp() {
		// Arrange
		Integer targetEmployeeId = 1;

		// Act
		String resultMessage = controller.deleteEmp(targetEmployeeId);

		// Assert
		assertNotNull(resultMessage);
		assertEquals("Deleted Successfully !!!!", resultMessage);

		verify(service, times(1)).deleteEmployee(targetEmployeeId);
	}

	/**
	 * 
	 */

	@Test
	public void testGetAllEmployeebyName() {
		// Arrange
		String targetFirstName = "Dinesh";
		List<TvmEmployee> expectedEmployees = Arrays.asList(/* create multiple TvmEmployee instances here */);

		when(service.getEmployeefirstName(targetFirstName)).thenReturn(expectedEmployees);

		// Act
		List<TvmEmployee> resultEmployees = controller.getAllEmployeebyName(targetFirstName);

		// Assert
		assertNotNull(resultEmployees);
		assertEquals(expectedEmployees.size(), resultEmployees.size());
		assertEquals(expectedEmployees, resultEmployees);

		verify(service, times(1)).getEmployeefirstName(targetFirstName);
	}

	/**
	 * 
	 */

	@Test
	public void testGetAllEmployeebylastName() {
		// Arrange
		String targetLastName = "dinesh";
		List<TvmEmployee> expectedEmployees = Arrays.asList(/* create multiple TvmEmployee instances here */);

		when(service.getEmployeeBylastName(targetLastName)).thenReturn(expectedEmployees);

		// Act
		List<TvmEmployee> resultEmployees = controller.getAllEmployeebylastName(targetLastName);

		// Assert
		assertNotNull(resultEmployees);
		assertEquals(expectedEmployees.size(), resultEmployees.size());
		assertEquals(expectedEmployees, resultEmployees);

		verify(service, times(1)).getEmployeeBylastName(targetLastName);
	}

	/**
	 * 
	 */

	@Test
	public void testGetAllEmployeebyyearofPassout() {
		// Arrange
		String targetYearOfPassout = "2022";
		List<Map<String, Object>> expectedEmployees = Arrays
				.asList(/* create multiple Map<String, Object> instances here */);

		when(service.getEmployeeByPassout(targetYearOfPassout)).thenReturn(expectedEmployees);

		// Act
		List<Map<String, Object>> resultEmployees = controller.getAllEmployeebyyearofPassout(targetYearOfPassout);

		// Assert
		assertNotNull(resultEmployees);
		assertEquals(expectedEmployees.size(), resultEmployees.size());
		assertEquals(expectedEmployees, resultEmployees);

		verify(service, times(1)).getEmployeeByPassout(targetYearOfPassout);
	}

	/**
	 * 
	 */

	@Test
	public void testGetEmployeeByAssestId() {
		// Arrange
		Integer targetAssestId = 1;
		List<TvmEmployee> expectedEmployees = Arrays.asList(/* create multiple TvmEmployee instances here */);

		when(service.findByAssestId(targetAssestId)).thenReturn(expectedEmployees);

		// Act
		List<TvmEmployee> resultEmployees = controller.getEmployeeByAssestId(targetAssestId);

		// Assert
		assertNotNull(resultEmployees);
		assertEquals(expectedEmployees.size(), resultEmployees.size());
		assertEquals(expectedEmployees, resultEmployees);

		verify(service, times(1)).findByAssestId(targetAssestId);
	}

	/**
	 * 
	 */
	@Test
	public void testGetEmployeeByAssestlaptop() {
		// Arrange
		String targetLaptop = "MacBook";
		List<TvmEmployee> expectedEmployees = Arrays.asList(/* create multiple TvmEmployee instances here */);

		when(service.findByAssestlaptop(targetLaptop)).thenReturn(expectedEmployees);

		// Act
		List<TvmEmployee> resultEmployees = controller.getEmployeeByAssestlaptop(targetLaptop);

		// Assert
		assertNotNull(resultEmployees);
		assertEquals(expectedEmployees.size(), resultEmployees.size());
		assertEquals(expectedEmployees, resultEmployees);

		verify(service, times(1)).findByAssestlaptop(targetLaptop);
	}

	/**
	 * 
	 */

	@Test
	public void testGetByName() {
		// Arrange
		String targetTechName = "Java";
		List<TvmEmployee> expectedEmployees = Arrays.asList(/* create multiple TvmEmployee instances here */);

		when(service.findByUsersName(targetTechName)).thenReturn(expectedEmployees);

		// Act
		List<TvmEmployee> resultEmployees = controller.getByName(targetTechName);

		// Assert
		assertNotNull(resultEmployees);
		assertEquals(expectedEmployees.size(), resultEmployees.size());
		assertEquals(expectedEmployees, resultEmployees);

		verify(service, times(1)).findByUsersName(targetTechName);
	}

	/**
	 * 
	 */

	@Test
	public void testGetEmployeeNameWithInfoLogin() {
		// Arrange
		String targetFirstName = "John";
		List<Map<String, Object>> expectedLoginInfo = Arrays
				.asList(/* create multiple Map<String, Object> instances here */);

		when(service.getByNameWithLogin(targetFirstName)).thenReturn(expectedLoginInfo);

		// Act
		List<Map<String, Object>> resultLoginInfo = controller.getEmployeeNameWithInfoLogin(targetFirstName);

		// Assert
		assertNotNull(resultLoginInfo);
		assertEquals(expectedLoginInfo.size(), resultLoginInfo.size());
		assertEquals(expectedLoginInfo, resultLoginInfo);

		verify(service, times(1)).getByNameWithLogin(targetFirstName);
	}

	/**
	 * 
	 */

	@Test
	public void testGetByemployeeIdLog() {
		// Arrange
		Integer targetEmployeeId = 1;
		List<Map<String, Object>> expectedLoginInfo = Arrays
				.asList(/* create multiple Map<String, Object> instances here */);

		when(service.getByEmpIdWithLogin(targetEmployeeId)).thenReturn(expectedLoginInfo);

		// Act
		List<Map<String, Object>> resultLoginInfo = controller.getByemployeeIdLog(targetEmployeeId);

		// Assert
		assertNotNull(resultLoginInfo);
		assertEquals(expectedLoginInfo.size(), resultLoginInfo.size());
		assertEquals(expectedLoginInfo, resultLoginInfo);

		verify(service, times(1)).getByEmpIdWithLogin(targetEmployeeId);
	}

}
