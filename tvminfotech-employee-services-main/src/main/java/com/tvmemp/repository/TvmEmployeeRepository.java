package com.tvmemp.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tvmemp.model.TvmEmployee;

public interface TvmEmployeeRepository extends JpaRepository<TvmEmployee, Integer> {

	/**
	 * 
	 * @param employeesalary
	 * @return
	 */
	@Query(value = "SELECT * from tvmemployee n WHERE n.employeesalary>:employeesalary", nativeQuery = true)
	public List<TvmEmployee> getEmployeeBySalary(Long employeesalary);

	/**
	 * 
	 * @param employeefirstname
	 * @return
	 */
	@Query(value = "SELECT * from tvmemployee n WHERE n.employeefirstname=:employeefirstname", nativeQuery = true)
	public List<TvmEmployee> getEmployeefirstName(String employeefirstname);

	/**
	 * 
	 * @param employeelastname
	 * @return
	 */
	@Query(value = "SELECT * from tvmemployee n WHERE n.employeelastname=:employeelastname", nativeQuery = true)
	public List<TvmEmployee> getEmployeeBylastName(String employeelastname);

	// Getting Employee details using passed out year
    /**
     * 
     * @param yearofPassout
     * @return
     */
	@Query(value = "SELECT t.assestid,t.employeeesalary,t.employeeemail,t.employeefirstname,t.employeelastname,t.employeephone,e.education_id, e.percentage, e.university, e.yearof_passout "
			+ "FROM tvmemployee t LEFT JOIN employeeeducation e " + "ON t.employeeid=e.employeeid "
			+ "WHERE e.yearof_passout=:yearofPassout", nativeQuery = true)

	public List<Map<String, Object>> getEmployeeByPassout(String yearofPassout);

	// Getting EmployeeAssest using employee id 
	
	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	@Query(value = "SELECT te.employeeid, te.employeeemail, te.employeefirstname, te.employeelastname, te.employeephone, te.employeeesalary, "
			+ "ea.assestid, ea.charger, ea.headphone, ea.laptop FROM tvmemployee te LEFT JOIN empassest ea ON te.assestid=ea.assestid "
			+ "WHERE te.employeeid=:employeeId", nativeQuery = true)
    public List<TvmEmployee> findByAssestId(Integer employeeId);
	
	/**
	 * 
	 * @param laptop
	 * @return
	 */
	@Query(value = "SELECT te.employeeid, te.employeeemail, te.employeefirstname, te.employeelastname, te.employeephone, te.employeeesalary, "
			+ "ea.assestid, ea.charger, ea.headphone, ea.laptop FROM tvmemployee te LEFT JOIN empassest ea ON te.assestid=ea.assestid "
			+ "WHERE ea.laptop=:laptop", nativeQuery = true)
    public List<TvmEmployee> findByAssestlaptop(String laptop);

	/**
	 * 
	 * @param employeeFirstname
	 * @return
	 */
	//Login, Logout Time GetByEmployeeName
	@Query(value="SELECT te.employeeid,te.employeeemail,te.employeefirstname,"
			+ "te.employeelastname,te.employeephone,te.employeeesalary,te.assestid,"
			+ "el.loginid,el.logindate,el.logintime,elo.logid,elo.logoutdate,"
			+ "elo.logouttime FROM tvmemployee te LEFT JOIN empoyeelog el "
			+ "ON te.employeeid=el.employeeid "
			+ "LEFT JOIN emplogout elo ON te.employeeid=elo.employeeid "
			+ "WHERE te.employeefirstname=:employeeFirstname", nativeQuery = true)
    public List<Map<String, Object>> getByNameLoginDetails(String employeeFirstname);
	
	@Query(value="SELECT te.employeeid,te.employeeemail,te.employeefirstname,"
			+ "te.employeelastname,te.employeephone,te.employeeesalary,te.assestid,"
			+ "el.loginid,el.logindate,el.logintime,elo.logid,elo.logoutdate,"
			+ "elo.logouttime FROM tvmemployee te LEFT JOIN empoyeelog el "
			+ "ON te.employeeid=el.employeeid "
			+ "LEFT JOIN emplogout elo ON te.employeeid=elo.employeeid "
			+ "WHERE te.employeeid=:employeeId", nativeQuery = true)
    public List<Map<String, Object>> getByEmpIdLogio(Integer employeeId);
	
	/**
	 * 
	 * @param techname
	 * @return
	 */
	@Query(value = "SELECT te.employeeid,te.employeeemail,te.employeefirstname,"+
			"te.employeelastname,te.employeephone,te.employeeesalary,te.assestid," +
	        "b.projectid, b.projectname, a.techid, a.techname " +
	        "FROM tvmemployee te " +
	        "LEFT JOIN employee_technolgy_details a ON te.employeeid = a.employeeid " +
	        "LEFT JOIN employee_project_details b ON te.employeeid = b.employeeid " +
	        "WHERE a.techname = :techname", nativeQuery = true)
      public List<TvmEmployee> getUsersByTechnology(@Param("techname") String techname);
}
