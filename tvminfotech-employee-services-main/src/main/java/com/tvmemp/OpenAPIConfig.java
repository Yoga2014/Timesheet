package com.tvmemp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				title = "TVM-EMPLOYEE-SERVICE",
				description = "TVM Employee Details"
				),
	
     servers= {
    		 @Server(
    				 description = "Developer",
    				 url = "http://localhost:8080"
    				 )
    		 
     }
)
public class OpenAPIConfig {

}
