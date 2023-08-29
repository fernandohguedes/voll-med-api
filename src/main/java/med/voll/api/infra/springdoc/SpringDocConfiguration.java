package med.voll.api.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        // Configuração para expor o token na documentação
        var key = "bearer-key";
        var securitySchemesItem = new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");
        var components = new Components().addSecuritySchemes(key, securitySchemesItem);

        // Configuração de informações na documentação
        var tituloApi = "Voll.med API";
        var descricaoApi = "API Rest da aplicação Voll.med, contendo as funcionalidades de CRUD de médicos e de pacientes, " +
                "além de agendamento e cancelamento de consultas\"";
        var contato = new Contact().email("Time Backend").email("backend@voll.med");
        var licenca = new License().name("Apache 2.0").url("http://voll.med/api/licenca");
        var informacoesApi = new Info().title(tituloApi).description(descricaoApi).contact(contato).license(licenca);

        return new OpenAPI().components(components).info(informacoesApi);
    }
}
