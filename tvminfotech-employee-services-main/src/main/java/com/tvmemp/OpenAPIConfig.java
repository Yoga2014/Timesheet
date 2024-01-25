package com.tvmemp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "TVM-EMPLOYEE-SERVICE", description = "TVM Employee Details"),

		servers = { @Server(description = "Developer", url = "http://localhost:8080")

		},
		
security = @SecurityRequirement(
		name = "authBearer"
		)
)
@SecurityScheme(
		name = "authBearer",
		in = SecuritySchemeIn.HEADER,
		type = SecuritySchemeType.HTTP,
		bearerFormat ="jwt",
		scheme = "bearer",
		description = "Security desc"
		)
public class OpenAPIConfig {

}
