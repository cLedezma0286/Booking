package mx.com.demo;

import static io.muserver.openapi.ExternalDocumentationObjectBuilder.externalDocumentationObject;
import static io.muserver.openapi.InfoObjectBuilder.infoObject;
import static io.muserver.rest.CORSConfigBuilder.corsConfig;

import java.net.URI;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import io.muserver.openapi.OpenAPIObjectBuilder;
import io.muserver.rest.RestHandlerBuilder;
import mx.com.hsbc.exposer.ListReservationWriter;

public class RestHandlerBuilderLocal {
	  public static RestHandlerBuilder createRestHandler() {
	        return RestHandlerBuilder.restHandler(new MainController())
	            .withCORS(corsConfig().withAllowedOrigins("https://petstore.swagger.io"))
	            .withOpenApiHtmlUrl("/api.html")
	            .withOpenApiJsonUrl("/openapi.json")
	            .addCustomWriter(new ListReservationWriter())
	            .withOpenApiDocument(
	                OpenAPIObjectBuilder.openAPIObject()
	                    .withInfo(
	                        infoObject()
	                            .withTitle("User API Documentation")
	                            .withDescription("This is just a demo API that doesn't actually work!")
	                            .withVersion("1.0")
	                            .build())
	                    .withExternalDocs(
	                        externalDocumentationObject()
	                            .withDescription("Documentation docs")
	                            .withUrl(URI.create("https://muserver.io/jaxrs"))
	                            .build()
	                    )
	            )
	            .addCustomWriter(new JacksonJaxbJsonProvider())
                .addCustomReader(new JacksonJaxbJsonProvider());
	    }
}
