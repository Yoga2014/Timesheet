package com.tvmemp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "TVM-EMPLOYEE-SERVICE", description = "TVM Employee Details"),

		servers = { @Server(description = "Developer", url = "http://localhost:8080")

		})

@SecurityScheme(name = "Author", in = SecuritySchemeIn.HEADER, type = SecuritySchemeType.HTTP, bearerFormat = "JWT", description = "Security Desc")
public class OpenAPIConfig {

}
