package us.pdavidson.throwdown;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("")
public class ThrowdownApp extends ResourceConfig{
    public ThrowdownApp(){
        packages("us.pdavidson.throwdown.resource");
//        register(LoggingFilter.class);
        register(JacksonFeature.class);
    }
}

