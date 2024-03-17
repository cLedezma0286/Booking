package mx.com.demo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.muserver.MuServer;
import io.muserver.MuServerBuilder;


public class MainServer {
	public static void main(String[] args) {
		Logger l = LoggerFactory.getLogger(MainServer.class);
        l.info("Hey! this is SLF4J example.");
  
        MuServer server = MuServerBuilder.httpServer()
                .addHandler(RestHandlerBuilderLocal.createRestHandler())
                .withHttpPort(9090)
                .start();
//		MuServer server = MuServerBuilder.httpServer()
//	            .addHandler(RestHandlerBuilder.restHandler(new MainController())
//	            		.addCustomWriter(new JacksonJaxbJsonProvider())
//	                    .addCustomReader(new JacksonJaxbJsonProvider()))
//	            .start();
        System.out.println("Started server at " + server.uri());
        System.out.println("API HTML: " + server.uri().resolve("/api.html"));
        System.out.println("API JSON: " + server.uri().resolve("/openapi.json"));
    }
	
}
