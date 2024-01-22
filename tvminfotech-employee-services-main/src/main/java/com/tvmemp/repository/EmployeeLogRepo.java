package com.tvmemp.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tvmemp.model.EmployeeLog;

public interface EmployeeLogRepo extends JpaRepository<EmployeeLog, Integer> {
	
	
	//Getting Log details using log Id

	@Query(value = "SELECT el.loginid,el.logindate,el.logintime,el.employeeid,eo.logid,eo.logoutdate,eo.logouttime,eo.employeeid "
			+ "FROM empoyeelog el INNER JOIN emplogout eo "
			+ "ON el.employeeid=eo.employeeid where eo.logid=:logid", nativeQuery = true)
	public List<Map<String,Object>> getBylogid(Integer logid);

}
