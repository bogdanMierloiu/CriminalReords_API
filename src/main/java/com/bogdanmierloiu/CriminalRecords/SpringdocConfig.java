package com.bogdanmierloiu.CriminalRecords;

import com.bogdanmierloiu.CriminalRecords.util.ReadJsonFileToJsonObject;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.io.IOException;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {


    @Bean
    public OpenAPI baseOpenAPI() throws IOException {

        ReadJsonFileToJsonObject readJsonFileToJsonObject = new ReadJsonFileToJsonObject();

        ApiResponse badRequestAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value(readJsonFileToJsonObject.read().get("badRequestResponse").toString()))
                )).description("Bad Request!");
        ApiResponse internalServerErrorAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value(readJsonFileToJsonObject.read().get("internalServerErrorResponse").toString())))
        ).description("Internal Server error!");

        Components components = new Components();
        components.addResponses("badRequestAPI", badRequestAPI);
        components.addResponses("internalServerErrorAPI", internalServerErrorAPI);

        return new OpenAPI()
                .components(components)
                .info(new Info().title("Documentation").version("1.0.0").description("Spring doc"));
    }

    @Bean
    public GroupedOpenApi authenticationAPI() {
        String[] paths = {"/auth/**"};
        return GroupedOpenApi.builder()
                .group("Authentication")
                .pathsToMatch(paths)
                .build();
    }
    @Bean
    public GroupedOpenApi postAPI() {
        String[] paths = {"/post/**"};
        return GroupedOpenApi.builder()
                .group("Post")
                .pathsToMatch(paths)
                .build();
    }
}
