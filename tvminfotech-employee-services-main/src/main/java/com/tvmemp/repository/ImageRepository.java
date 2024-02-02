package com.tvmemp.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tvmemp.model.EmployeeImage;

@Repository
public interface ImageRepository extends JpaRepository<EmployeeImage, Integer> {

	@Query(value = "SELECT elm.employee_id, elm.imageid, elm.image, "
	        + "te.employeeid, te.employeeemail, te.employeefirstname, "
	        + "te.employeelastname, te.employeephone, te.employeeesalary, "
	        + "te.assestid FROM employee_image elm LEFT JOIN "
	        + "tvmemployee te ON elm.employee_id = te.employeeid "
	        + "WHERE te.employeeid = :employeeid", nativeQuery = true)
	public List<Map<String, Object>> getEmployeeWithImageDetails(Integer employeeid);

}
