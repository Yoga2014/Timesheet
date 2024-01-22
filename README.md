1.Save Employee Details API:
http://localhost:8082/tvm/saveEmployee (This API is used to save employee details)

2.Get Employee Details by ID API:
http://localhost:8082/tvm/getEmployee/{id} (This API is used to get employee details using the employee ID)

3.Get All Employee Details API:
http://localhost:8082/tvm/getAllEmployee (This API is used to retrieve all employee details)

4.Get Employee Details by Salary API:
http://localhost:8082/tvm/getAllEmployee/{salary} (This API is used to get employee details by salary)

5.Update Employee Details by ID API:
http://localhost:8082/tvm/updateEmp/{id} (This API is used to update employee details using the employee ID if it already exists)

6.Delete Employee Details by ID API:
http://localhost:8082/tvm/deleteEmp/{id} (This API is used to delete employee details using the employee ID)

7.Find Employee by First Name API:
http://localhost:8082/employeefirstname/{employeefirstname} (This API is used to find an employee by first name)

8.Find Employee by Last Name API:
http://localhost:8082/employeelastname/{employeelastname} (This API is used to find an employee by last name)

9.Find Employee by Year of Passout API:
http://localhost:8082/employeepassout/{yearofPassout} (This API is used to find an employee by the year of passout)

10.Get Employee Assets Details by Asset ID API:
http://localhost:8082/getEmployeeByAssestId/{assestId} (This API is used to get employee assets details using the asset ID)

11.Get Employee by Technologies Name API:
http://localhost:8082/getByTechName/{techname} (This API is used to get employees using technology names)

12.Get Login Details by Employee Name API:
http://localhost:8082/getBynameLogin/{employeefirstname} (This API is used to get login details by employee name)

11.Get Login Details by Employee ID API:
http://localhost:8082/getbyedlog/{employeeid} (This API is used to get login details by employee ID)

13.Save Login Details API:
http://localhost:8082/saveLogin (This API is used to save employee login details)

14.Save Logout Details API:
http://localhost:8082/saveLogout (This API is used to save employee logout details)


Save Employee Details API: JSON 
http://localhost:8082/tvm/saveEmployee (This API is used to save employee details)
 

{
    "employeeFirstname": "Ajith",
    "employeeLastname": "P",
    "employeeeSalary": 5000,
    "employeePhone": "87928765",
    "employeeEmail": "yesu@gmail.com",
    "employeeEducation": [
        {
            "yearofPassout": "2020",
            "percentage": "60%",
            "university": "Medras University"
        },
        {
            "yearofPassout": "2017",
            "percentage": "78%",
            "university": "Govt High School"
        }
    ],
    "employeeAddress": [
        {
            "street": "Super journey",
            "city": "Chennai",
            "state": "Tamilnadu",
            "country": "India"
        }
    ],
    "assest": {
        "laptop": "DELL ",
        "headphone": "BOAT",
        "charger": "DELL",
    },
    "employeeprojectdetails": [
        {
            "projectname": "Garuda"
        },
        {
            "projectname": "Gainswell"
        }
    ],
    "employeetechnologydetails": [
        {
            "techname": "springboot"
        },
         {
            "techname": "JAVA"
        }

    ]
}

Save Login Details API:JSON
http://localhost:8082/saveLogin (This API is used to save employee login details)


{
    "employee":{
        "employeeId":1
    }
}

Save Logout Details API:JSON
http://localhost:8082/saveLogout (This API is used to save employee logout details)


{
    "employee":{
        "employeeId":1
    }
}


